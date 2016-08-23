package org.akaza.openclinica.service.xform;

import org.akaza.openclinica.domain.xform.XformContents;
import org.akaza.openclinica.domain.xform.XformGroup;
import org.akaza.openclinica.domain.xform.XformItem;
import org.akaza.openclinica.domain.xform.XformParser;
import org.akaza.openclinica.domain.xform.dto.Html;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stevedibona on 5/31/16.
 */
@Component
public class XformService {

    @Autowired
    XformProcessorChain xformProcessorChain;

    public void processRequest() {

    }

    @Transactional
    public void runAsTransaction(String formName, String versionName, String versionDescription, String revisionNotes, String xform, List<MultipartFile> xformMedia, Errors errors) throws Exception {
    System.out.println("XformService received runAsTransaction() request.");

        // Parse instance and xform
        XformParser parser = new XformParser();
        XformContents xformContents = parseInstance(xform);
        Html html = parser.unMarshall(xform);


        XformContainer container = new XformContainer(formName,versionName,versionDescription,revisionNotes,xform,xformContents,xformMedia,html,errors);
        xformProcessorChain.processXform(container);

    }

    private XformContents parseInstance(String xform) throws Exception {

        // Could use the following xpath to get all leaf nodes in the case
        // of multiple levels of groups: //*[count(./*) = 0]
        // For now will assume a structure of /form/item or /form/group/item
        Document doc = null;
        try {
            InputStream stream = new ByteArrayInputStream(xform.getBytes(StandardCharsets.UTF_8));
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(stream);

            NodeList instances = doc.getElementsByTagName("instance");

            // All whitespace outside tags gets parsed as Text objects and returned
            // by the various Node methods. We need to ignore these and
            // focus on actual Elements

            Element instance = null;
            // List<XformItem> items = new ArrayList<XformItem>();
            List<XformGroup> groups = new ArrayList<>();

            // Get the primary instance
            for (int i = 0; i < instances.getLength(); i++) {
                Element curInstance = (Element) instances.item(i);
                if (curInstance instanceof Element) {
                    instance = curInstance;
                    break;
                }
            }

            // Get the form element
            Element form = null;
            for (int i = 0; i < instance.getChildNodes().getLength(); i++) {
                Node curNode = instance.getChildNodes().item(i);
                if (curNode instanceof Element) {
                    form = (Element) curNode;
                    break;
                }
            }

            // Get the groups and grouped items
            for (int i = 0; i < form.getChildNodes().getLength(); i++) {
                if (form.getChildNodes().item(i) instanceof Element && ((Element) form.getChildNodes().item(i)).hasChildNodes()
                        && !((Element) form.getChildNodes().item(i)).getTagName().equals("meta")) {
                    Element group = (Element) form.getChildNodes().item(i);
                    XformGroup newGroup = new XformGroup();
                    newGroup.setGroupName(group.getTagName());
                    newGroup.setGroupPath("/" + form.getTagName() + "/" + group.getTagName());
                    groups.add(newGroup);
                    for (int j = 0; j < group.getChildNodes().getLength(); j++) {
                        if (group.getChildNodes().item(j) instanceof Element) {
                            Element item = (Element) group.getChildNodes().item(j);
                            XformItem newItem = new XformItem();
                            newItem.setItemPath("/" + form.getTagName() + "/" + group.getTagName() + "/" + item.getTagName());
                            newItem.setItemName(item.getTagName());
                            // group is null;
                            newGroup.getItems().add(newItem);
                        }
                    }
                }
            }
            XformContents contents = new XformContents();
            contents.setGroups(groups);
            contents.setInstanceName(form.getTagName());
            return contents;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(ExceptionUtils.getStackTrace(e));
            throw new Exception(e);
        }
    }

    private String retrieveFormFieldValue(List<FileItem> items, String fieldName) throws Exception {
        for (FileItem item : items) {
            if (fieldName.equals(item.getFieldName()))
                return item.getString("UTF-8");
        }
        System.out.println("Form field '" + fieldName + "' missing from xform submission.");
        return "";
    }

}


package org.akaza.openclinica.web.rest;

import org.akaza.openclinica.service.xform.XformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stevedibona on 5/27/16.
 */
@RestController
public class XformController {

    @Autowired
    XformService xformService;


    @RequestMapping(value="/xform", method=RequestMethod.POST)
    public @ResponseBody String addXform(HttpServletRequest request, /*@RequestBody String xform,*/
                                         @RequestParam("formName") String formName,
                                         @RequestParam("versionName") String versionName,
                                         @RequestParam("versionDescription") String versionDescription,
                                         @RequestParam("revisionNotes") String revisionNotes,
                                         @RequestParam("xformContents") String xformContents,
                                         @RequestParam("file") MultipartFile[] mediaFiles) throws Exception {
        System.out.println("RestController received xform POST request.");
        System.out.println("Number of files received:  " + mediaFiles.length);

//        InputStream is = mediaFiles[0].getInputStream();
//        String StringFromInputStream = IOUtils.toString(is, "UTF-8");
//        System.out.println(StringFromInputStream);
        //Locale locale = LocaleResolver.getLocale(request);
        //ResourceBundleProvider.updateLocale(locale);
        //ResourceBundle resword = ResourceBundleProvider.getWordsBundle(locale);

        String customer = request.getServerName().split(".")[0];
        request.setAttribute("OC_DATASOURCE", "datasource1");
        request.setAttribute("OC_TENANT_SCHEMA", "tenant_1");

        // Create container for holding validation errors
        DataBinder dataBinder = new DataBinder(null);
        Errors errors = dataBinder.getBindingResult();

        List<MultipartFile> xformMedia = Arrays.asList(mediaFiles);

        xformService.runAsTransaction(formName,versionName,versionDescription,revisionNotes,xformContents,xformMedia,errors);
        //processRequest();
        return "Hello World";
    }
/*
    @RequestMapping(value="/xform/formName/{formName}/versionName/{versionName}/versionDescription/{versionDescription}/revisionNotes/{revisionNotes}", method=RequestMethod.POST)
    public @ResponseBody String addXform(HttpServletRequest request,
                                         @PathVariable("formName") String formName,@PathVariable("versionName") String versionName,
                                         @PathVariable("versionDescription") String versionDescription,@PathVariable("revisionNotes") String revisionNotes) throws Exception {
        //TODO:  Need to change the URL parameters.  Some of the should probably be moved into the request body or to URL Parameters
        System.out.println("RestController received xform POST request.");
        String xformContents = null;
        List<FileItem> xformMedia = new ArrayList<>();

        //Locale locale = LocaleResolver.getLocale(request);
        //ResourceBundleProvider.updateLocale(locale);
        //ResourceBundle resword = ResourceBundleProvider.getWordsBundle(locale);

        // Create container for holding validation errors
        DataBinder dataBinder = new DataBinder(null);
        Errors errors = dataBinder.getBindingResult();

        if (ServletFileUpload.isMultipartContent(request)) {
            //String dir = getAttachedFilePath(studyOID);
            FileProperties fileProperties = new FileProperties();
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(fileProperties.getFileSizeMax());
            List<FileItem> items = upload.parseRequest(request);
            System.out.println("Processing submission attachments");
            for (FileItem item : items) {
                if (item.getContentType() != null && !item.getFieldName().equals("xml_submission_file") ) {
                    //if (!new File(dir).exists()) new File(dir).mkdirs();

                    //File file = processUploadedFile(item, dir);
                    //System.out.println("    For field " + item.getFieldName() + ". Saved " + item.getName() + " to " + file.getPath());
                    //map.put(item.getFieldName()+"."+item.getName(), file.getPath());
                    //listOfUploadFilePaths.add(map);
                    xformMedia.add(item);

                } else if (item.getFieldName().equals("xml_submission_file")) {
                    xformContents = item.getString("UTF-8");
                }
            }
        } else  {
            xformContents = IOUtils.toString(request.getInputStream(), "UTF-8");
            //xformContents = request.getReader().toString();
        }


        xformService.runAsTransaction(formName,versionName,versionDescription,revisionNotes,xformContents,xformMedia,errors);
        //processRequest();
        return "Hello World";
    }

    */
}

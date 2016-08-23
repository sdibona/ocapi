package org.akaza.openclinica.service.xform;

import org.akaza.openclinica.domain.xform.XformContents;
import org.akaza.openclinica.domain.xform.dto.Html;
import org.springframework.validation.Errors;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by stevedibona on 5/31/16.
 */
public class XformContainer {
    String formName = null;
    String versionName = null;
    String versionDescription = null;
    String revisionNotes = null;
    String xform = null;
    XformContents xformContents = null;
    List<MultipartFile> xformMedia = null;
    Html html = null;
    Errors errors = null;

    public XformContainer(String formName, String versionName, String versionDescription, String revisionNotes, String xform, XformContents xformContents,
                          List<MultipartFile> xformMedia, Html html, Errors errors) {
        this.formName = formName;
        this.versionName = versionName;
        this.versionDescription = versionDescription;
        this.revisionNotes = revisionNotes;
        this.xform = xform;
        this.xformContents = xformContents;
        this.xformMedia = xformMedia;
        this.html = html;
        this.errors = errors;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getVersionDescription() {
        return versionDescription;
    }

    public void setVersionDescription(String versionDescription) {
        this.versionDescription = versionDescription;
    }

    public String getRevisionNotes() {
        return revisionNotes;
    }

    public void setRevisionNotes(String revisionNotes) {
        this.revisionNotes = revisionNotes;
    }

    public String getXform() {
        return xform;
    }

    public void setXform(String xform) {
        this.xform = xform;
    }

    public XformContents getXformContents() {
        return xformContents;
    }

    public void setXformContents(XformContents xformContents) {
        this.xformContents = xformContents;
    }

    public List<MultipartFile> getXformMedia() {
        return xformMedia;
    }

    public void setXformMedia(List<MultipartFile> xformMedia) {
        this.xformMedia = xformMedia;
    }

    public Html getHtml() {
        return html;
    }

    public void setHtml(Html html) {
        this.html = html;
    }

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }
}

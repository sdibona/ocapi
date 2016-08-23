package org.akaza.openclinica.web.rest.dto;

/**
 * Created by stevedibona on 6/8/16.
 */
public class XformRequest {

    String formName;
    String versionName;
    String versionDescription;
    String revisionNotes;
    String xform;

    public String getXform() {
        return xform;
    }

    public void setXform(String xform) {
        this.xform = xform;
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
}

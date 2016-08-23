package org.akaza.openclinica.service.xform.processor;

import org.akaza.openclinica.domain.dao.StudyDao;
import org.akaza.openclinica.domain.dao.UserAccountDao;
import org.akaza.openclinica.domain.datamap.CrfBean;
import org.akaza.openclinica.domain.datamap.CrfVersion;
import org.akaza.openclinica.domain.datamap.Study;
import org.akaza.openclinica.domain.datamap.UserAccount;
import org.akaza.openclinica.service.xform.XformContainer;
import org.akaza.openclinica.service.xform.XformMetaDataService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Created by stevedibona on 5/31/16.
 */
@Component
public class MetadataProcessor implements XformProcessor,Ordered {

    @Autowired
    XformMetaDataService xformMetaDataService;

    @Autowired
    StudyDao studyDao;

    @Autowired
    UserAccountDao userAccountDao;

    @Override
    public void process(XformContainer container) throws Exception {
        System.out.println("Executing MetadataProcessor");

        try {
            //TODO:  Hardcoded to always create new CRF with version.  Need logic to add new version to existing CRF
            CrfBean crf = new CrfBean();
            crf.setCrfId(0);
            CrfVersion version = new CrfVersion();
            version.setCrf(crf);
            //TODO:  The logic for setting up user and study needs to be changed.  Should also be cached in session.
            Study study = studyDao.findByStudyId(1);
            System.out.println("Fetched study has name: " + study.getName());

            study.setName("Steve Default Study Updated Name");
            study = studyDao.save(study);

            UserAccount user = userAccountDao.findByUserId(1);
            System.out.println("Fetched user account has username: " + user.getUserName());

            xformMetaDataService.createCRFMetaData(version, container.getXformContents(), study, user, container.getHtml(), container.getFormName(), container.getVersionName(),
                    container.getVersionDescription(), container.getRevisionNotes(), container.getXform(), container.getXformMedia(), container.getErrors());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(ExceptionUtils.getStackTrace(e));
            System.out.println("Got exception. Rethrowing to end app run.");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}


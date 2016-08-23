package org.akaza.openclinica.domain.dao;

import org.akaza.openclinica.domain.datamap.StudyModuleStatus;
import org.springframework.stereotype.Service;

/**
 * @author: Shamim
 * Date: Feb 18, 2009
 * Time: 8:01:42 PM
 */
@Service
public class StudyModuleStatusDao extends AbstractDomainDao<StudyModuleStatus> {
    @Override
    Class<StudyModuleStatus> domainClass() {
        return StudyModuleStatus.class;
    }

    public StudyModuleStatus findByStudyId(int studyId) {
        String query = "from " + getDomainClassName() + " sms  where sms.studyId = :studyId ";
        org.hibernate.Query q = getCurrentSession().createQuery(query);
        q.setInteger("studyId", studyId);
        return (StudyModuleStatus) q.uniqueResult();
    }

}

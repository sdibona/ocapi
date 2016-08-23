package org.akaza.openclinica.domain.dao;

import org.akaza.openclinica.domain.datamap.Study;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class StudyDao extends AbstractDomainDao<Study> {

    @Override
    public Class<Study> domainClass() {
        return Study.class;
    }

    public Study findByStudyId(Integer studyId) throws Exception {
        String query = "from " + Study.class.getName() + " do  where do.studyId = :study_id";
        Query q = entityManager.createQuery(query);
        q.setParameter("study_id", studyId);
        return (Study) q.getSingleResult();
    }
}

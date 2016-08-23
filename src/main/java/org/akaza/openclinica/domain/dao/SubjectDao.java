package org.akaza.openclinica.domain.dao;

import org.akaza.openclinica.domain.datamap.Subject;
import org.springframework.stereotype.Service;

@Service
public class SubjectDao extends AbstractDomainDao<Subject> {

    @Override
    Class<Subject> domainClass() {
        // TODO Auto-generated method stub
        return Subject.class;
    }
    
    public Subject findBySubjectId(Integer subjectId) {
        String query = "from " + getDomainClassName() + " do  where do.subjectId = :subject_id ";
        org.hibernate.Query q = getCurrentSession().createQuery(query);
        q.setInteger("subject_id", subjectId);
        return (Subject) q.uniqueResult();
    }

    public Subject findByUniqueIdentifier(String uniqueIdentifier) {
        String query = "from " + getDomainClassName() + " do  where do.uniqueIdentifier = :unique_identifier ";
        org.hibernate.Query q = getCurrentSession().createQuery(query);
        q.setString("unique_identifier", uniqueIdentifier);
        return (Subject) q.uniqueResult();
    }
}

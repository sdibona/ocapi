package org.akaza.openclinica.domain.dao;

import org.akaza.openclinica.domain.datamap.CompletionStatus;
import org.springframework.stereotype.Service;

@Service
public class CompletionStatusDao extends AbstractDomainDao<CompletionStatus> {

    @Override
    Class<CompletionStatus> domainClass() {
        // TODO Auto-generated method stub
        return CompletionStatus.class;
    }

    public CompletionStatus findByCompletionStatusId(int completion_status_id) {
        String query = "from " + getDomainClassName() + " completion_status  where completion_status.completionStatusId = :completionstatusid ";
        org.hibernate.Query q = getCurrentSession().createQuery(query);
        q.setInteger("completionstatusid", completion_status_id);
        return (CompletionStatus) q.uniqueResult();
    }


}

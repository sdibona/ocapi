package org.akaza.openclinica.domain.dao;

import java.util.ArrayList;
import java.util.List;

import org.akaza.openclinica.domain.datamap.IdtView;
import org.akaza.openclinica.domain.datamap.ItemData;
import org.akaza.openclinica.domain.datamap.EventDefinitionCrfItemTag;
import org.springframework.stereotype.Service;

@Service
public class EventDefinitionCrfItemTagDao extends AbstractDomainDao<EventDefinitionCrfItemTag> {

    @Override
    Class<EventDefinitionCrfItemTag> domainClass() {
        // TODO Auto-generated method stub
        return EventDefinitionCrfItemTag.class;
    }

    public List<EventDefinitionCrfItemTag> findAllByCrfPath(int tag_id, String crfPath, boolean active) {

        String query = " from " + getDomainClassName() + "  where " + " tag_id= " + tag_id + " and active=" + active + " and path LIKE '" + crfPath + ".%'";

        org.hibernate.Query q = getCurrentSession().createQuery(query);
        return (List<EventDefinitionCrfItemTag>) q.list();
    }

    public EventDefinitionCrfItemTag findByItemPath(int tag_id, boolean active, String itemPath) {

        String query = " from " + getDomainClassName() + "  where " + " tag_id= " + tag_id + " and active=" + active + " and path= '" + itemPath + "'";

        org.hibernate.Query q = getCurrentSession().createQuery(query);
        return (EventDefinitionCrfItemTag) q.uniqueResult();
    }

}

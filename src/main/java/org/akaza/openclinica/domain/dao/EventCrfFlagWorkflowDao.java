package org.akaza.openclinica.domain.dao;

import org.akaza.openclinica.domain.datamap.EventCrfFlagWorkflow;
import org.springframework.stereotype.Service;

@Service
public class EventCrfFlagWorkflowDao extends AbstractDomainDao<EventCrfFlagWorkflow> {

    @Override
    Class<EventCrfFlagWorkflow> domainClass() {
        // TODO Auto-generated method stub
        return EventCrfFlagWorkflow.class;
    }


}

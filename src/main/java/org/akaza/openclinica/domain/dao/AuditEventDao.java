package org.akaza.openclinica.domain.dao;

import org.akaza.openclinica.domain.datamap.AuditEvent;
import org.springframework.stereotype.Service;


@Service
public class AuditEventDao extends AbstractDomainDao<AuditEvent> {

	 @Override
	    public Class<AuditEvent> domainClass() {
	        return AuditEvent.class;
	    }
}

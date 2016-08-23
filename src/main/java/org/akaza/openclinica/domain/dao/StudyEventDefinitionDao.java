package org.akaza.openclinica.domain.dao;

import org.akaza.openclinica.domain.datamap.StudyEventDefinition;
import org.springframework.stereotype.Service;


@Service
public class StudyEventDefinitionDao extends AbstractDomainDao<StudyEventDefinition> {
	
    @Override
    public Class<StudyEventDefinition> domainClass() {
        return StudyEventDefinition.class;
    }
    
    public StudyEventDefinition findByStudyEventDefinitionId(int studyEventDefinitionId) {
        String query = "from " + getDomainClassName() + " study_event_definition  where study_event_definition.studyEventDefinitionId = :studyeventdefinitionid ";
        org.hibernate.Query q = getCurrentSession().createQuery(query);
        q.setInteger("studyeventdefinitionid", studyEventDefinitionId);
        return (StudyEventDefinition) q.uniqueResult();
    }

}

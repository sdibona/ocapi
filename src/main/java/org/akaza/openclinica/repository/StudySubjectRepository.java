package org.akaza.openclinica.repository;

import org.akaza.openclinica.domain.datamap.StudySubject;
import org.springframework.data.repository.CrudRepository;

public interface StudySubjectRepository extends CrudRepository<StudySubject, Long>{
    StudySubject findByStudySubjectId(Integer StudySubjectId);


}

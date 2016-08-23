package org.akaza.openclinica.web;

import org.akaza.openclinica.domain.datamap.StudySubject;
import org.akaza.openclinica.repository.StudySubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by stevedibona on 5/12/16.
 */
//@Component
public class DatabaseSpammerRunnable implements Runnable {

    //@Autowired
    //private StudySubjectRepository studySubjectRepository;

    private String schema = "tenant_1";
    private Integer loopSize = 50;
    private StudySubjectRepository studySubjectRepository = null;

    public DatabaseSpammerRunnable(String schema, Integer loopSize) {
        this.schema = schema;
        this.loopSize = loopSize;
    }
    public DatabaseSpammerRunnable() {
    }

    @Override
    public void run() {
        int i = 1;
        while (i < loopSize) {
            //System.out.println("Executing find # " + i + " on schema: " + schema);
            Iterable<StudySubject> studySubjects = studySubjectRepository.findAll();
            StudySubject firstSubject = studySubjects.iterator().next();
            System.out.println("Executed findAll # " + i + " on schema: " + schema + ". Example: " + firstSubject.getLabel());
            i++;
        }
    }

    public StudySubjectRepository getStudySubjectRepository() {
        return studySubjectRepository;
    }

    public void setStudySubjectRepository(StudySubjectRepository studySubjectRepository) {
        this.studySubjectRepository = studySubjectRepository;
    }
}

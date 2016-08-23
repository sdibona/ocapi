package org.akaza.openclinica.web;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.akaza.openclinica.domain.datamap.StudySubject;
import org.akaza.openclinica.repository.StudySubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/{tenantid}")
public class StudySubjectController {

	@Autowired
	private StudySubjectRepository studySubjectRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@RequestMapping
	public String studySubjects(@PathVariable String tenantid, Model model) {
		model.addAttribute("tenantid", tenantid);
		model.addAttribute("studySubject", new StudySubject());
		model.addAttribute("studySubjects", studySubjectRepository.findAll());

		System.out.println("Hello Steve");
		return "studySubjects";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Transactional
	public String addStudySubject(@ModelAttribute StudySubject studySubject, Model model) {
		studySubjectRepository.save(studySubject);
		return "redirect:/{tenantid}";
	}

}

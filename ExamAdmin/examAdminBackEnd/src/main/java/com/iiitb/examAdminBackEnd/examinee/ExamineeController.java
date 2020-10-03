package com.iiitb.examAdminBackEnd.examinee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExamineeController {
	@Autowired
	private ExamineeService examineeService;
	
	@RequestMapping("/examinees")
	public List<Examinee> getAllExaminees() {
		return examineeService.getAllExaminees();
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/examinees/{id}")
	public void deleteExaminee(@PathVariable int id) {
		examineeService.deleteExaminee(id);
	}
	
	@RequestMapping ("/examinees/{id}")
	public Optional<Examinee> getExaminee(@PathVariable int id) {
		return examineeService.getExaminee(id);
	}
}

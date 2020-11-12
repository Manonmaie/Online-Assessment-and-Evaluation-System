package com.iiitb.assessmentBackEnd.examinee;

import java.util.List;
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
	
	@RequestMapping("/registrationNo/{examineeCode}/password/{password}/examinee")
	public AsExaminee getAllExaminees(@PathVariable String examineeCode, @PathVariable String password) {
		return examineeService.getExamineeForRegistrationNumberAndPassword(examineeCode, password);
	}
	
//	@RequestMapping("/examinees")
//	public List<AsExaminee> getAllExaminees() {
//		return examineeService.getAllExaminees();
//	}
//	
//	@RequestMapping(method=RequestMethod.DELETE, value="/examinees/{id}")
//	public void deleteExaminee(@PathVariable int id) {
//		examineeService.deleteExaminee(id);
//	}
}
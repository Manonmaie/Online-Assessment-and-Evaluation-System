package com.iiitb.examAdminBackEnd.examinee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExamineeController {
	@Autowired
	private ExamineeService examineeService;
	
	 public void randomPassword(Examinee examinee) {
		 String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&?{}*";
		 StringBuilder builder = new StringBuilder();
		 int count = 8;
		 while (count-- != 0) {
		    int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
		    builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		 }
		 examinee.setExamineePassword(builder.toString());
	}
	
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
	
	@RequestMapping(method=RequestMethod.PUT, value="/examinees/{id}")
	public void updateExaminee(@PathVariable int id, @RequestBody Examinee examinee) {
		examineeService.updateExaminee(id, examinee);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/examinees")
	public void addExaminee(@RequestBody Examinee examinee) {
		randomPassword(examinee);
		examineeService.addExaminee(examinee);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/examineesBulk")
	public void addExaxmineeBulk(@RequestBody List<Examinee> examinees) {
		examinees.forEach(examinee->randomPassword(examinee));
		examineeService.addExamineeBulk(examinees);
	}
	
	@RequestMapping("/examineeByCode")
	public List<Examinee> getExamineeByCode(@RequestBody String code){
		return examineeService.getExamineeByCode(code);
	}
	
	@RequestMapping("/examineesByCode")
	public List<Examinee> getExamineesByCode(@RequestParam List<String> code){
		return examineeService.getExamineesByCode(code);
	}
	
	@RequestMapping("/examineesUpdatePassword")
	public void updatePasswords() {
		List<Examinee> examinees = getAllExaminees();
		examinees.forEach(examinee->randomPassword(examinee));
		addExaxmineeBulk(examinees);
	}
	
	@RequestMapping("/examineeCodes")
	public List<String> getCodes(){
		return examineeService.getCodes();
	}
}

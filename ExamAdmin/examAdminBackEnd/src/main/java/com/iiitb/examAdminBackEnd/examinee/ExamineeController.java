package com.iiitb.examAdminBackEnd.examinee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExamineeController {
	@Autowired
	private ExamineeService examineeService;
	
	@RequestMapping("/examinees")
	public List<EaExaminee> getAllExaminees() {
		return examineeService.getAllExaminees();
	}
}

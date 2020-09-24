package com.iiitb.examAdminBackEnd.examDrive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExamdriveController {
	
	@Autowired
	private ExamdriveService examdriveService;
	
	@RequestMapping("/examdrives")
	public List<Examdrive> getAllExamDrives() {
		return examdriveService.getAllExamDrives();
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/examdrives/{id}")
	public void deleteExamdrive(@PathVariable int id) {
		examdriveService.deleteExamdrive(id);
	}
}

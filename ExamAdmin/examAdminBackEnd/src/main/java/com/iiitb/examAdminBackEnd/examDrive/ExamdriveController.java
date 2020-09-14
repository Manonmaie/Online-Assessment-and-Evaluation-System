package com.iiitb.examAdminBackEnd.examDrive;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamdriveController {
	
	@Autowired
	private ExamdriveService examdriveService;
	
	@RequestMapping("/examdrives")
	public List<EaExamdrive> getAllExamDrives() {
		return examdriveService.getAllExamDrives();
	}
}

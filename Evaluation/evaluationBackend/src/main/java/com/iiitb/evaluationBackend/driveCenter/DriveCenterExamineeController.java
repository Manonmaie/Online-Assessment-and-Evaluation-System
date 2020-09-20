package com.iiitb.evaluationBackend.driveCenter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DriveCenterExamineeController {
	@Autowired
	private DriveCenterExamineeService examdriveService;
	
	@RequestMapping("/examdrives")
	public List<EvDriveCenterExaminee> getAllExamDrives() {
		return examdriveService.getAllExamDrives();
	}
}

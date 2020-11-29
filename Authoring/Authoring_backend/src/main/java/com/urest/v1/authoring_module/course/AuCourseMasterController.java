package com.urest.v1.authoring_module.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuCourseMasterController {
	@Autowired
	private AuCourseMasterService auCourseMasterService;
	
	@RequestMapping("/urest/v1/getallCourses")
	public List<AuCourseMaster> getAllCourses() {
		return auCourseMasterService.getAllCourses();
	}
}




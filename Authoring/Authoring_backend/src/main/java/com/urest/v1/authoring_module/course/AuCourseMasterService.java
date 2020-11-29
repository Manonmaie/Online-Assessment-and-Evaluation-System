package com.urest.v1.authoring_module.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuCourseMasterService {
	@Autowired
	private AuCourseMasterRepository auCourseMasterRepository;
	
	public List<AuCourseMaster> getAllCourses() {
		List<AuCourseMaster> courseList = new ArrayList<>();
		auCourseMasterRepository.findAll()
		.forEach(courseList::add);
		return courseList;
	}
}

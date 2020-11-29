package com.iiitb.assessmentBackEnd.courseMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseMasterService {
	@Autowired
	private CourseMasterRepository courseMasterRepository;
	
	public void addCourseMaster(AsCourseMaster courseMaster) {
		courseMasterRepository.save(courseMaster);
	}
	
	public void addCourseMasterBulk(List<AsCourseMaster> courses) {
		courseMasterRepository.saveAll(courses);
	}
}

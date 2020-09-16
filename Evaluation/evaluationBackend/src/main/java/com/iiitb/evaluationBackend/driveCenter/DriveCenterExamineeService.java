package com.iiitb.evaluationBackend.driveCenter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriveCenterExamineeService {
	@Autowired
	private DriveCenterExamineeRepository examdriveRepository;
	
	public List<EvDriveCenterExaminee> getAllExamDrives() {
		List<EvDriveCenterExaminee> examdrives = new ArrayList<>();
		examdriveRepository.findAll().forEach(examdrives::add);
		return examdrives;
	}
}

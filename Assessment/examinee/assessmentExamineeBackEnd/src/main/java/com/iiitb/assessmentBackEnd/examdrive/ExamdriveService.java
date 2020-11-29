package com.iiitb.assessmentBackEnd.examdrive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamdriveService {
	@Autowired
	private ExamdriveRepository examdriveRepository;
	
	public void addExamDrive(AsExamdrive examdrive) {
		examdriveRepository.save(examdrive);
	}
}

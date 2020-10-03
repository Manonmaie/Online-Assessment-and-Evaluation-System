package com.iiitb.examAdminBackEnd.examdrive;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamdriveService {
	
	@Autowired
	private ExamdriveRepository examdriveRepository;
	
//	private List<ExamDrive> examDrives = Arrays.asList(
//			new ExamDrive(1,"MID","Mid Term Examination"),
//			new ExamDrive(1,"END","End Term Examination"),
//			new ExamDrive(1,"IMP","Improvement Examination")
//			);
	
	public List<Examdrive> getAllExamDrives() {
		List<Examdrive> examdrives = new ArrayList<>();
		examdriveRepository.findAll().forEach(examdrives::add);
		return examdrives;
	}

	public void deleteExamdrive(int id) {
		examdriveRepository.deleteById(id);
	}
}

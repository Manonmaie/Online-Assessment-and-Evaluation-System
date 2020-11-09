package com.iiitb.examAdminBackEnd.examdrive;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	public void addExamdrive(Examdrive examdrive) {
		examdriveRepository.save(examdrive);
	}
	
	public Optional<Examdrive> getExamdrive(int id){
		return examdriveRepository.findById(id);
	}
	
	public void updateExamdrive(int id,Examdrive examdrive) {
		examdriveRepository.save(examdrive);
	}
}

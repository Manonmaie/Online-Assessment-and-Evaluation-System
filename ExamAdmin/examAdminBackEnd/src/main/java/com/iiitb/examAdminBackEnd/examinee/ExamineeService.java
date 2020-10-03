package com.iiitb.examAdminBackEnd.examinee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamineeService {
	@Autowired
	private ExamineeRepository examineeRepository;
	
	public List<Examinee> getAllExaminees() {
		List<Examinee> examinees = new ArrayList<>();
		examineeRepository.findAll().forEach(examinees::add);
		return examinees;
	}

	public void deleteExaminee(int id) {
		examineeRepository.deleteById(id);
	}
	
	public Optional<Examinee> getExaminee(int id){
		return examineeRepository.findById(id);
	}
	
	public void updateExaminee(int id,Examinee examinee) {
		examineeRepository.save(examinee);
	}
}

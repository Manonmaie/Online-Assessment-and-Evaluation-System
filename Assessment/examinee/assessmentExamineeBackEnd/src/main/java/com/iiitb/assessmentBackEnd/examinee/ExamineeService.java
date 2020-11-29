package com.iiitb.assessmentBackEnd.examinee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamineeService {
	@Autowired
	private ExamineeRepository examineeRepository;
	
	public AsExaminee getExamineeForRegistrationNumberAndPassword(String examineeCode, String password) {
		return examineeRepository.findByExamineeCodeAndExamineePassword(examineeCode, password);
	}
	
//	public List<AsExaminee> getAllExaminees() {
//		List<AsExaminee> examinees = new ArrayList<>();
//		examineeRepository.findAll().forEach(examinees::add);
//		return examinees;
//	}
//
//	public void deleteExaminee(int id) {
//		examineeRepository.deleteById(id);
//	}
	
	public void addExaminee(AsExaminee examinee) {
		examineeRepository.save(examinee);
	}
}
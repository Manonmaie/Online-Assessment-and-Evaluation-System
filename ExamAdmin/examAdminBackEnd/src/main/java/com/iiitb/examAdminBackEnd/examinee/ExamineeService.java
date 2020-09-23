package com.iiitb.examAdminBackEnd.examinee;

import java.util.ArrayList;
import java.util.List;

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
}

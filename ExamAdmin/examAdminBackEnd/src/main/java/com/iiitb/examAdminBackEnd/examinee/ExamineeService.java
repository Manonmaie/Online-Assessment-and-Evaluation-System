package com.iiitb.examAdminBackEnd.examinee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.examAdminBackEnd.examineeBatch.ExamineeBatchMarks;
import com.iiitb.examAdminBackEnd.examineeBatch.ExamineeBatchMarksRepository;

@Service
public class ExamineeService {
	@Autowired
	private ExamineeRepository examineeRepository;
	
	@Autowired
	private ExamineeBatchMarksRepository examineeBatchMarksRepository;
	
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
	
	public void addExaminee(Examinee examinee) {
//		examinee.setExamineeBatchList((List<ExamineeBatch>) examineeBatchRepository.saveAll(examinee.getExamineeBatchList()));
		examineeRepository.save(examinee);
	}
	
	public void addExamineeBulk(List<Examinee> examinees) {
//		Integer maxIntId = examineeRepository.findMaxId();
//		int maxId = 0;
//		if(maxIntId!=null) {
//			maxId = maxIntId;
//		}
//		for(int i=0;i<examinees.size();i++) {
//			examinees.get(i).setExamineeId(maxId+1);
//			maxId++;
//		}
		examineeRepository.saveAll(examinees);
	}
	
	public List<Examinee> getExamineeByCode(String code){
		return examineeRepository.findByExamineeCode(code);
	}
	
	public List<Examinee> getExamineesByCode(List<String> codes){
		return examineeRepository.findByExamineeCodeIn(codes);
	}
}

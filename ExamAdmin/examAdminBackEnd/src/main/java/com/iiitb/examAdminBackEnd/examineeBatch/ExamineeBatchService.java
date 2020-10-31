package com.iiitb.examAdminBackEnd.examineeBatch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamineeBatchService {

	@Autowired
	ExamineeBatchRepository examineeBatchRepository;
	
	public void updateExamineeBatch(ExamineeBatchKey examineeBatchKey, ExamineeBatch examineeBatch) {
		examineeBatchRepository.save(examineeBatch);
	}
	
	public List<ExamineeBatch> getExamineeBatchByExamdriveId(int id){
		return examineeBatchRepository.findByBatchExamdriveExamdriveId(id);
	}
	
	public List<ExamineeBatch> getExamineeBatchByExamineeId(int id){
		return examineeBatchRepository.findByExamineeExamineeId(id);
	}
}

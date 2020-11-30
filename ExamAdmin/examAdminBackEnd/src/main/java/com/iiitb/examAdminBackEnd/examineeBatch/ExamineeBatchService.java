package com.iiitb.examAdminBackEnd.examineeBatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamineeBatchService {

	@Autowired
	ExamineeBatchMarksRepository examineeBatchMarksRepository;
	
	@Autowired
	ExamineeBatchRepository examineeBatchRepository;
	
	public List<ExamineeBatch> getAllExamineeBatches(){
		List<ExamineeBatch> examineeBatches = new ArrayList<>();
		examineeBatchRepository.findAll().forEach(examineeBatches::add);
		return examineeBatches;
	}
	
	public void addExamineeBatches(List<ExamineeBatch> examineeBatches) {
		examineeBatchRepository.saveAll(examineeBatches);
	}
	
	public void updateExamineeBatch(ExamineeBatchKey examineeBatchKey, ExamineeBatchMarks examineeBatchMarks) {
		examineeBatchMarksRepository.save(examineeBatchMarks);
	}
	
	public List<ExamineeBatchMarks> getExamineeBatchByExamdriveId(int id){
		return examineeBatchMarksRepository.findByBatchExamdriveExamdriveId(id);
	}
	
	public List<ExamineeBatchMarks> getExamineeBatchByExamineeId(int id){
		return examineeBatchMarksRepository.findByExamineeExamineeId(id);
	}
	
	public List<ExamineeBatch> getExamineesOfBatch(int id){
		return examineeBatchRepository.findByBatchBatchId(id);
	}
	
	public Optional<ExamineeBatch> getExamineeBatchByExamineeBatchId(int id) {
		return examineeBatchRepository.findByExamineeBatchId(id);
	}
}

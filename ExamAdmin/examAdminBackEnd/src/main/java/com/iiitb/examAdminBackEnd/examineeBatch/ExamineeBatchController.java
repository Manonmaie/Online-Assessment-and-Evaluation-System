package com.iiitb.examAdminBackEnd.examineeBatch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExamineeBatchController {
	
	@Autowired
	public ExamineeBatchService examineeBatchService;
	
	@RequestMapping(method = RequestMethod.PUT, value="examineeBatch/examinee/{examineeId}/batch/{batchId}")
	public void updateExamineeBatch(@PathVariable int examineeId, @PathVariable int batchId, @RequestBody ExamineeBatchMarks examineeBatchMarks) {
		ExamineeBatchKey key = new ExamineeBatchKey(examineeId, batchId);
		examineeBatchService.updateExamineeBatch(key, examineeBatchMarks);
	}
	
	@RequestMapping("examineeBatchByExamdrive/{id}")
	public List<ExamineeBatchMarks> getExamineeBatchByExamdriveId(@PathVariable int id){
		return examineeBatchService.getExamineeBatchByExamdriveId(id);
	}
	
	@RequestMapping("examineeBatchByExaminee/{id}")
	public List<ExamineeBatchMarks> getExamineeBatchByExamineeId(@PathVariable int id){
		return examineeBatchService.getExamineeBatchByExamineeId(id);
	}
	
	@RequestMapping("examineeBatches")
	public List<ExamineeBatch> getAllExamineeBatches(){
		return examineeBatchService.getAllExamineeBatches();
	}
	
	@RequestMapping("examineeBatches/{id}")
	public List<ExamineeBatch> getExamineesOfBatch(@PathVariable int id){
		return examineeBatchService.getExamineesOfBatch(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/examineeBatchBulk")
	public void addExamineeBatches(@RequestBody List<ExamineeBatch> examineeBatches) {
		examineeBatchService.addExamineeBatches(examineeBatches);
	}
}

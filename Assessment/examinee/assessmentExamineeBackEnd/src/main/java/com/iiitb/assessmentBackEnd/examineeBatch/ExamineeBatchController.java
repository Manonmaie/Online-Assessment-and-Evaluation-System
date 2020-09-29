package com.iiitb.assessmentBackEnd.examineeBatch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExamineeBatchController {

	@Autowired
	public ExamineeBatchService examineeBatchService;
	
	@RequestMapping("/examinee/{examineeId}/batch/{batchId}")
	public AsExamineeBatch getExamineeBatchFromExamineeAndBatchIds(@PathVariable int examineeId, @PathVariable int batchId){
		return examineeBatchService.getExamineeBatchFromExamineeAndBatchIds(examineeId, batchId);
	}
}

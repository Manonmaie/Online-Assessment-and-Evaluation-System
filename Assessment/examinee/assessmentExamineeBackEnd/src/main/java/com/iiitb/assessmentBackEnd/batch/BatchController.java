package com.iiitb.assessmentBackEnd.batch;

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
public class BatchController {
	
	@Autowired
	private BatchService batchService;
	
	@RequestMapping("/batch/{batchId}")
	public AsBatch getBatchForBatchId(@PathVariable int batchId) {
		return batchService.getBatchForBatchId(batchId);
	}
	
	@RequestMapping("/completedBatchesResponses")
	public List<AsBatch> getAllCompletedBatchesToExport() {
		return batchService.getAllCompletedBatchesToExport();
	}
	
	@RequestMapping("/batchesWithSendResponses/{qpStatus}")
	public List<AsBatch> getAllBatchesForQpStatus(@PathVariable String qpStatus) {
		return batchService.getAllBatchesForQpStatus(qpStatus);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/batch/{batchId}")
	public void updateBatch(@PathVariable int batchId,@RequestBody AsBatch batch) {
		batchService.updateBatch(batch);
	}
}

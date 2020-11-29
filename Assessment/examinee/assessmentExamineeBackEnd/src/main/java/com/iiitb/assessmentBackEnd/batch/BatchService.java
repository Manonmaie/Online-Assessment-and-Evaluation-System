package com.iiitb.assessmentBackEnd.batch;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchService {
	
	@Autowired
	private BatchRepository batchRepository;
	
	public AsBatch getBatchForBatchId(int batchId) {
		return batchRepository.findByBatchId(batchId);
	}
	
	public List<AsBatch> getAllCompletedBatchesToExport() {
		return batchRepository.findDistinctByQpStatusAndAsExamineeBatchListExamineeBatchStatus("RECEIVED", "COMPLETED");
	}
	
	public List<AsBatch> getAllBatchesForQpStatus(String qpStatus) {
		return batchRepository.findByQpStatus(qpStatus);
	}
	
	public void updateBatch(AsBatch batch) {
		batchRepository.save(batch);
	}
	
	public void addBatch(AsBatch batch) {
		batchRepository.save(batch);
	}
}

package com.iiitb.assessmentBackEnd.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchService {
	
	@Autowired
	private BatchRepository batchRepository;
	
	public List<AsBatch> getAllCompletedBatchesToExport() {
		return batchRepository.findDistinctByQpStatusAndAsExamineeBatchListExamineeBatchStatus("RECEIVED", "COMPLETED");
	}
}

package com.iiitb.examAdminBackEnd.batch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchService {

	@Autowired
	private BatchRepository batchRepository;
	
	public List<Batch> getBatchesByExamdrive(int id){
		return batchRepository.findByExamdriveExamdriveId(id);
	}
}

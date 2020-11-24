package com.iiitb.examAdminBackEnd.batch;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchService {

	@Autowired
	private BatchRepository batchRepository;
	
	public Optional<Batch> getBatch(int id) {
		return batchRepository.findById(id);
	}
	
	public List<Batch> getBatchesByExamdrive(int id){
		return batchRepository.findByExamdriveExamdriveId(id);
	}
	
	public void deleteBatches(List<Batch> batches) {
		batchRepository.deleteAll(batches);
	}
	
	public void deleteBatch(int id) {
		batchRepository.deleteById(id);
	}
	
	public void updateBatch(int id, Batch batch) {
		batchRepository.save(batch);
	}
	
	public void addBatch(Batch batch) {
		batchRepository.save(batch);
	}
	
	public void addBatches(List<Batch> batches) {
		batchRepository.saveAll(batches);
	}
}

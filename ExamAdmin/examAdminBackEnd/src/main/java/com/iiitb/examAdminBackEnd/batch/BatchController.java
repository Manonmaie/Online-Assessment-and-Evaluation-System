package com.iiitb.examAdminBackEnd.batch;

import java.util.List;
import java.util.Optional;

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
	
	@RequestMapping("batchByExamdrive/{id}")
	public List<Batch> getBatchesByExamdrive(@PathVariable int id){
		return batchService.getBatchesByExamdrive(id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/batches")
	public void deleteBatches(@RequestBody List<Batch> batches) {
		batchService.deleteBatches(batches);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/batches/{id}")
	public void deleteBatch(@PathVariable int id) {
		batchService.deleteBatch(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/batches/{id}")
	public void updateBatch(@PathVariable int id, @RequestBody Batch batch) {
		batchService.updateBatch(id, batch);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/batchesBulk")
	public void updateBatches(@RequestBody List<Batch> batches) {
		batchService.updateBatches(batches);
	}
	
	@RequestMapping(method =RequestMethod.POST, value="/batches")
	public void addBatch(@RequestBody Batch batch) {
		batchService.addBatch(batch);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/batchesBulk")
	public void addBatches(@RequestBody List<Batch> batches) {
		batchService.addBatches(batches);
	}
	
	@RequestMapping("/batches/{id}")
	public Optional<Batch> getBatch(@PathVariable int id) {
		return batchService.getBatch(id);
	}
	
	@RequestMapping("/batchCodes")
	public List<String> getCodes(){
		return batchService.getCodes();
	}
}

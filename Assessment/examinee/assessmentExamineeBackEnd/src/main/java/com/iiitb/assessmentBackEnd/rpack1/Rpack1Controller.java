package com.iiitb.assessmentBackEnd.rpack1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiitb.assessmentBackEnd.batch.AsBatch;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Rpack1Controller {

	@Autowired
	private Rpack1Service rpack1Service;
	
	@RequestMapping("/batch/{batchId}/Rpack1")
	public AsBatch getBatchForBatchId(@PathVariable int batchId) {
		return rpack1Service.getBatchForBatchId(batchId);
	}
}

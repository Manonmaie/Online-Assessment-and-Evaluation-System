package com.iiitb.assessmentBackEnd.rpack3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Rpack3Service {
	@Autowired
	private Rpack3Repository rpack3Repository;
	
	public void addRpack3(Rpack3 rpack3) {
		rpack3Repository.save(rpack3);
	}
	
	public void addRpack3Bulk(List<Rpack3> rpack3s) {
		rpack3Repository.saveAll(rpack3s);
	}
	
	public void deleteAll() {
		rpack3Repository.deleteAll();
	}
}

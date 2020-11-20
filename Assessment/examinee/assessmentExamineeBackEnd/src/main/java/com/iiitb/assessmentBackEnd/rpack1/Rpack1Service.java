package com.iiitb.assessmentBackEnd.rpack1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Rpack1Service {
	@Autowired
	private Rpack1Repository rpack1Repository;
	
	public void addRpack1(Rpack1 rpack1) {
		rpack1Repository.save(rpack1);
	}
	
	public void addRpack1Bulk(List<Rpack1> rpack1s) {
		rpack1Repository.saveAll(rpack1s);
	}
	
	public void deleteAll() {
		rpack1Repository.deleteAll();
	}
}

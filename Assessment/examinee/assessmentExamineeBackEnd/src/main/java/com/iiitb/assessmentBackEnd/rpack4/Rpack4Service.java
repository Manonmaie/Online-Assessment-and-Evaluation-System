package com.iiitb.assessmentBackEnd.rpack4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Rpack4Service {
	@Autowired
	private Rpack4Repository rpack4Repository;
	
	public void addRpack4(Rpack4 rpack4) {
		rpack4Repository.save(rpack4);
	}
	
	public void addRpack4Bulk(List<Rpack4> rpack4s) {
		rpack4Repository.saveAll(rpack4s);
	}
	
	public void deleteAll() {
		rpack4Repository.deleteAll();
	}
}

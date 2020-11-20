package com.iiitb.assessmentBackEnd.rpack2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Rpack2Service {
	@Autowired
	private Rpack2Repository rpack2Repository;
	
	public void addRpack2(Rpack2 rpack2) {
		rpack2Repository.save(rpack2);
	}
	
	public void addRpack2Bulk(List<Rpack2> rpack2s) {
		rpack2Repository.saveAll(rpack2s);
	}
	
	public void deleteAll() {
		rpack2Repository.deleteAll();
	}
}

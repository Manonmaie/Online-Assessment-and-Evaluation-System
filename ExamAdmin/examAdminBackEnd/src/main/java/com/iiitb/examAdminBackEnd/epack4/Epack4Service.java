package com.iiitb.examAdminBackEnd.epack4;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Epack4Service {
	@Autowired
	private Epack4Repository epack4Repository;
	
	public void addEpack4(Epack4 epack4) {
		epack4Repository.save(epack4);
	}
	
	public Optional<Epack4> getEpack4(int id){
		return epack4Repository.findById(id);
	}
	
	public void addEpack4Bulk(List<Epack4> epack4s) {
		epack4Repository.saveAll(epack4s);
	}
	
	public void deleteAll() {
		epack4Repository.deleteAll();
	}
}

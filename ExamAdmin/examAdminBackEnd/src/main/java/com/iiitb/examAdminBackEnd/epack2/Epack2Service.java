package com.iiitb.examAdminBackEnd.epack2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Epack2Service {
	@Autowired
	private Epack2Repository epack2Repository;
	
	public void addEpack2(Epack2 epack2) {
		epack2Repository.save(epack2);
	}
	
	public Optional<Epack2> getEpack2(int id){
		return epack2Repository.findById(id);
	}
	
	public void addEpack2Bulk(List<Epack2> epack2s) {
		epack2Repository.saveAll(epack2s);
	}
	
	public void deleteAll() {
		epack2Repository.deleteAll();
	}
}

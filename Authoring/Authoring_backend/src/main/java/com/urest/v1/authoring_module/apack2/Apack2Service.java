package com.urest.v1.authoring_module.apack2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Apack2Service {
	@Autowired
	private Apack2Repository apack2Repository;
	
	public void addApack2(Apack2 apack2) {
		apack2Repository.save(apack2);
	}
	
	public Optional<Apack2> getApack2(int id){
		return apack2Repository.findById(id);
	}
	
	public void addApack2Bulk(List<Apack2> apack2s) {
		apack2Repository.saveAll(apack2s);
	}
	
	public void deleteAll() {
		apack2Repository.deleteAll();
	}
}

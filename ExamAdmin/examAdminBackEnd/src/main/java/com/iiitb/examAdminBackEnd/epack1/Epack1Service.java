package com.iiitb.examAdminBackEnd.epack1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Epack1Service {
	
	@Autowired
	private Epack1Repository epack1Repository;
	
	public void addEpack1(Epack1 epack1) {
		epack1Repository.save(epack1);
	}
	
	public Optional<Epack1> getEpack1(int id){
		return epack1Repository.findById(id);
	}
	
	public void addEpack1Bulk(List<Epack1> epack1s) {
		epack1Repository.saveAll(epack1s);
	}
}

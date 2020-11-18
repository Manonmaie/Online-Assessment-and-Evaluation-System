package com.iiitb.examAdminBackEnd.epack3;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Epack3Service {
	@Autowired
	private Epack3Repository epack3Repository;
	
	public void addEpack3(Epack3 epack3) {
		epack3Repository.save(epack3);
	}
	
	public Optional<Epack3> getEpack3(int id){
		return epack3Repository.findById(id);
	}
	
	public void addEpack3Bulk(List<Epack3> epack3s) {
		epack3Repository.saveAll(epack3s);
	}
	
	public void deleteAll() {
		epack3Repository.deleteAll();
	}
}

package com.urest.v1.authoring_module.qpack3;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Qpack3Service {
	
	@Autowired
	private Qpack3Repository qpack3Repository;
	
	public void addQpack3(Qpack3 qpack3) {
		qpack3Repository.save(qpack3);
	}
	
	public Qpack3 getQpack3(int id){
		return qpack3Repository.findById(id);
	}
	
	public void addQpack3Bulk(List<Qpack3> qpack3s) {
		qpack3Repository.saveAll(qpack3s);
	}
	
	public void deleteAll() {
		qpack3Repository.deleteAll();
	}
}

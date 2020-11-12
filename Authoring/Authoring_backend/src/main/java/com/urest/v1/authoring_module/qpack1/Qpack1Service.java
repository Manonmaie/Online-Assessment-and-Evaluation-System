package com.urest.v1.authoring_module.qpack1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Qpack1Service {
	
	@Autowired
	private Qpack1Repository qpack1Repository;
	
	public void addQpack1(Qpack1 qpack1) {
		qpack1Repository.save(qpack1);
	}
	
	public Optional<Qpack1> getQpack1(int id){
		return qpack1Repository.findById(id);
	}
	
	public void addQpack1Bulk(List<Qpack1> qpack1s) {
		qpack1Repository.saveAll(qpack1s);
	}
}

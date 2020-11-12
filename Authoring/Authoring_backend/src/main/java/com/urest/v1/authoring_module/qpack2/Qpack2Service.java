package com.urest.v1.authoring_module.qpack2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Qpack2Service {
	
	@Autowired
	private Qpack2Repository qpack2Repository;
	
	public void addQpack2(Qpack2 qpack2) {
		qpack2Repository.save(qpack2);
	}
	
	public Optional<Qpack2> getQpack2(int id){
		return qpack2Repository.findById(id);
	}
	
	public void addQpack2Bulk(List<Qpack2> qpack2s) {
		qpack2Repository.saveAll(qpack2s);
	}
}

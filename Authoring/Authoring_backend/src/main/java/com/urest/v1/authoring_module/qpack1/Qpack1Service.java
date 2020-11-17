package com.urest.v1.authoring_module.qpack1;

import java.util.ArrayList;
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
	
	public Qpack1 getQpack1(int id){
		return qpack1Repository.findById(id);
	}
	
	public void addQpack1Bulk(List<Qpack1> qpack1s) {
		qpack1Repository.saveAll(qpack1s);
	}
	
	public List<Qpack1> getUniqueQpQpacks(){
		List<Qpack1> qpack1s = new ArrayList<Qpack1>();
		List<Object[]> qpIdQpack1Id = qpack1Repository.getUniqueQPQpacks();
		for(int i = 0; i < qpIdQpack1Id.size(); i++) {
			qpack1Repository.findById((Integer)qpIdQpack1Id.get(i)[1]).ifPresent(qpack1s::add);
		}
		return qpack1s;
	}
	
	public void deleteAll() {
		qpack1Repository.deleteAll();
	}
}

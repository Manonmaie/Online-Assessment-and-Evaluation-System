package com.urest.v1.authoring_module.apack1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Apack1Service {
	@Autowired
	private Apack1Repository apack1Repository;
	
	public void addApack1(Apack1 apack1) {
		apack1Repository.save(apack1);
	}
	
	public List<Apack1> getAllApack1s() {
		List<Apack1> apack1s = new ArrayList<>();
		apack1Repository.findAll().forEach(apack1s::add);
		return apack1s;
	}

	public void deleteApack1(int id) {
		apack1Repository.deleteById(id);
	}
	
	public Optional<Apack1> getApack(int id){
		return apack1Repository.findById(id);
	}

	public Apack1 getApack1ByQpItemId(int qp_item_id) {
		return apack1Repository.getApack1ByQpItemId(qp_item_id);
	}
	
	public void deleteAll() {
	apack1Repository.deleteAll();
	}
}

package com.urest.v1.authoring_module.apack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urest.v1.authoring_module.apack1.Apack1;
import com.urest.v1.authoring_module.apack1.Apack1Service;
import com.urest.v1.authoring_module.apack2.Apack2;
import com.urest.v1.authoring_module.apack2.Apack2Service;

@Service
public class ApackService {
	@Autowired
	private ApackRepository apackRepository;
	
	@Autowired
	private ApackJoinRepository apackJoinRepository;
	
	@Autowired
	private Apack1Service apack1Service;
	
	@Autowired
	private Apack2Service apack2Service;
	
	public List<Apack> getAllApacks() {
		List<Apack> apacks = new ArrayList<>();
		apackRepository.findAll().forEach(apacks::add);
		return apacks;
	}

	public void deleteApack(int id) {
		apackRepository.deleteById(id);
	}
	
	public Optional<Apack> getApack(int id){
		return apackRepository.findById(id);
	}
	
	public void addApack() {
		apack2Service.deleteAll();
		apack1Service.deleteAll();
		//Generate Apack
		Apack apack = new Apack();
		apack.setApack_desc("Nothing");
		apack.setCreated_on(LocalDateTime.now());
		apack.setCreated_by("Author");
		apack.setApack_status("CREATED");
		apackRepository.save(apack);
		
		//Generate Apack1
		List<Object[]> apack1Objects = apackJoinRepository.fetchApack1Data();
		for(int i = 0; i < apack1Objects.size(); i++) {
			Apack1 apack1 = new Apack1((Integer)apack1Objects.get(i)[0], (Integer)apack1Objects.get(i)[1], (Integer)apack1Objects.get(i)[2], String.valueOf(apack1Objects.get(i)[3]), (Float)apack1Objects.get(i)[4], String.valueOf(apack1Objects.get(i)[5]));
			apack1.setApack_header(apack);
			apack1Service.addApack1(apack1);
		}
		
		//Generate Apack2
		List<Object[]> apack2McqObjects = apackJoinRepository.fetchApack2McqData();
		for(int i = 0; i < apack2McqObjects.size(); i++) {
			Apack2 apack2 = new Apack2((Integer)apack2McqObjects.get(i)[0], (Integer)apack2McqObjects.get(i)[1], (Integer)apack2McqObjects.get(i)[2], String.valueOf(apack2McqObjects.get(i)[3]), (Integer)apack2McqObjects.get(i)[4]);
			apack2.setApack1(apack1Service.getApack1ByQpItemId(apack2.getQp_item_id()));
			apack2Service.addApack2(apack2);
		}
		List<Object[]> apack2TFObjects = apackJoinRepository.fetchApack2TFData();
		for(int i = 0; i < apack2TFObjects.size(); i++) {
			Apack2 apack2True = new Apack2((Integer)apack2TFObjects.get(i)[0], (Integer)apack2TFObjects.get(i)[1], (Integer)apack2TFObjects.get(i)[2], "True", (Integer)apack2TFObjects.get(i)[3]);
			apack2True.setApack1(apack1Service.getApack1ByQpItemId(apack2True.getQp_item_id()));
			apack2Service.addApack2(apack2True);
			
			Apack2 apack2False = new Apack2((Integer)apack2TFObjects.get(i)[0], (Integer)apack2TFObjects.get(i)[1], (Integer)apack2TFObjects.get(i)[2], "False", (Integer)apack2TFObjects.get(i)[4]);
			apack2False.setApack1(apack1Service.getApack1ByQpItemId(apack2False.getQp_item_id()));
			apack2Service.addApack2(apack2False);
		}
	}
}

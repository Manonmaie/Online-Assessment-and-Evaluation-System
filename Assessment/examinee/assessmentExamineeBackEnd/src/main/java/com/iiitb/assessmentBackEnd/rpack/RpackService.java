package com.iiitb.assessmentBackEnd.rpack;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.assessmentBackEnd.rpack1.Rpack1;
import com.iiitb.assessmentBackEnd.rpack1.Rpack1Service;
import com.iiitb.assessmentBackEnd.rpack2.Rpack2;
import com.iiitb.assessmentBackEnd.rpack2.Rpack2Service;
import com.iiitb.assessmentBackEnd.rpack3.Rpack3;
import com.iiitb.assessmentBackEnd.rpack3.Rpack3Service;

@Service
public class RpackService {
	@Autowired
	private RpackRepository rpackRepository;
	
	@Autowired
	private RpackJoinRepository rpackJoinRepository;
	
	@Autowired
	private Rpack1Service rpack1Service;
	
	@Autowired
	private Rpack2Service rpack2Service;
	
	@Autowired
	private Rpack3Service rpack3Service;
	
	public List<Rpack> getAllRpacks() {
		List<Rpack> rpacks = new ArrayList<>();
		rpackRepository.findAll().forEach(rpacks::add);
		return rpacks;
	}
	
	public void deleteRpack(int id) {
		rpackRepository.deleteById(id);
	}
	
	public void addRpack() {
		
		rpack3Service.deleteAll();
		rpack2Service.deleteAll();
		rpack1Service.deleteAll();
		
		//Generate Qpack
		Rpack rpack = new Rpack();
		rpack.setRpack_desc("Nothing");
		rpack.setCreated_on(LocalDateTime.now());
		rpack.setCreated_by("Author");
		rpack.setRpack_status("CREATED");
		rpackRepository.save(rpack);
		
		//Generate Rpack2
		Map<Integer, Rpack1> qp_id2Rpack1 = new HashMap<Integer, Rpack1>();
		
		List<Object[]> rpack1Objects = rpackJoinRepository.fetchRpack1Data();
		for(int i = 0; i < rpack1Objects.size(); i++) {
			Rpack1 rpack1 = new Rpack1((Integer)rpack1Objects.get(i)[0],(Float)rpack1Objects.get(i)[1],(Integer)rpack1Objects.get(i)[2],(Integer)rpack1Objects.get(i)[3]);
			rpack1.setRpack_header(rpack);
			rpack1Service.addRpack1(rpack1);
			
			if(!qp_id2Rpack1.containsKey(rpack1.getQp_id())) {
				qp_id2Rpack1.put(rpack1.getQp_id(), rpack1);
			}
		}
		
		//Generate Rpack2
		Map<Integer, Rpack2> qp_item_id2Rpack2 = new HashMap<Integer, Rpack2>();
		
		for (Map.Entry mapElement : qp_id2Rpack1.entrySet()) {
			List<Object[]> rpack2Objects = rpackJoinRepository.fetchRpack2Data((int)mapElement.getKey());
			for(int i = 0; i < rpack2Objects.size(); i++) {
				Rpack2 rpack2 = new Rpack2((Integer)rpack2Objects.get(i)[0], (Integer)rpack2Objects.get(i)[1], String.valueOf(rpack2Objects.get(i)[2]), (Float)rpack2Objects.get(i)[3], String.valueOf(rpack2Objects.get(i)[4]), String.valueOf(rpack2Objects.get(i)[5]));
				rpack2.setRpack1((Rpack1)mapElement.getValue());
				rpack2Service.addRpack2(rpack2);
				
				if(!qp_item_id2Rpack2.containsKey(rpack2.getQp_item_id())) {
					qp_item_id2Rpack2.put(rpack2.getQp_item_id(), rpack2);
				}
			}
		}
		
		//Generate Epack3
		for (Map.Entry mapElement : qp_item_id2Rpack2.entrySet()) {
			List<Object[]> rpack3McqObjects = rpackJoinRepository.fetchRpack3McqData((int)mapElement.getKey());
			for(int i = 0; i < rpack3McqObjects.size(); i++) {
				Rpack3 rpack3 = new Rpack3((Integer)rpack3McqObjects.get(i)[0], (Integer)rpack3McqObjects.get(i)[1], String.valueOf(rpack3McqObjects.get(i)[2]));
				rpack3.setRpack2((Rpack2)mapElement.getValue());
				rpack3Service.addRpack3(rpack3);
			}
			
			List<Object[]> rpack3TFObjects = rpackJoinRepository.fetchRpack3TFData((int)mapElement.getKey());
			for(int i = 0; i < rpack3TFObjects.size(); i++) {
				Rpack3 rpack3True = new Rpack3((Integer)rpack3TFObjects.get(i)[0], (Integer)rpack3TFObjects.get(i)[1], "True");
				rpack3True.setRpack2((Rpack2)mapElement.getValue());
				rpack3Service.addRpack3(rpack3True);
				
				Rpack3 rpack3False = new Rpack3((Integer)rpack3TFObjects.get(i)[0], (Integer)rpack3TFObjects.get(i)[1], "False");
				rpack3False.setRpack2((Rpack2)mapElement.getValue());
				rpack3Service.addRpack3(rpack3False);
			}
		}
	}
	
	public Optional<Rpack> getRpack(int id){
		return rpackRepository.findById(id);
	}
}

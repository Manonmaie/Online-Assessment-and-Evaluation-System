package com.urest.v1.authoring_module.qpack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urest.v1.authoring_module.qpack1.Qpack1;
import com.urest.v1.authoring_module.qpack1.Qpack1Service;
//import com.urest.v1.authoring_module.qpack2.Qpack2;
//import com.urest.v1.authoring_module.qpack2.Qpack2Service;

@Service
public class QpackService {
	
	@Autowired
	private QpackRepository qpackRepository;
	
	@Autowired
	private QpackJoinRepository qpackJoinRepository;
	
	@Autowired
	private Qpack1Service qpack1Service;
	
//	@Autowired
//	private Qpack2Service qpack2Service;
	
	public List<Qpack> getAllQpacks() {
		List<Qpack> qpacks = new ArrayList<>();
		qpackRepository.findAll().forEach(qpacks::add);
		return qpacks;
	}

	public void deleteQpack(int id) {
		qpackRepository.deleteById(id);
	}
	
	public void addQpack() {
		Qpack qpack = new Qpack();
		qpack.setQpack_desc("Nothing");
		qpack.setCreated_on(LocalDateTime.now());
		qpack.setCreated_by("Author");
		qpack.setQpack_status("CREATED");
		qpackRepository.save(qpack);
		
		List<Object[]> qpack1Objects = qpackJoinRepository.fetchQpack1Data();
		List<Qpack1> qpack1s = new ArrayList<Qpack1>();
		for(int i = 0; i < qpack1Objects.size(); i++) {
			Object[] course = qpackJoinRepository.getCourseByCode(String.valueOf(qpack1Objects.get(i)[5]));
			qpack1s.add(new Qpack1((Integer)qpack1Objects.get(i)[0],(Integer)qpack1Objects.get(i)[1], (Integer)qpack1Objects.get(i)[2], String.valueOf(qpack1Objects.get(i)[3]), (Integer)qpack1Objects.get(i)[4], (Integer)course[0], String.valueOf(qpack1Objects.get(i)[5]), String.valueOf(course[2]), String.valueOf(qpack1Objects.get(i)[6])));
			
		}
		qpack1s.forEach( (qpack1) -> qpack1.setQpack_header(qpack));
		qpack1Service.addQpack1Bulk(qpack1s);
//		List<Qpack2> qpack2s = qpackJoinRepository.fetchQpack2Data();
//		qpack2s.forEach( (qpack2) -> qpack2.setQpack1(qpack1s.get(0)));
//		qpack2Service.addQpack2Bulk(qpack2s);
	}
	
	public Optional<Qpack> getQpack(int id){
		return qpackRepository.findById(id);
	}
}


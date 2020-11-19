package com.urest.v1.authoring_module.qpack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urest.v1.authoring_module.qpack1.Qpack1;
import com.urest.v1.authoring_module.qpack1.Qpack1Service;
import com.urest.v1.authoring_module.qpack2.Qpack2;
import com.urest.v1.authoring_module.qpack2.Qpack2Service;
import com.urest.v1.authoring_module.qpack3.Qpack3;
import com.urest.v1.authoring_module.qpack3.Qpack3Service;

@Service
public class QpackService {
	
	@Autowired
	private QpackRepository qpackRepository;
	
	@Autowired
	private QpackJoinRepository qpackJoinRepository;
	
	@Autowired
	private Qpack1Service qpack1Service;
	
	@Autowired
	private Qpack2Service qpack2Service;
	
	@Autowired
	private Qpack3Service qpack3Service;
	
	public List<Qpack> getAllQpacks() {
		List<Qpack> qpacks = new ArrayList<>();
		qpackRepository.findAll().forEach(qpacks::add);
		return qpacks;
	}

	public void deleteQpack(int id) {
		qpackRepository.deleteById(id);
	}
	
	public void addQpack() {
		qpack3Service.deleteAll();
		qpack2Service.deleteAll();
		qpack1Service.deleteAll();
		
		//Generate Qpack
		Qpack qpack = new Qpack();
		qpack.setQpack_desc("Nothing");
		qpack.setCreated_on(LocalDateTime.now());
		qpack.setCreated_by("Author");
		qpack.setQpack_status("CREATED");
		qpackRepository.save(qpack);
		
		//Generate Qpack1
		List<Object[]> qpack1Objects = qpackJoinRepository.fetchQpack1Data();
		List<Qpack1> qpack1s = new ArrayList<Qpack1>();
		for(int i = 0; i < qpack1Objects.size(); i++) {
			List<Object[]> course = qpackJoinRepository.getCourseByCode(String.valueOf(qpack1Objects.get(i)[5]));
			if(!course.isEmpty()) {
				if(qpack1Objects.get(i)[2] != null) {
					qpack1s.add(new Qpack1((Integer)qpack1Objects.get(i)[0],(Integer)qpack1Objects.get(i)[1], (Integer)qpack1Objects.get(i)[2], String.valueOf(qpack1Objects.get(i)[3]), (Integer)qpack1Objects.get(i)[4], (Integer)course.get(0)[0], String.valueOf(qpack1Objects.get(i)[5]), String.valueOf(course.get(0)[2]), String.valueOf(qpack1Objects.get(i)[6])));
				}
				else {
					qpack1s.add(new Qpack1((Integer)qpack1Objects.get(i)[0],(Integer)qpack1Objects.get(i)[1], (Integer)qpack1Objects.get(i)[4], (Integer)course.get(0)[0], String.valueOf(qpack1Objects.get(i)[5]), String.valueOf(course.get(0)[2]), String.valueOf(qpack1Objects.get(i)[6])));
				}
			}
//			course_id and course_name should always be present(NOT NULL). ensure course_code is correct in question paper.
//			else {
//				if(qpack1Objects.get(i)[2] != null) {
//					qpack1s.add(new Qpack1((Integer)qpack1Objects.get(i)[0],(Integer)qpack1Objects.get(i)[1], (Integer)qpack1Objects.get(i)[2], String.valueOf(qpack1Objects.get(i)[3]), (Integer)qpack1Objects.get(i)[4], String.valueOf(qpack1Objects.get(i)[5]), String.valueOf(qpack1Objects.get(i)[6])));
//				}
//				else {
//					qpack1s.add(new Qpack1((Integer)qpack1Objects.get(i)[0],(Integer)qpack1Objects.get(i)[1], (Integer)qpack1Objects.get(i)[4], String.valueOf(qpack1Objects.get(i)[5]), String.valueOf(qpack1Objects.get(i)[6])));
//				}
//			}
			
		}
		qpack1s.forEach( (qpack1) -> qpack1.setQpack_header(qpack));
		qpack1Service.addQpack1Bulk(qpack1s);
		
		//Generate Qpack2
		List<Qpack1> uniqueQpQpack1s = qpack1Service.getUniqueQpQpacks();
		for(int i = 0; i < uniqueQpQpack1s.size(); i++) {
			List<Object[]> qpack2Objects = qpackJoinRepository.fetchQpack2Data(uniqueQpQpack1s.get(i).getQp_id());
			for(int j = 0; j < qpack2Objects.size(); j++) {
				Qpack2 qpack2 = new Qpack2((Integer)qpack2Objects.get(j)[0], (Integer)qpack2Objects.get(j)[1], (Integer)qpack2Objects.get(j)[2], String.valueOf(qpack2Objects.get(j)[3]), (Float)qpack2Objects.get(j)[4], String.valueOf(qpack2Objects.get(j)[5]), String.valueOf(qpack2Objects.get(j)[6]));
				qpack2.setQpack1(uniqueQpQpack1s.get(i));
				qpack2Service.addQpack2(qpack2);
			}
		}
		
		//Generate Qpack3
		List<Object[]> qpack3McqObjects = qpackJoinRepository.fetchQpack3McqData();
		for(int i = 0; i < qpack3McqObjects.size(); i++) {
			Qpack3 qpack3 = new Qpack3((Integer)qpack3McqObjects.get(i)[0], (Integer)qpack3McqObjects.get(i)[1], (Integer)qpack3McqObjects.get(i)[2], String.valueOf(qpack3McqObjects.get(i)[3]));
			qpack3.setQpack2(qpack2Service.getQpack2ByQpItemId(qpack3.getQp_item_id()));
			qpack3Service.addQpack3(qpack3);
		}
		List<Object[]> qpack3TFObjects = qpackJoinRepository.fetchQpack3TFData();
		for(int i = 0; i < qpack3TFObjects.size(); i++) {
			Qpack3 qpack3True = new Qpack3((Integer)qpack3TFObjects.get(i)[0], (Integer)qpack3TFObjects.get(i)[1], (Integer)qpack3McqObjects.get(i)[2], "True");
			qpack3True.setQpack2(qpack2Service.getQpack2ByQpItemId(qpack3True.getQp_item_id()));
			qpack3Service.addQpack3(qpack3True);
			
			Qpack3 qpack3False = new Qpack3((Integer)qpack3TFObjects.get(i)[0], (Integer)qpack3TFObjects.get(i)[1], (Integer)qpack3McqObjects.get(i)[2], "False");
			qpack3False.setQpack2(qpack2Service.getQpack2ByQpItemId(qpack3False.getQp_item_id()));
			qpack3Service.addQpack3(qpack3False);
		}
		
	}
	
	public Optional<Qpack> getQpack(int id){
		return qpackRepository.findById(id);
	}
}


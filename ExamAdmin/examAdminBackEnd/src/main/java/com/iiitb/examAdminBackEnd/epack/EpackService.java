package com.iiitb.examAdminBackEnd.epack;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.examAdminBackEnd.epack1.Epack1;
import com.iiitb.examAdminBackEnd.epack1.Epack1Service;
import com.iiitb.examAdminBackEnd.epack2.Epack2;
import com.iiitb.examAdminBackEnd.epack2.Epack2Service;
import com.iiitb.examAdminBackEnd.epack3.Epack3;
import com.iiitb.examAdminBackEnd.epack3.Epack3Service;
import com.iiitb.examAdminBackEnd.epack4.Epack4;
import com.iiitb.examAdminBackEnd.epack4.Epack4Service;

@Service
public class EpackService {
	
	@Autowired
	private EpackRepository epackRepository;
	
	@Autowired
	private EpackJoinRepository epackJoinRepository;
	
	@Autowired
	private Epack1Service epack1Service;
	
	@Autowired
	private Epack2Service epack2Service;
	
	@Autowired
	private Epack3Service epack3Service;
	
	@Autowired
	private Epack4Service epack4Service;
	
	public List<Epack> getAllEpacks() {
		List<Epack> epacks = new ArrayList<>();
		epackRepository.findAll().forEach(epacks::add);
		return epacks;
	}

	public void deleteEpack(int id) {
		epackRepository.deleteById(id);
	}
	
	public void addEpack(int center_id) {
		
		epack3Service.deleteAll();
		epack2Service.deleteAll();
		epack1Service.deleteAll();
		
		//Generate Epack
		Epack epack = new Epack();
		epack.setEpack_desc("Nothing");
		epack.setCreated_on(LocalDateTime.now());
		epack.setCreated_by("Author");
		epack.setEpack_status("CREATED");
		epack.setCenter_id(center_id);
		epackRepository.save(epack);
		
		//Generate Epack1
		Map<Integer, Epack1> qp_id2Epack1 = new HashMap<Integer, Epack1>();
		Map<Integer, Epack1> batch_id2Epack1 = new HashMap<Integer, Epack1>();
		
		List<Object[]> epack1Objects = epackJoinRepository.fetchEpack1Data(center_id);
		for(int i = 0; i < epack1Objects.size(); i++) {
			Epack1 epack1 = new Epack1();
			epack1.setQp_id((Integer)epack1Objects.get(i)[0]);
			epack1.setMaximum_marks((Float)epack1Objects.get(i)[1]);
			if(epack1Objects.get(i)[2] != null) {
				epack1.setInstruction_id((Integer)epack1Objects.get(i)[2]);
				epack1.setInstruction_code(String.valueOf(epack1Objects.get(i)[3]));
				epack1.setInstruction_text(String.valueOf(epack1Objects.get(i)[4]));
			}
			epack1.setDuration((Integer)epack1Objects.get(i)[5]);
			epack1.setBatch_id((Integer)epack1Objects.get(i)[6]);
			epack1.setbatch_code(String.valueOf(epack1Objects.get(i)[7]));
			epack1.setBatch_start_time(LocalDateTime.parse(epack1Objects.get(i)[8].toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")));
			epack1.setBatch_end_time(LocalDateTime.parse(epack1Objects.get(i)[9].toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")));
//			epack1.setBatch_start_time(((TimeStamp)epack1Objects.get(i)[8]).toLocalDateTime());
//			epack1.setBatch_end_time((LocalDateTime)epack1Objects.get(i)[9]);
			epack1.setCenter_id((Integer)epack1Objects.get(i)[10]);
			epack1.setCenter_code(String.valueOf(epack1Objects.get(i)[11]));
			epack1.setCenter_name(String.valueOf(epack1Objects.get(i)[12]));
			epack1.setExamdrive_id((Integer)epack1Objects.get(i)[13]);
			epack1.setExamdrive_code(String.valueOf(epack1Objects.get(i)[14]));
			epack1.setExamdrive_name(String.valueOf(epack1Objects.get(i)[15]));
			epack1.setCourse_master_id((Integer)epack1Objects.get(i)[16]);
			epack1.setCourse_code(String.valueOf(epack1Objects.get(i)[17]));
			epack1.setCourse_name(String.valueOf(epack1Objects.get(i)[18]));
			epack1.setEpack_header(epack);
			
			epack1Service.addEpack1(epack1);
			
			if(!qp_id2Epack1.containsKey(epack1.getQp_id())) {
				qp_id2Epack1.put(epack1.getQp_id(), epack1);
			}
			
			if(!batch_id2Epack1.containsKey(epack1.getBatch_id())) {
				batch_id2Epack1.put(epack1.getBatch_id(), epack1);
			}
		}
		
		//Generate Epack2
		Map<Integer, Epack2> qp_item_id2Epack2 = new HashMap<Integer, Epack2>();
		
		for (Map.Entry mapElement : qp_id2Epack1.entrySet()) {
			List<Object[]> epack2Objects = epackJoinRepository.fetchEpack2Data((int)mapElement.getKey());
			for(int i = 0; i < epack2Objects.size(); i++) {
				Epack2 epack2 = new Epack2((Integer)epack2Objects.get(i)[0], (Integer)epack2Objects.get(i)[1], String.valueOf(epack2Objects.get(i)[2]), (Float)epack2Objects.get(i)[3], String.valueOf(epack2Objects.get(i)[4]), String.valueOf(epack2Objects.get(i)[5]));
				epack2.setEpack1((Epack1)mapElement.getValue());
				epack2Service.addEpack2(epack2);
				
				if(!qp_item_id2Epack2.containsKey(epack2.getQp_item_id())) {
					qp_item_id2Epack2.put(epack2.getQp_item_id(), epack2);
				}
			}
		}
		
		//Generate Epack3
		for (Map.Entry mapElement : qp_item_id2Epack2.entrySet()) {
			List<Object[]> epack3McqObjects = epackJoinRepository.fetchEpack3McqData((int)mapElement.getKey());
			for(int i = 0; i < epack3McqObjects.size(); i++) {
				Epack3 epack3 = new Epack3((Integer)epack3McqObjects.get(i)[0], (Integer)epack3McqObjects.get(i)[1], String.valueOf(epack3McqObjects.get(i)[2]));
				epack3.setEpack2((Epack2)mapElement.getValue());
				epack3Service.addEpack3(epack3);
			}
			
			List<Object[]> epack3TFObjects = epackJoinRepository.fetchEpack3TFData((int)mapElement.getKey());
			for(int i = 0; i < epack3TFObjects.size(); i++) {
				Epack3 epack3True = new Epack3((Integer)epack3TFObjects.get(i)[0], (Integer)epack3TFObjects.get(i)[1], "True");
				epack3True.setEpack2((Epack2)mapElement.getValue());
				epack3Service.addEpack3(epack3True);
				
				Epack3 epack3False = new Epack3((Integer)epack3TFObjects.get(i)[0], (Integer)epack3TFObjects.get(i)[1], "False");
				epack3False.setEpack2((Epack2)mapElement.getValue());
				epack3Service.addEpack3(epack3False);
			}
		}
		
		//Generate Qpack4
		for (Map.Entry mapElement : batch_id2Epack1.entrySet()) {
			List<Object[]> epack4Objects = epackJoinRepository.fetchEpack4Data((int)mapElement.getKey());
			for(int i = 0; i < epack4Objects.size(); i++) {
				Epack4 epack4 = new Epack4((Integer)epack4Objects.get(i)[0], (Integer)epack4Objects.get(i)[1], (Integer)epack4Objects.get(i)[2], String.valueOf(epack4Objects.get(i)[3]), String.valueOf(epack4Objects.get(i)[4]), String.valueOf(epack4Objects.get(i)[5]), String.valueOf(epack4Objects.get(i)[6]), String.valueOf(epack4Objects.get(i)[7]), String.valueOf(epack4Objects.get(i)[8]));
				epack4.setEpack1((Epack1)mapElement.getValue());
				epack4Service.addEpack4(epack4);
			}
		}
		
//		List<Epack1> epack1s = epackJoinRepository.fetchData();
//		epack1s.forEach( (epack1) -> epack1.setEpack_header(epack));
//		epack1Service.addEpack1Bulk(epack1s);
	}
	
	public Optional<Epack> getEpack(int id){
		return epackRepository.findById(id);
	}
	
//	public Optional<Epack> getEpackByCentre(int id){
//		return epackRepository.findBycenter_id(id);
//	}
}

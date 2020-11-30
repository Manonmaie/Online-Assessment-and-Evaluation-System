package com.iiitb.assessmentBackEnd.outRpackHeader;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.assessmentBackEnd.rpack1.Rpack1;
import com.iiitb.assessmentBackEnd.rpack1.Rpack1Service;
import com.iiitb.assessmentBackEnd.rpack2.Rpack2;
import com.iiitb.assessmentBackEnd.rpack2.Rpack2Service;
import com.iiitb.assessmentBackEnd.rpack3.Rpack3;
import com.iiitb.assessmentBackEnd.rpack3.Rpack3Service;
import com.iiitb.assessmentBackEnd.rpack4.Rpack4;
import com.iiitb.assessmentBackEnd.rpack4.Rpack4Service;
import com.iiitb.assessmentBackEnd.sqlDump.SqlDumpService;

@Service
public class RpackHeaderService {

	@Autowired
	private RpackHeaderRepository rpackHeaderRepository;
	
	@Autowired
	private RpackJoinRepository rpackJoinRepository;
	
	@Autowired
	private Rpack1Service rpack1Service;
	
	@Autowired
	private Rpack2Service rpack2Service;
	
	@Autowired
	private Rpack3Service rpack3Service;
	
	@Autowired
	private Rpack4Service rpack4Service;
	
	@Autowired
	private SqlDumpService sqlDumpService;
	
	public List<OutRpackHeader> getAllRpacksForRpackStatus(String rpackStatus) {
		return rpackHeaderRepository.findByRpackStatus(rpackStatus);
	}
	
	public void updateRpackHeader(OutRpackHeader outRpackHeader) {
		rpackHeaderRepository.save(outRpackHeader);
	}
	
	public void addRpack()  throws IOException{
		rpack4Service.deleteAll();
		rpack3Service.deleteAll();
		rpack2Service.deleteAll();
		rpack1Service.deleteAll();
		
		//Generate Rpack
		OutRpackHeader rpack = new OutRpackHeader();
		rpack.setRpackDesc("Nothing");
		rpack.setCreatedOn(LocalDateTime.now());
		rpack.setCreatedBy("Author");
		rpack.setRpackStatus("SENT");
		rpackHeaderRepository.save(rpack);
		
		//Generate Rpack1
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
		
		//Generate Rpack3
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
		
		//Generate Rpack4
		for (Map.Entry mapElement : qp_item_id2Rpack2.entrySet()) {
			List<Object[]> rpack4Objects = rpackJoinRepository.fetchRpack4Data((int)mapElement.getKey());
			for(int i = 0; i < rpack4Objects.size(); i++) {
				Rpack4 rpack4 = new Rpack4((Integer)rpack4Objects.get(i)[0], (Integer)rpack4Objects.get(i)[1], (Integer)rpack4Objects.get(i)[2], (Integer)rpack4Objects.get(i)[3], (Integer)rpack4Objects.get(i)[4], (Integer)rpack4Objects.get(i)[5], String.valueOf(rpack4Objects.get(i)[6]));
				rpack4.setRpack2((Rpack2)mapElement.getValue());
				rpack4Service.addRpack4(rpack4);
			}
		}
		
		sqlDumpService.getRpackDump();
	}
}

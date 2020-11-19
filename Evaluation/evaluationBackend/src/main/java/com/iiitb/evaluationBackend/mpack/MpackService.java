package com.iiitb.evaluationBackend.mpack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.evaluationBackend.mpack1.Mpack1;
import com.iiitb.evaluationBackend.mpack1.Mpack1Service;
import com.iiitb.evaluationBackend.mpack2.Mpack2;
import com.iiitb.evaluationBackend.mpack2.Mpack2Service;
import com.iiitb.evaluationBackend.mpack3.Mpack3;
import com.iiitb.evaluationBackend.mpack3.Mpack3Service;

@Service
public class MpackService {
	@Autowired
	private MpackRepository mpackRepository;
	
	@Autowired
	private MpackJoinRepository mpackJoinRepository;
	
	@Autowired
	private Mpack1Service mpack1Service;
	
	@Autowired
	private Mpack2Service mpack2Service;
	
	@Autowired
	private Mpack3Service mpack3Service;
	
	public List<Mpack> getAllMpacks() {
		List<Mpack> mpacks = new ArrayList<>();
		mpackRepository.findAll().forEach(mpacks::add);
		return mpacks;
	}

	public void deleteMpack(int id) {
		mpackRepository.deleteById(id);
	}
	
	public Optional<Mpack> getMpack(int id){
		return mpackRepository.findById(id);
	}
	
	public void addMpack() {
		mpack3Service.deleteAll();
		mpack2Service.deleteAll();
		mpack1Service.deleteAll();
		
		//Generate Mpack
		Mpack mpack = new Mpack();
		mpack.setMpack_desc("Nothing");
		mpack.setCreated_on(LocalDateTime.now());
		mpack.setCreated_by("Author");
		mpack.setMpack_status("CREATED");
		mpackRepository.save(mpack);
		
		//Generate Mpack1
		Map<Integer, Mpack1> qp_id2Mpack1 = new HashMap<Integer, Mpack1>();
		
		List<Object[]> mpack1Objects = mpackJoinRepository.fetchMpack1Data();
		for(int i = 0; i < mpack1Objects.size(); i++) {
			Mpack1 mpack1 = new Mpack1((Integer)mpack1Objects.get(i)[0], (Float)mpack1Objects.get(i)[1], (Integer)mpack1Objects.get(i)[2]);
			mpack1.setMpack_header(mpack);
			mpack1Service.addMpack1(mpack1);
			
			if(!qp_id2Mpack1.containsKey(mpack1.getQp_id())) {
				qp_id2Mpack1.put(mpack1.getQp_id(), mpack1);
			}
		}
		
		//Generate Mpack2
		Map<Integer, Mpack2> qp_item_id2Mpack2 = new HashMap<Integer, Mpack2>();
		
		for (Map.Entry mapElement : qp_id2Mpack1.entrySet()) {
			List<Object[]> mpack2Objects = mpackJoinRepository.fetchMpack2Data((int)mapElement.getKey());
			for(int i = 0; i < mpack2Objects.size(); i++) {
				Mpack2 mpack2 = new Mpack2((Integer)mpack2Objects.get(i)[0], (Integer)mpack2Objects.get(i)[1], String.valueOf(mpack2Objects.get(i)[2]), (Float)mpack2Objects.get(i)[3], String.valueOf(mpack2Objects.get(i)[4]));
				mpack2.setMpack1((Mpack1)mapElement.getValue());
				mpack2Service.addMpack2(mpack2);
				
				if(!qp_item_id2Mpack2.containsKey(mpack2.getQp_item_id())) {
					qp_item_id2Mpack2.put(mpack2.getQp_item_id(), mpack2);
				}
			}
		}
		
		//Generate Mapck3
		for (Map.Entry mapElement : qp_item_id2Mpack2.entrySet()) {
			List<Object[]> mpack3Objects = mpackJoinRepository.fetchMpack3Data((int)mapElement.getKey());
			for(int i = 0; i < mpack3Objects.size(); i++) {
				Mpack3 mpack3 = new Mpack3((Integer)mpack3Objects.get(i)[0], (Integer)mpack3Objects.get(i)[1], (Integer)mpack3Objects.get(i)[2], (Float)mpack3Objects.get(i)[3]);
				mpack3.setMpack2((Mpack2)mapElement.getValue());
				mpack3Service.addMpack3(mpack3);
			}
		}
	}
}

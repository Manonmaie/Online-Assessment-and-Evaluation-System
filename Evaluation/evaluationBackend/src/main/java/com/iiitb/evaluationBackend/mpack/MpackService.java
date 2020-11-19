package com.iiitb.evaluationBackend.mpack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.evaluationBackend.mpack1.Mpack1;
import com.iiitb.evaluationBackend.mpack1.Mpack1Service;


@Service
public class MpackService {
	@Autowired
	private MpackRepository mpackRepository;
	
	@Autowired
	private MpackJoinRepository mpackJoinRepository;
	
	@Autowired
	private Mpack1Service mpack1Service;
	
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
		mpack1Service.deleteAll();
		
		//Generate Mpack
		Mpack mpack = new Mpack();
		mpack.setMpack_desc("Nothing");
		mpack.setCreated_on(LocalDateTime.now());
		mpack.setCreated_by("Author");
		mpack.setMpack_status("CREATED");
		mpackRepository.save(mpack);
		
		//Generate Mpack1
		List<Object[]> mpack1Objects = mpackJoinRepository.fetchMpack1Data();
		for(int i = 0; i < mpack1Objects.size(); i++) {
			Mpack1 mpack1 = new Mpack1((Integer)mpack1Objects.get(i)[0], (Float)mpack1Objects.get(i)[1], (Integer)mpack1Objects.get(i)[2]);
			mpack1.setMpack_header(mpack);
			mpack1Service.addMpack1(mpack1);
		}
		
	}
}

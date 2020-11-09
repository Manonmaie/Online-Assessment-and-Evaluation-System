package com.iiitb.examAdminBackEnd.epack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.examAdminBackEnd.epack1.Epack1;
import com.iiitb.examAdminBackEnd.epack1.Epack1Service;

@Service
public class EpackService {
	
	@Autowired
	private EpackRepository epackRepository;
	
	@Autowired
	private EpackJoinRepository epackJoinRepository;
	
	@Autowired
	private Epack1Service epack1Service;
	
	public List<Epack> getAllEpacks() {
		List<Epack> epacks = new ArrayList<>();
		epackRepository.findAll().forEach(epacks::add);
		return epacks;
	}

	public void deleteEpack(int id) {
		epackRepository.deleteById(id);
	}
	
	public void addEpack(Epack epack) {
		epackRepository.save(epack);
		List<Epack1> epack1s = epackJoinRepository.fetchData();
		epack1s.forEach( (epack1) -> epack1.setEpack_header(epack));
		epack1Service.addEpack1Bulk(epack1s);
	}
	
	public Optional<Epack> getEpack(int id){
		return epackRepository.findById(id);
	}
	
	public Optional<Epack> getEpackByCentre(int id){
		return epackRepository.findBycenter_id(id);
	}
}

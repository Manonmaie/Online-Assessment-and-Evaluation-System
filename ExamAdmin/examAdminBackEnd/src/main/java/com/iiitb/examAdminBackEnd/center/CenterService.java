package com.iiitb.examAdminBackEnd.center;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterService {
	
	@Autowired
	private CenterRepository centerRepository;
	
	public List<Center> getAllCenters() {
		List<Center> centers = new ArrayList<>();
		centerRepository.findAll().forEach(centers::add);
		return centers;
	}

	public void deleteCenter(int id) {
		centerRepository.deleteById(id);
	}

	public Optional<Center> getCenter(int id) {
		return centerRepository.findById(id);
	}

	public void addCenter(Center center) {
		centerRepository.save(center);
	}
	
	public void updateCenter(int id, Center center) {
		centerRepository.save(center);
	}
}

package com.iiitb.examAdminBackEnd.center;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterService {
	
	@Autowired
	private CenterRepository centerRepository;
	
	public List<EaCenter> getAllCenters() {
		List<EaCenter> centers = new ArrayList<>();
		centerRepository.findAll().forEach(centers::add);
		return centers;
	}
}

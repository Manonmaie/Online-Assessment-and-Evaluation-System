package com.iiitb.assessmentBackEnd.center;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterService {
	@Autowired
	private CenterRepository centerRepository;
	
	public void addCenter(AsCenter center) {
		centerRepository.save(center);
	}
}

package com.iiitb.assessmentBackEnd.outRpackHeader;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RpackHeaderService {

	@Autowired
	private RpackHeaderRepository rpackHeaderRepository;
	
	public List<OutRpackHeader> getAllRpacksForRpackStatus(String rpackStatus) {
		return rpackHeaderRepository.findByRpackStatus(rpackStatus);
	}
	
	public void updateRpackHeader(OutRpackHeader outRpackHeader) {
		rpackHeaderRepository.save(outRpackHeader);
	}
}

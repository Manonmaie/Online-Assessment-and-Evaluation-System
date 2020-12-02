package com.iiitb.assessmentBackEnd.instruction;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructionService {
	
	@Autowired
	private InstructionRepository instructionRepository;
	
	public List<AsInstruction> getAllInstForQp(int qpId) {
		List<AsInstruction> inst_list = new ArrayList<>();
		instructionRepository.findByAsQuestionPaperQpId(qpId).forEach(inst_list::add);
		return inst_list;
	}
	
	public void addInstruction(AsInstruction instruction) {
		instructionRepository.save(instruction);
	}
	
}

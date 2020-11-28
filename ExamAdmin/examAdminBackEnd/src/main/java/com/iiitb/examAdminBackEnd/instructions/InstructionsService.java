package com.iiitb.examAdminBackEnd.instructions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructionsService {
	@Autowired
	private InstructionsRepository instructionsRepository;
	
	public void addInstructions(Instructions instructions) {
		instructionsRepository.save(instructions);
	}
	
	public Optional<Instructions> getInstructions(int id){
		return instructionsRepository.findById(id);
	}
	
	public void addInstructionsBulk(List<Instructions> instructions) {
		instructionsRepository.saveAll(instructions);
	}
	
	public void deleteAll() {
		instructionsRepository.deleteAll();
	}
}

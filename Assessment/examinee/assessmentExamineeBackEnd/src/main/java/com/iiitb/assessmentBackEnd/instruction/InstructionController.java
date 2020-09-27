package com.iiitb.assessmentBackEnd.instruction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InstructionController {
	
	@Autowired
	public InstructionService instructionService;
	
	@RequestMapping("/questionPaper/{qpId}/instructions")
	public List<AsInstruction> getInstForQp(@PathVariable int qpId){
		return instructionService.getAllInstForQp(qpId);
	}

}

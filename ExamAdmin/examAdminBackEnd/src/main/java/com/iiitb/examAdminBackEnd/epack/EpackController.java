package com.iiitb.examAdminBackEnd.epack;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iiitb.examAdminBackEnd.serverConnect.Status;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EpackController {
	@Autowired
	private EpackService epackService;
	
	@RequestMapping("/createEpack/{id}")
	public Status createQpack(@PathVariable int id) throws IOException{
		return epackService.addEpack(id);
	}
}

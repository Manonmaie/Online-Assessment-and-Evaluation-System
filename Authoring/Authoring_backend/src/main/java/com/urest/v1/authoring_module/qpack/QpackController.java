package com.urest.v1.authoring_module.qpack;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QpackController {
	
	@Autowired
	private QpackService qpackService;
	
	@RequestMapping("/createQpack")
	public void createQpack() throws IOException{
		qpackService.addQpack();
	}

}

package com.iiitb.assessmentBackEnd.epack;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EpackController {
	@Autowired
	private EpackService epackService;
	
	@RequestMapping("/importFromEpack")
	public void fromEpack() throws IOException, InterruptedException{
		epackService.epack2OriginalTables();
	}
}

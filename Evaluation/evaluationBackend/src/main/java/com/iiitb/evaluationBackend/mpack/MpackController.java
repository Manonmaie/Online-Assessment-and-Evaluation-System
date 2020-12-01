package com.iiitb.evaluationBackend.mpack;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iiitb.evaluationBackend.serverConnect.Status;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MpackController {
	@Autowired
	private MpackService mpackService;
	
	@RequestMapping("/createMpack")
	public Status createMpack() throws IOException{
		return mpackService.addMpack();
	}
}

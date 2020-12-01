package com.urest.v1.authoring_module.apack;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.urest.v1.authoring_module.serverConnect.Status;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApackController {
	@Autowired
	private ApackService apackService;
	
	@RequestMapping("/createApack")
	public Status createApack() throws IOException{
		return apackService.addApack();
	}
}

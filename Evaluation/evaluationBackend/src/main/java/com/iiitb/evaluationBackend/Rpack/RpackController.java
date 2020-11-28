package com.iiitb.evaluationBackend.Rpack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RpackController {
	@Autowired
	private RpackService rpackService;
	
	@RequestMapping("/importFromRpack")
	public void fromRpack(){
		rpackService.rpack2OriginalTables();
	}
}

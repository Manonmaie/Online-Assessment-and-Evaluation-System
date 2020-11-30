package com.iiitb.examAdminBackEnd.mpack;

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
public class MpackController {
	@Autowired
	private MpackService mpackService;
	
	@RequestMapping("/importFromMpack")
	public void fromMpack() throws IOException, InterruptedException{
		mpackService.mpack2OriginalTables();
	}
}

package com.iiitb.assessmentBackEnd.outRpackHeader;

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
public class RpackHeaderController {
	
	@Autowired
	private RpackHeaderService rpackHeaderService;
	
	@RequestMapping("/sentRpacks/{rpackStatus}")
	public List<OutRpackHeader> getAllRpacksForRpackStatus(@PathVariable String rpackStatus) {
		return rpackHeaderService.getAllRpacksForRpackStatus(rpackStatus);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/rpackHeader/{rpackHeaderId}")
	public void updateRpackHeader(@PathVariable int rpackHeaderId, @RequestBody OutRpackHeader outRpackHeader) {
		rpackHeaderService.updateRpackHeader(outRpackHeader);
	}
}

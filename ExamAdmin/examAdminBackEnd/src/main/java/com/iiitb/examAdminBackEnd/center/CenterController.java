package com.iiitb.examAdminBackEnd.center;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CenterController {
	@Autowired
	private CenterService centerService;
	
	@RequestMapping("/centers")
	public List<Center> getAllCenters() {
		return centerService.getAllCenters();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/centers/{id}")
	public Optional<Center> getCenter(@PathVariable int id) {
		return centerService.getCenter(id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/centers/{id}")
	public void deleteCenter(@PathVariable int id) {
		centerService.deleteCenter(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/centers")
	public void addCenter(@RequestBody Center center) {
		centerService.addCenter(center);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/centers/{id}")
	public void updateCenter(@PathVariable int id,@RequestBody Center center) {
		centerService.updateCenter(id, center);
	}
	
	@RequestMapping("/centerCodes")
	public List<String> getCodes(){
		return centerService.getCodes();
	}
}

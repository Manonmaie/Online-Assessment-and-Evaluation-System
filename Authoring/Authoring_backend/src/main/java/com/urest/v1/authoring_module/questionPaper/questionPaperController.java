package com.urest.v1.authoring_module.questionPaper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.urest.v1.authoring_module.item.Item;

import org.springframework.web.bind.annotation.ResponseBody;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class questionPaperController {
	@Autowired
	private questionPaperService qpService;
	
	// set qp 
	@RequestMapping(value = "/urest/v1/setQP", headers="Content-Type=application/json", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<questionPaper> saveDataQP(@RequestBody questionPaper q) {
    	System.out.println("heyy2");
        return new ResponseEntity<questionPaper>(qpService.createQP(q),HttpStatus.OK);
    }

    // get all qp
    @RequestMapping("/urest/v1/getallQps")
	public List<questionPaper> getAllQps() {
		return qpService.getAllQp();
	}
}

package com.iiitb.assessmentBackEnd.qpItem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QpItemController {

	@Autowired
	public QpItemService qpItemService;
	
	@RequestMapping("/questionPaper/{qpId}/qpItems")
	public List<AsQpItem> getAllQpItemsForQuestionPaper(@PathVariable int qpId){
		return qpItemService.getAllQpItemsForQp(qpId);
	}
}

package com.iiitb.evaluationBackend.itemMcqOptions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemMcqOptionsController {
	
	@Autowired
	public ItemMcqOptionsService itemMcqOptionsService;
	
	@RequestMapping("/qpItem/{qpItemId}/mcqOptions")
	public List<EvItemMcqOptions> getAllMcqOptionsForQuestionPaperItem(@PathVariable int qpItemId){
		return itemMcqOptionsService.getAllMcqOptionsForQpItem(qpItemId);
	}
}

package com.urest.v1.authoring_module.item;

import org.springframework.web.bind.annotation.RestController;

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
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/urest/v1/getallitemsTF")
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}
	@RequestMapping("/urest/v1/checkTF")
	public String index() {
		return "Successfully retrieved the item";
	}
	@RequestMapping("/urest/v1/getitem_byAuthor/{id}")
	public List<Item> getItem(@PathVariable Integer id) {
		return itemService.getAllQpItemsForAuthor(id);
	}
	
	
	@RequestMapping(value = "/urest/v1/getitem_byFilter", method = RequestMethod.GET)
	public List<Item> getItemByFilter(@RequestParam  Map<String, String> p){
		return itemService.getAllQpItemsFiltered(p);
	}
	
	
	// set question type TF
	@RequestMapping(value = "/urest/v1/setItemTF", headers="Content-Type=application/json", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResponseStruct> saveDataTF(@RequestBody ResponseStruct question) {
        return new ResponseEntity<ResponseStruct>(itemService.createItemTF(question),HttpStatus.OK);
    }
	
	
	// set question type MCQ
	@RequestMapping(value = "/urest/v1/setItemMCQ", headers="Content-Type=application/json", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResponseStruct> saveDataMCQ(@RequestBody ResponseStruct question) {
        return new ResponseEntity<ResponseStruct>(itemService.createItemMCQ(question),HttpStatus.OK);
    }

}

package com.urest.v1.authoring_module.item;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/urest/v1/getallitems")
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}
	@RequestMapping("/urest/v1/check")
	public String index() {
		return "Successfully retrieved the item";
	}
	@RequestMapping("/urest/v1/getitem/{id}")
	public Optional<Item> getItem(@PathVariable Integer id) {
		return itemService.getItem(id);
	}
	@RequestMapping(value = "/urest/v1/setItem", headers="Content-Type=application/json", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Item> saveData(@RequestBody Item question) {
        return new ResponseEntity<Item>(itemService.createItem(question),HttpStatus.OK);

    }

}

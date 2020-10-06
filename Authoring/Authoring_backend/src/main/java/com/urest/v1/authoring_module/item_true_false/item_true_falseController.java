package com.urest.v1.authoring_module.item_true_false;
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
import org.springframework.web.bind.annotation.RestController;




@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class item_true_falseController {
//	@Autowired
//	private item_true_falseService item_true_falseService;
//	
//	@RequestMapping("/urest/v1/getallitems")
//	public List<item_true_false> getAllItems() {
//		return item_true_falseService.getAllItems();
//	}
//	@RequestMapping("/urest/v1/check")
//	public String index() {
//		return "Successfully retrieved the item";
//	}
//	@RequestMapping("/urest/v1/getitem/{id}")
//	public Optional<item_true_false> getItem(@PathVariable Integer id) {
//		return item_true_falseService.getItem(id);
//	}
//	
//	@RequestMapping(value = "/urest/v1/setItemTF", headers="Content-Type=application/json", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseEntity<item_true_false> saveData(@RequestBody item_true_false question) {
//        return new ResponseEntity<item_true_false>(item_true_falseService.createItem(question),HttpStatus.OK);
//
//    }

}



package com.urest.v1.authoring_module;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/urest/v1")
	public String index() {
		return "API IS UP AND RUNNING";
	}

}

package com.iiitb.examAdminBackEnd.serverConnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ServerConnectController {
	//@Autowired
	private ServerConnect serverConnect;
	
	@RequestMapping("pushToServer")
	public Status PushToServer() {
		return serverConnect.execCurlPushCommand("/home/manonmaie/Desktop/Test.txt");
	}
	
	@RequestMapping("pullFromServer/{key}")
	public void PullFromServer(@PathVariable String key) {
		serverConnect.execCurlPullCommand("/home/manonmaie/Desktop/OutTest.txt", key);
	}
}

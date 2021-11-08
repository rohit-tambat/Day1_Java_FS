package com.hcltraining;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Value("${profile}")
	private String profile;
	
	@Value("${server.port}")
	private String port;
	
	@Value("${message}")
	private String message;
	
	@GetMapping("/currentprofile")
	public String printProfileIndicator() {
		return profile +" - "+ message +" - "+ port;
	}
	
	@GetMapping("/currentprofile1")
	public String printProfileIndicator1() {
		return port;
	}
	
	
}

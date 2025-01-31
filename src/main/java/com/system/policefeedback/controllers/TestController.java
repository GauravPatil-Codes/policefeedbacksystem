package com.system.policefeedback.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/")
	
	public String TestMethod() {
		return "I am up and working fine";
	}

}

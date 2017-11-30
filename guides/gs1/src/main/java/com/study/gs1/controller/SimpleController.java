package com.study.gs1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
	
	@GetMapping("/")
	String hello() {
		return "Hello,World!";
	}
}

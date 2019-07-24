package com.demo.sprBootGenGroovyJenfile.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sprBootGenGroovyJenfileCon {
	
	@RequestMapping("/login")
	public String logindsss() {
//		return "pleas login";
		return "index.html";
	}
	
}

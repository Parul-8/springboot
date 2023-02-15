package com.springsecurity.SpringSecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	

	@GetMapping("/")
	public String  home() {
		System.out.println("welcome");
		return "welcome!!";
		
	}
	
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public String user() {
		System.out.println("Welcome normal user");
		return "welcome user";
	}

	@RequestMapping(value="/admin", method= RequestMethod.GET)
	public String admin() {
		return "welcome admin";
		
	}

}

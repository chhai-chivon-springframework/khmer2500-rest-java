package com.khmer2500.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value = "/")
	public String home(){
		System.out.println("Home Work");
		return "index";
	}
}

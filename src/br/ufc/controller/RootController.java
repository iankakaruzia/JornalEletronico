package br.ufc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

	public RootController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/")
	public String home(){
		return "home";
	}

}

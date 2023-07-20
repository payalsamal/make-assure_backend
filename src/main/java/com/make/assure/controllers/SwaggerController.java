package com.make.assure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerController {

	
	@RequestMapping("/")
	public String index(Model model) {            
	    return "redirect:/swagger-ui/index.html";
	}
}

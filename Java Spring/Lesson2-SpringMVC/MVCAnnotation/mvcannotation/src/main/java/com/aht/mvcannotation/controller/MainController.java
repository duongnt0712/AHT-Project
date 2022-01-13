package com.aht.mvcannotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aht.mvcannotation.model.Owner;

@Controller
public class MainController {

	@Autowired
	private Owner owner;

	@RequestMapping(value= {"/"})
	public String index(Model model) {
		model.addAttribute("msg", "Hello World Spring MVC Annotation");
		return "index";
	}
	
	@RequestMapping(value= {"/showInfo"})
	public String showInfo(Model model) {
		model.addAttribute("owner", owner);
		return "showInfo";
	}
}

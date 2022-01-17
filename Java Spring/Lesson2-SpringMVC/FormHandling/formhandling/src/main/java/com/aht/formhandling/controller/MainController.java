package com.aht.formhandling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aht.formhandling.entity.Student;

@Controller
public class MainController {
	
	private ModelAndView mnv = new ModelAndView();
	
	
	@RequestMapping(value = "/")
	public String redirect() {
		return "redirect:student";
	}

	@RequestMapping(value = "/student")
	public ModelAndView student() {
		mnv.setViewName("student");
		mnv.addObject("command", new Student());
		return mnv;
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public ModelAndView addStudent(@ModelAttribute("command") Student student) {
		mnv.setViewName("result");
		mnv.addObject("name", student.getName());
		mnv.addObject("age", student.getAge());
		mnv.addObject("id", student.getId());
		
		return mnv;
	}
	
	@RequestMapping(value = "/displayName", method = RequestMethod.POST)
	public void displayName() {
		mnv.setViewName("student");
		System.out.println(mnv.getModel().entrySet());
		System.out.println(mnv.getModel().containsKey("name"));
	}
}

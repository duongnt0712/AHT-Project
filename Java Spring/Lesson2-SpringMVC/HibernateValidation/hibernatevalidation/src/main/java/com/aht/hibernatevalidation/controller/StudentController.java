package com.aht.hibernatevalidation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aht.hibernatevalidation.entity.Student;

import jakarta.validation.Valid;

@Controller
public class StudentController {
	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public ModelAndView student() {
		return new ModelAndView("addStudent", "student", new Student());
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
		System.out.println(student.toString());
		if (bindingResult.hasErrors()) {
			System.out.println("Error line 25");
			return "addStudent";
		}
		model.addAttribute("name", student.getName());
		model.addAttribute("age", student.getAge());
		model.addAttribute("id", student.getId());

		return "result";
	}
}

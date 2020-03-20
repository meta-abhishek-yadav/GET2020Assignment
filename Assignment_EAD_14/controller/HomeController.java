package com.metacube.training.controller;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.repository.UserRepo;
import com.metacube.training.service.ServiceClass;


@Controller
public class HomeController {
	@Autowired
	ServiceClass service;
	@GetMapping("/")
	public String method1()
	{
		return "index";
	}
	@GetMapping("/user")
	public String method2(Model model)
	{
		return "user";
	}
	@GetMapping("/admin")
	public String method3(Model model)
	{
		return "admin";
	}
	@GetMapping("/users")
	public String method4(Model model)
	{
		model.addAttribute("users", service.viewUsers());

		return "users";
	}

}
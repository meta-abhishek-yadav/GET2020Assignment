package com.metacube.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.commands.LoginCommands;
import com.metacube.training.model.commands.EmployeeCommands;
import com.metacube.training.service.IEmployeeService;

@Controller
public class HomeController {

	@Autowired
	private IEmployeeService employeeService;
	private EmployeeCommands employeeCommand;
	private LoginCommands loginCommand=new LoginCommands();
	private static int loggedIn=0;
	@Value("${home.message}")
	private String message;
	
	
	@GetMapping({"/","/home"})
	public String home(Model model) {
		loggedIn=0;
		model.addAttribute("msg",message);
		return "/home";
	}
	@GetMapping({"/logout"})
	public String home5(Model model) {
		loggedIn=0;
		model.addAttribute("msg",message);
		return "redirect:/home";
	}
	@GetMapping({"/login"})
	public String home4(Model model) {
		loggedIn=0;
		model.addAttribute("logindata",loginCommand);
		return "login";

	}
	
	@GetMapping({"/index"})
	public ModelAndView home1(Model model) {
		if(loggedIn==0)
		{
			return new ModelAndView("redirect:/home","","loggedOutPleaseLogin");

		}
		else
		{
			return new ModelAndView("index","employee",employeeCommand);

		}
	}
	@GetMapping({"/update"})
	public String home2(Model model) {
		if(loggedIn==0)
		{
			return "redirect:/home";
		}
		else
		{
		model.addAttribute("employee",employeeCommand);
		return "update";
		}
	}
	@GetMapping({"/friends"})
	public ModelAndView home3(Model model) {
		if(loggedIn==0)
		{
			return new ModelAndView("redirect:/home","","loggedOutPleaseLogin");

		}
		else
		{
		List<EmployeeCommands> list=employeeService.getAllEmployees();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getEmail().equals(employeeCommand.getEmail()))
			{
				list.remove(i);
				i--;
			}
			else if(!(list.get(i).getOrganisation().equals(employeeCommand.getOrganisation())))
			{
				list.remove(i);
				i--;
			}
			else
			{
				list.get(i).setPassword("");
			}
		}
		return new ModelAndView("friends","employees",list);

		}
		
	}
	@GetMapping("/signup")
	public String signup(Model model) {
		loggedIn=0;
		model.addAttribute("employee",new EmployeeCommands());
		return "signup";
				
	}
	@PostMapping("/login")
	public String doLogin(@Validated @ModelAttribute("logindata") LoginCommands loginCommand,
			BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
			return "login";
			}
			else
			{
				
				EmployeeCommands employee=employeeService.getEmpolyee(loginCommand.getEmail());
				if(employee.getPassword().equals(loginCommand.getPassword()))
				{
					loggedIn=1;
					employeeCommand=employee;
					return "redirect:/index";
				}
				else 
				{
					return "loginfailed";
				}
			}
	}
	
	@PostMapping("/signup")
	public String doSignup(@Validated @ModelAttribute("employee") EmployeeCommands employeeCommands,
			BindingResult bindingResult) {
		int find=0;
		employeeCommands.setImage("images/abhishek.jpg");
		List<EmployeeCommands> list=employeeService.getAllEmployees();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getEmail().equals(employeeCommands.getEmail()))
			{
				find=1;
				break;
			}
		}
		if(find==0)
		{
			loggedIn=1;
			employeeCommand=employeeCommands;
			employeeService.addEmployee(employeeCommands);
			return "redirect:/index";
		}
		else
		{
			return "userexists";
		}
		}
	@PostMapping("/update")
	public String doUpdate(@Validated @ModelAttribute("employee") EmployeeCommands employeeCommands,
			BindingResult bindingResult) {
		loggedIn=1;
		employeeService.updateEmployee(employeeCommands);
		return "redirect:/index";
	}
}

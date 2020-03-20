package com.metacube.training.controller;

import java.util.List;
import java.util.Random;

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

import com.metacube.training.model.commands.*;
import com.metacube.training.model.commands.EmployeeCommands;
import com.metacube.training.service.impl.*;

@Controller
public class HomeController {

	@Autowired
	private IEmployeeService employeeService;
	private EmployeeCommands employeeCommand=new EmployeeCommands();
	private UserCommand userCommand=new UserCommand();
	private VehicleCommand vehicleCommand = new VehicleCommand();
	private LoginCommands loginCommand=new LoginCommands();
	private static int loggedIn=0;
	private static int signedup=0;

	@Value("${home.message}")
	private String message;
	
	@GetMapping({"/login"})
	public String loginForm()
	{
		return "securityLogin";
	}
	
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
	@GetMapping({"/afterlogin"})
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
		model.addAttribute("employee",userCommand);
		return "updateEmployee";
		}
	}
	@GetMapping({"/updateVehicle"})
	public String home11(Model model) {
		if(loggedIn==0)
		{
			return "redirect:/home";
		}
		else
		{
			vehicleCommand.setId(employeeCommand.getId());
		model.addAttribute("vehicle",vehicleCommand);
		return "updateVehicle";
		}
	}
	@GetMapping({"/updatePass"})
	public String home12(Model model) {
		if(loggedIn==0)
		{
			return "redirect:/home";
		}
		else
		{
		model.addAttribute("pass",employeeCommand);
		return "updatePass";
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
			System.out.println(list.get(i).getOrganisation());
			System.out.println(employeeCommand.getOrganisation());

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
	public String signupEmployee(Model model) {
		loggedIn=0;
		model.addAttribute("employee", new UserCommand());
		return "employee";		
	}
	@GetMapping("/vehicle")
	public String signupVehicle(Model model) {
		if(signedup == 1)
		{
			model.addAttribute("vehicle",vehicleCommand);
			return "vehicle";
		}
		else
		{
			return "redirect:/signup";
		}				
	}
	@GetMapping("/pass")
	public String signupPass(Model model) {
		if(signedup==2)
		{
		loggedIn=0;
		model.addAttribute("pass", employeeCommand);
		return "pass";		
		}
		else 
		{
			return "redirect:/vehicle";
		}
	}
	@PostMapping("/employee")
	public String doSignUpEmployee(@Validated @ModelAttribute("employee") UserCommand userCommand,
			BindingResult bindingResult) {

			if (bindingResult.hasErrors()) {
				
				return "employee";
			}
			else
			{
				if(userCommand.getPassword().equals(userCommand.getConfirmPassword()))
				{
				this.userCommand=userCommand;
				int find=0;
				List<EmployeeCommands> list=employeeService.getAllEmployees();
				System.out.println(list);
				if(list != null)
				{
				for(int i=0;i<list.size();i++)
				{
					if(list.get(i).getEmail().equals(userCommand.getEmail()))
					{
						find=1;
						break;
					}
				}
				}
				if(find==0)
				{
					signedup=1;
					Random rand = new Random(); 
					int random = rand.nextInt(100000);
					userCommand.setId(Integer.toString(random));
					vehicleCommand=assign1(userCommand,vehicleCommand);
					return "redirect:/vehicle";
				}
				else
				{
					return "userexists";
				}
				}
				else
				{
					return "passwordNotMatch";

				}
			}
		
	}
	@PostMapping("/vehicle")
	public String doSignUpVehicle(@Validated @ModelAttribute("vehicle") VehicleCommand vehicleCommand,
		BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
				return "vehicle";
			}
			else
			{
				signedup=2;
				this.vehicleCommand=vehicleCommand;
				employeeCommand=assign(employeeCommand,vehicleCommand);

				return "redirect:/pass";
			}
		
	}
	@PostMapping("/pass")
	public String doSignUpPass(@Validated @ModelAttribute("pass") EmployeeCommands employeeCommand,
			BindingResult bindingResult) {
		
        if (bindingResult.hasErrors()) {
				return "pass";
			}
			else
			{
				signedup=0;
					employeeService.addEmployee(employeeCommand);
					loggedIn=1;
					this.employeeCommand=employeeCommand;
					return "redirect:/index";
				
				
			}
		
	}
	@PostMapping("/updateEmployee")
	public String doUpdateEmployee(@Validated @ModelAttribute("employee") UserCommand userCommand,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			
			return "updateEmployee";
		}
		else
		{
			if(userCommand.getPassword().equals(userCommand.getConfirmPassword()))
			{
				signedup=1;
				vehicleCommand=assign1(userCommand,vehicleCommand);
				return "redirect:/updateVehicle";
			}
			else
			{
				return "passwordNotMatch";
			}
		}
	
		
	}
	@PostMapping("/updateVehicle")
	public String doUpdateVehicle(@Validated @ModelAttribute("vehicle") VehicleCommand vehicleCommand,
			BindingResult bindingResult) {

		  if (bindingResult.hasErrors()) {
				return "updateVehicle";
			}
			else
			{
					signedup=0;
					loggedIn=1;
					employeeCommand=assign(employeeCommand,vehicleCommand);
					return "redirect:/updatePass";
				
				
			}
		
	}
	@PostMapping("/updatePass")
	public String doUpdatePass(@Validated @ModelAttribute("pass") EmployeeCommands employeeCommand,
			BindingResult bindingResult) {
	

			if (bindingResult.hasErrors()) {
				
				return "updatePass";
			}
			else
			{
				//this.passCommand=passCommand;
				
				employeeService.updateEmployee(employeeCommand);
				assign(employeeCommand);
				loggedIn=1;
				return "redirect:/index";
			}
		
	}
	@PostMapping("/afterlogin")
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
					System.out.println(employee.getName());
					System.out.println(employee.getVehicleName());
					loggedIn=1;
					assign(employee);
					employeeCommand=employee;;
					return "redirect:/index";
				}
				else 
				{
					return "loginfailed";
				}
			}
	}
	
	
	public EmployeeCommands assign(EmployeeCommands employee,VehicleCommand vehicle)
	{
		employee.setName(vehicle.getName());
		employee.setId(vehicle.getId());
		employee.setEmail(vehicle.getEmail());
		employee.setGender(vehicle.getGender());
		employee.setContact(vehicle.getContact());
		employee.setOrganisation(vehicle.getOrganisation());
		employee.setConfirmPassword(vehicle.getConfirmPassword());
		employee.setImage(vehicle.getImage());
		employee.setPassword(vehicle.getPassword());
		employee.setVehicleName(vehicle.getVehicleName());
		employee.setVehicleType(vehicle.getVehicleType());
		employee.setVehicleNumber(vehicle.getVehicleNumber());
		employee.setVehicleIdentification(vehicle.getVehicleIdentification());
		return employee;
	}
	public VehicleCommand assign1(UserCommand user,VehicleCommand vehicle)
	{
		vehicle.setName(user.getName());
		vehicle.setId(user.getId());
		vehicle.setEmail(user.getEmail());
		vehicle.setGender(user.getGender());
		vehicle.setContact(user.getContact());
		vehicle.setOrganisation(user.getOrganisation());
		vehicle.setPassword(user.getPassword());
		vehicle.setConfirmPassword(user.getConfirmPassword());
		vehicle.setImage(user.getImage());
		return vehicle;
	}
	public void assign(EmployeeCommands employee)
	{
		this.userCommand.setName(employee.getName());
		userCommand.setId(employee.getId());
		userCommand.setEmail(employee.getEmail());
		userCommand.setGender(employee.getGender());
		userCommand.setContact(employee.getContact());
		userCommand.setOrganisation(employee.getOrganisation());
		userCommand.setPassword(employee.getPassword());
		userCommand.setConfirmPassword(employee.getConfirmPassword());
		userCommand.setImage(employee.getImage());
		
		vehicleCommand.setName(employee.getName());
		vehicleCommand.setId(employee.getId());
		vehicleCommand.setEmail(employee.getEmail());
		vehicleCommand.setGender(employee.getGender());
		vehicleCommand.setContact(employee.getContact());
		vehicleCommand.setOrganisation(employee.getOrganisation());
		vehicleCommand.setConfirmPassword(employee.getConfirmPassword());
		vehicleCommand.setImage(employee.getImage());
		vehicleCommand.setPassword(employee.getPassword());
		vehicleCommand.setVehicleName(employee.getVehicleName());
		vehicleCommand.setVehicleType(employee.getVehicleType());
		vehicleCommand.setVehicleNumber(employee.getVehicleNumber());
		vehicleCommand.setVehicleIdentification(employee.getVehicleIdentification());
		employeeCommand.setName(employee.getName());
		employeeCommand.setId(employee.getId());
		employeeCommand.setEmail(employee.getEmail());
		employeeCommand.setGender(employee.getGender());
		employeeCommand.setContact(employee.getContact());
		employeeCommand.setOrganisation(employee.getOrganisation());
		employeeCommand.setConfirmPassword(employee.getConfirmPassword());
		employeeCommand.setImage(employee.getImage());
		employeeCommand.setPassword(employee.getPassword());
		employeeCommand.setVehicleName(employee.getVehicleName());
		employeeCommand.setVehicleType(employee.getVehicleType());
		employeeCommand.setVehicleNumber(employee.getVehicleNumber());
		employeeCommand.setVehicleIdentification(employee.getVehicleIdentification());
		employeeCommand.setPassType(employee.getPassType());
		employeeCommand.setPassCost(employee.getPassCost());
	}
	
}

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
import com.metacube.training.service.IEmployeeService;

@Controller
public class HomeController {

	@Autowired
	private IEmployeeService employeeService;
	private static EmployeeCommands employeeCommand=new EmployeeCommands();
	private static UserCommand userCommand=new UserCommand();
	private static VehicleCommand vehicleCommand = new VehicleCommand();
	private static PassCommand passCommand= new PassCommand();
	private LoginCommands loginCommand=new LoginCommands();
	private static int loggedIn=0;
	private static int signedup=0;

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
		model.addAttribute("pass",passCommand);
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
			VehicleCommand obj=new VehicleCommand();
			obj.setId(userCommand.getId());
			model.addAttribute("vehicle", obj);
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
		PassCommand obj1=new PassCommand();
		obj1.setVehicleType(vehicleCommand.getVehicleType());
		model.addAttribute("pass", obj1);
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
				for(int i=0;i<list.size();i++)
				{
					if(list.get(i).getEmail().equals(userCommand.getEmail()))
					{
						find=1;
						break;
					}
				}
				if(find==0)
				{
					signedup=1;
					Random rand = new Random(); 
					int random = rand.nextInt(100000);
					userCommand.setId(Integer.toString(random));
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
				passCommand.setVehicleType(vehicleCommand.getVehicleType());

				return "redirect:/pass";
			}
		
	}
	@PostMapping("/pass")
	public String doSignUpPass(@Validated @ModelAttribute("pass") PassCommand passCommand,
			BindingResult bindingResult) {
		
        if (bindingResult.hasErrors()) {
				return "pass";
			}
			else
			{
				this.passCommand=passCommand;
					signedup=0;
					employeeService.addEmployee(userCommand,vehicleCommand,passCommand);
					loggedIn=1;
					EmployeeCommands employee=employeeService.getEmpolyee(userCommand.getEmail());
					assign(employee);
					return "redirect:/index";
				
				
			}
		
	}
	@PostMapping("/updateEmployee")
	public String doUpdateEmployee(@Validated @ModelAttribute("employee") UserCommand userCommand,
			BindingResult bindingResult) {
		System.out.println(userCommand.getId());
			if (bindingResult.hasErrors()) {
				
				return "updateEmployee";
			}
			else
			{
				
				String id=this.userCommand.getId();
				userCommand.setId(id);
				this.userCommand=userCommand;
				this.userCommand.setId(id);
				employeeCommand.setId(id);
				System.out.println(userCommand.getId());

				return "redirect:/updateVehicle";
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
				this.vehicleCommand=vehicleCommand;
				passCommand.setVehicleType(vehicleCommand.getVehicleType());
				return "redirect:/updatePass";
			}
		
	}
	@PostMapping("/updatePass")
	public String doUpdatePass(@Validated @ModelAttribute("pass") PassCommand passCommand,
			BindingResult bindingResult) {
		System.out.println("ekdncj");
		//System.out.println(userCommand.getName());

			if (bindingResult.hasErrors()) {
				System.out.println(passCommand.getPassType());
				System.out.println(passCommand.getPassCost());

				return "updatePass";
			}
			else
			{
				this.passCommand=passCommand;
				
				employeeService.updateEmployee(userCommand,vehicleCommand,passCommand);
				EmployeeCommands employee=employeeService.getEmpolyee(userCommand.getEmail());
				assign(employee);
				loggedIn=1;
				return "redirect:/index";
			}
		
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
					System.out.println(employee.getName());
					loggedIn=1;
					assign(employee);
					return "redirect:/index";
				}
				else 
				{
					return "loginfailed";
				}
			}
	}
	
	/*@PostMapping("/signup")
	public String doSignup(@Validated @ModelAttribute("employee") EmployeeCommands employeeCommands,
			BindingResult bindingResult) {
		int find=0;
		//employeeCommands.setImage("images/abhishek.jpg");
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
			//employeeService.addEmployee(employeeCommands);
			return "redirect:/index";
		}
		else
		{
			return "userexists";
		}
		}*/
	/*@PostMapping("/update")
	public String doUpdate(@Validated @ModelAttribute("employee") EmployeeCommands employeeCommands,
			BindingResult bindingResult) {
		loggedIn=1;
		employeeCommand=employeeCommands;
		employeeService.updateEmployee(userCommand,vehicleCommand,passCommand);
		return "redirect:/index";
	}*/
	public void assign(EmployeeCommands employee)
	{
		employeeCommand=employee;
		userCommand.setName(employee.getName());
		userCommand.setId(employee.getId());
		userCommand.setEmail(employee.getEmail());
		userCommand.setGender(employee.getGender());
		userCommand.setContact(employee.getContact());
		userCommand.setOrganisation(employee.getOrganisation());
		userCommand.setPassword(employee.getPassword());
		vehicleCommand.setVehicleName(employee.getVehicleName());
		vehicleCommand.setVehicleType(employee.getVehicleType());
		vehicleCommand.setVehicleNumber(employee.getVehicleNumber());
		vehicleCommand.setVehicleIdentification(employee.getVehicleIdentification());
		passCommand.setPassType(employee.getPassType());
		passCommand.setPassCost(employee.getPassCost());
		vehicleCommand.setId(employee.getId());
		passCommand.setVehicleType(employee.getVehicleType());

	}
}

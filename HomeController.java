package com.metacube.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.training.model.commands.StudentCommands;
import com.metacube.training.service.StudentService;

@Controller
public class HomeController {

	@Autowired
	private StudentService studentService;
	
	@Value("${home.message}")
	private String message;
	
	
	@GetMapping({"/","/home"})
	public String home(Model model) {
		model.addAttribute("msg",message);
		
		return "home";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("student",new StudentCommands());
		
		return "signup";
	}
	
	@PostMapping("/signup")
	public String doSignup(@Validated @ModelAttribute("student") StudentCommands StudentCommands,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			
			return "signup";
		} else {
			int find=0;
			List<StudentCommands> students =  studentService.getAllStudents();
			for(int i=0;i<students.size();i++)
			{
				if(students.get(i).getEmail().equals(StudentCommands.getEmail()))
				{
					find=1;
				}
			}
			if (find == 0) {
				studentService.addEmpolyee(StudentCommands);
			} else {
				studentService.updateStudent(StudentCommands);
			}

			return "redirect:/students";
		}	
	}
}

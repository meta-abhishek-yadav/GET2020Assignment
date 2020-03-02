package com.metacube.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.commands.StudentCommands;
import com.metacube.training.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public ModelAndView Students() {
		List<StudentCommands> students =  studentService.getAllStudents();
		return new ModelAndView("students","students",students);
	}
	

}

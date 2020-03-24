package com.metacube.training.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.commands.*;
import com.metacube.training.repository.ProjectRepository;
import com.metacube.training.service.impl.*;


@Service
public class EmployeeServiceImplementation implements IEmployeeService {

	@Autowired
	private ProjectRepository project;	
	@Override
	public 	int addEmployee(EmployeeCommands employeeCommand)
	{
		project.save(employeeCommand);
		return 1;
	}
	@Override
	public EmployeeCommands getEmpolyee(String  email) {
		return project.findByEmail(email);
	}
	@Override
	public int updateEmployee(EmployeeCommands employeeCommand) {
		
		 project.save(employeeCommand);
		 return 1;
	}

	@Override
	public List<EmployeeCommands> getAllEmployees() {
		
		return project.findAll();
	}
	

}

package com.metacube.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.IEmployeeDAO;
import com.metacube.training.model.commands.*;
import com.metacube.training.repository.ProjectRepository;
import com.metacube.training.service.IEmployeeService;


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
		return project.getById(email);
	}
	@Override
	public int updateEmployee(EmployeeCommands employeeCommand) {
		
		return project.save(employeeCommand);
	}

	@Override
	public List<EmployeeCommands> getAllEmployees() {
		
		return project.FindAll();
	}
	

}

package com.metacube.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.IEmployeeDAO;
import com.metacube.training.model.commands.*;
import com.metacube.training.service.IEmployeeService;


@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDAO employeeDAO;	
	@Override
	public 	int addEmployee(EmployeeCommands employeeCommand)
	{
		employeeDAO.addEmployee(employeeCommand);
		
		return 0;
	}
	@Override
	public EmployeeCommands getEmpolyee(String  email) {
		return employeeDAO.getEmpolyee(email);
	}
	@Override
	public int updateEmployee(EmployeeCommands employeeCommand) {
		
		return employeeDAO.updateEmployee(employeeCommand);
	}

	@Override
	public List<EmployeeCommands> getAllEmployees() {
		
		return employeeDAO.getAllEmployees();
	}
	

}

package com.metacube.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.IEmployeeDAO;
import com.metacube.training.model.commands.EmployeeCommands;
import com.metacube.training.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDAO employeeDAO;	
	@Override
	public int addEmployee(EmployeeCommands employeeCommands) {
		employeeDAO.addEmpolyee(employeeCommands);
		
		return 0;
	}
	@Override
	public EmployeeCommands getEmpolyee(String  email) {
		return employeeDAO.getEmpolyee(email);
	}
	@Override
	public int updateEmployee(EmployeeCommands employeeCommands) {
		
		return employeeDAO.updateEmployee(employeeCommands);
	}

	@Override
	public List<EmployeeCommands> getAllEmployees() {
		
		return employeeDAO.getAllEmployees();
	}
	

}

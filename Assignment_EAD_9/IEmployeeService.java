package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.commands.EmployeeCommands;


public interface IEmployeeService {

	/**
	 * 
	 * @param employeeCommands
	 * @return
	 */
	int addEmployee(EmployeeCommands employeeCommands);

	/**
	 * 
	 * @param id
	 * @return
	 */
	EmployeeCommands getEmpolyee(String email);

	/**
	 * 
	 * @param employeeCommands
	 * @return
	 */
	int updateEmployee(EmployeeCommands employeeCommands);

	/**
	 * 
	 * @return
	 */
	List<EmployeeCommands> getAllEmployees();
}

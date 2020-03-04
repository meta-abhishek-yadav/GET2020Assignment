package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.commands.*;


public interface IEmployeeDAO {

	/**
	 * 
	 * @param employeeCommands
	 * @return
	 */
	int addEmployee(EmployeeCommands employeeCommand);


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
	int updateEmployee(EmployeeCommands employeeCommand);
	
	/**
	 * 
	 * @return
	 */
	 List<EmployeeCommands> getAllEmployees();
	
}

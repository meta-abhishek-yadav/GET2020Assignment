package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.commands.EmployeeCommands;

public interface IEmployeeDAO {

	/**
	 * 
	 * @param employeeCommands
	 * @return
	 */
	int addEmpolyee(EmployeeCommands employeeCommands);

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

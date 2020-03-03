package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.commands.*;


public interface IEmployeeDAO {

	/**
	 * 
	 * @param employeeCommands
	 * @return
	 */
	int addEmployee(UserCommand userCommand,VehicleCommand vehicleCommand,PassCommand passCommand);


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
	int updateEmployee(UserCommand userCommand,VehicleCommand vehicleCommand,PassCommand passCommand);
	
	/**
	 * 
	 * @return
	 */
	 List<EmployeeCommands> getAllEmployees();
	
}

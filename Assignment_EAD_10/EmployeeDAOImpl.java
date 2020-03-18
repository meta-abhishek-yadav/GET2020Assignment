package com.metacube.training.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.IEmployeeDAO;

import com.metacube.training.mapper.EmployeeMapper;
import com.metacube.training.model.commands.*;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	private final String SQL_FIND_USER = "select * from employee where email = ?";
	private final String SQL_DELETE_USER = "delete from employee where email = ?";
	private final String SQL_GET_ALL = "select * from employee";
	private final String SQL_INSERT_USER = "insert into employee values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	@Autowired
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public 	int addEmployee(UserCommand userCommand,VehicleCommand vehicleCommand,PassCommand passCommand)
 {
		return jdbcTemplate.update(SQL_INSERT_USER, userCommand.getName(),userCommand.getId() ,userCommand.getGender(),userCommand.getEmail(),
				userCommand.getPassword() ,userCommand.getContact() ,userCommand.getOrganisation() ,vehicleCommand.getVehicleName(),vehicleCommand.getVehicleType(),vehicleCommand.getVehicleNumber(),vehicleCommand.getVehicleIdentification(),passCommand.getPassType(),passCommand.getPassCost(),userCommand.getImage());
	}
	@Override
	public EmployeeCommands getEmpolyee(String email) {
		return jdbcTemplate.queryForObject(SQL_FIND_USER, new Object[] { email }, new EmployeeMapper());
	}

	@Override
	public int updateEmployee(UserCommand userCommand,VehicleCommand vehicleCommand,PassCommand passCommand) {
		jdbcTemplate.update(SQL_DELETE_USER, userCommand.getEmail());
			return addEmployee(userCommand,vehicleCommand,passCommand);
	}
	@Override
	public List<EmployeeCommands> getAllEmployees() {
		return jdbcTemplate.query(SQL_GET_ALL, new EmployeeMapper());
	}
	

}

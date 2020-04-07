package com.metacube.training.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.IEmployeeDAO;
import com.metacube.training.mapper.EmployeeMapper;
import com.metacube.training.model.commands.EmployeeCommands;

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
	public int addEmpolyee(EmployeeCommands employeeCommands) {
		return jdbcTemplate.update(SQL_INSERT_USER, employeeCommands.getName(),employeeCommands.getId() ,employeeCommands.getGender(),employeeCommands.getEmail(),
				employeeCommands.getPassword() ,employeeCommands.getContact() ,employeeCommands.getOrganisation() ,employeeCommands.getVehicleName(),employeeCommands.getVehicleType(),employeeCommands.getVehicleNumber(),employeeCommands.getVehicleIdentification(),employeeCommands.getPassType(),employeeCommands.getPassCost(),employeeCommands.getImage());
	}
	@Override
	public EmployeeCommands getEmpolyee(String email) {
		return jdbcTemplate.queryForObject(SQL_FIND_USER, new Object[] { email }, new EmployeeMapper());
	}

	@Override
	public int updateEmployee(EmployeeCommands employeeCommands) {
		jdbcTemplate.update(SQL_DELETE_USER, employeeCommands.getEmail());
			return addEmpolyee(employeeCommands);
	}
	@Override
	public List<EmployeeCommands> getAllEmployees() {
		return jdbcTemplate.query(SQL_GET_ALL, new EmployeeMapper());
	}
	

}

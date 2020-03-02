package com.metacube.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.commands.EmployeeCommands;

public class EmployeeMapper implements RowMapper<EmployeeCommands> {

	@Override
	public EmployeeCommands mapRow(ResultSet resultSet, int i) throws SQLException {

		EmployeeCommands user = new EmployeeCommands();
		user.setName(resultSet.getString(1));
		user.setId(resultSet.getString(2));
		user.setGender(resultSet.getString(3));
		user.setEmail(resultSet.getString(4));
		user.setPassword(resultSet.getString(5));
		user.setContact(resultSet.getString(6));
		user.setOrganisation(resultSet.getString(7));
		user.setVehicleName(resultSet.getString(8));
		user.setVehicleType(resultSet.getString(9));
		user.setVehicleNumber(resultSet.getString(10));
		user.setVehicleIdentification(resultSet.getString(11));
		user.setPassType(resultSet.getString(12));
		user.setPassCost(resultSet.getString(13));
		user.setImage(resultSet.getString(14));
		return user;
	}
}

package com.metacube.training.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.IEmployeeDAO;

import com.metacube.training.mapper.EmployeeMapper;
import com.metacube.training.model.commands.*;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {
	 private Session session;
	 private Configuration con;
	 private StandardServiceRegistryBuilder reg;
	 EmployeeCommands employeeCommand;
	 Transaction tx;
	public EmployeeDAOImpl()
	{
		 con =new Configuration().configure().addAnnotatedClass(EmployeeCommands.class);
		 reg=new StandardServiceRegistryBuilder().applySettings(con.getProperties());
		 SessionFactory sf=con.buildSessionFactory(reg.build());
		 session=sf.openSession();
		  tx=session.beginTransaction();
		}
	@Override
	public 	int addEmployee(EmployeeCommands employeeCommand)
	{
		session.save(employeeCommand);
		tx.commit();
		return 	1;	 
	}
	@Override
	public EmployeeCommands getEmpolyee(String email) {
		Query query = session.createQuery("from EmployeeCommands where email = :email");
		query.setParameter("email", email);
		return (EmployeeCommands) query.list().get(0);
	}

	@Override
	public int updateEmployee(EmployeeCommands employeeCommand) {
		session.update(employeeCommand);

			return 1;
	}
	@Override
	public List<EmployeeCommands> getAllEmployees() {
		Query query = session.createQuery("from EmployeeCommands");
		return query.list();
	}
	

}

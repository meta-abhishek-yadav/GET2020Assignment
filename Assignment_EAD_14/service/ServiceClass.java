package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.repository.UserRepo;

@Service
public class ServiceClass {
	@Autowired
	UserRepo repo;
	 public List<Employee> viewUsers()
	 {
		 //System.out.println(repo.findAll());
		 return repo.findAll();
	 }

}

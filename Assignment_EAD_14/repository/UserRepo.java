package com.metacube.training.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Employee;


@Repository
public interface UserRepo extends JpaRepository<Employee, String> {
	
	Optional<Employee> findByEmail(String userName);
	 


}

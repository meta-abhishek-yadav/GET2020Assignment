package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.commands.EmployeeCommands;


@Repository
public interface ProjectRepository<P> extends JpaRepository<EmployeeCommands, Long> {

	EmployeeCommands findByEmail(String email);



}

package com.metacube.training.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository<P> extends JpaRepository<EmployeeCommands, Long> {

}

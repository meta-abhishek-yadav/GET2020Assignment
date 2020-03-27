package com.metacube.training.model;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.metacube.training.repository.UserRepo;


@Service
public class UserDetails implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;
	
	
	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<Employee> employee = userRepo.findByEmail(email);
		
		
		return employee.map(MyUserDetails::new).get();
	}

}

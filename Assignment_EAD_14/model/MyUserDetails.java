package com.metacube.training.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



public class MyUserDetails implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3103163346351529252L;

	private Employee employee;
	
	private String username;
	private String password;
	private List<GrantedAuthority> authority;

	
	public MyUserDetails( Employee employee) {
		this.username = employee.getEmail();
		this.password = employee.getPassword();
		this.authority = Arrays.stream(employee.getRole().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		
	}
    
	 
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authority;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
	

}

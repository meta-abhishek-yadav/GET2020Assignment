package com.metacube.training.model.commands;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class StudentCommands {

	@NotBlank
	@Email(message = "{badEmail}")
	private String email;
	
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotBlank
	private String fatherName;
	private int age;
	private int classOfStudent;
	
	private int id;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getClassOfStudent() {
		return classOfStudent;
	}

	public void setClassOfStudent(int classOfStudent) {
		this.classOfStudent = classOfStudent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	

	
	
}

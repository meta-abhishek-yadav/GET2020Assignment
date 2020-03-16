package com.metacube.training.model.commands;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

public class UserCommand {
	@NotBlank
	@Email(message = "{badEmail}")
	//@Pattern(regexp = ".*@.*[.].*")
	private String email="";
	@NotBlank
	private String gender;
	@NotBlank
	private String name;
	@NotBlank
	@Length(min=8,max=40)
	@Pattern(regexp = "[A-Z]+.*[0-9]+.*[@,#,$,%,^,*,&,!]+.*[a-z]+")
	private String password;
	@NotBlank
	(message="cnkerwjlo")
	@Length(min=8,max=40)
	@Pattern(regexp = "[A-Z]+.*[0-9]+.*[@,#,$,%,^,*,&,!].*[a-z]+.*")
	private String confirmPassword;
	@NotBlank
	@Length(max=10,min=8)
	@Pattern(regexp="[0-9]+")
	private String contact;
	@NotBlank
	private String organisation;
	
	private String id;
	@NotBlank
	private String image;
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	public String getId() {
		return id;
	}
	public void setId(String id)
	{
		this.id=id;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

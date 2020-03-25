package com.metacube.training.model.commands;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee_commands")
public class EmployeeCommands {

	@NotBlank
	@Email(message = "{badEmail}")
	@Id
	@Column(name = "email")
	private String email="";

	@NotBlank
	@Column(name = "gender")
	private String gender;
	
	@NotBlank
	@Column(name = "name")
	private String name;
	@NotBlank	
	@Column(name = "password")
	private String password;
	@NotBlank
	@Column(name = "confirm_password")
	private String confirmPassword;
	@NotBlank
	@Column(name = "contact")
	private String contact;
	@NotBlank
	@Column(name = "organisation")
	private String organisation;
	@NotBlank
	@Column(name = "vehicle_name")
	private String vehicleName;
	@NotBlank
	@Column(name = "vehicle_type")
	private String vehicleType;
	@NotBlank
	@Column(name = "vehicle_number")
	private String vehicleNumber;
	@NotBlank
	@Column(name = "vehicle_identification")
	private String vehicleIdentification;
	@NotBlank
	@Column(name = "pass_type")
	private String passType;
	@NotBlank
	@Column(name = "pass_cost")
	private String passCost;
	@NotBlank
	@Column(name = "id")
	private String id;
	@NotBlank
	@Column(name = "image")
	private String image;
	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleIdentification() {
		return vehicleIdentification;
	}

	public void setVehicleIdentification(String vehicleIdentification) {
		this.vehicleIdentification = vehicleIdentification;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	public String getPassType() {
		return passType;
	}

	public void setPassType(String passType) {
		this.passType = passType;
	}
	public String getPassCost() {
		return passCost;
	}

	public void setPassCost(String passCost) {
		this.passCost = passCost;
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
	

	
	
}

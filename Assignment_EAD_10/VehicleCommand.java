package com.metacube.training.model.commands;

import javax.validation.constraints.NotBlank;

public class VehicleCommand {
	
	@NotBlank
	private String vehicleName;
	@NotBlank
	private String vehicleType;
	@NotBlank
	private String vehicleNumber;
	@NotBlank
	private String vehicleIdentification;
	@NotBlank
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id)
	{
		this.id=id;
	}
	

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
}

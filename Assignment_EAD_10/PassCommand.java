package com.metacube.training.model.commands;

import javax.validation.constraints.NotBlank;

public class PassCommand {
	@NotBlank
	private String vehicleType;
	@NotBlank
	private String passType;
	@NotBlank
	private String passCost;

	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
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
}

package com.cpt.model;

public class Bus {

	private String registrationId; //Ex MH12 EH 1234
	private BusTerminus parentBusTerminus;
	private Route route;
	
	private int passengerCapacity;	
	private String manufacturerCompany;
	private int manufacturerYear;
	
	public String getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	public BusTerminus getParentBusTerminus() {
		return parentBusTerminus;
	}
	public void setParentBusTerminus(BusTerminus parentBusTerminus) {
		this.parentBusTerminus = parentBusTerminus;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public int getPassengerCapacity() {
		return passengerCapacity;
	}
	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}
	public String getManufacturerCompany() {
		return manufacturerCompany;
	}
	public void setManufacturerCompany(String manufacturerCompany) {
		this.manufacturerCompany = manufacturerCompany;
	}
	public int getManufacturerYear() {
		return manufacturerYear;
	}
	public void setManufacturerYear(int manufacturerYear) {
		this.manufacturerYear = manufacturerYear;
	}
	
	
	
}

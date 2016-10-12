package com.cpt.dto;

import com.cpt.model.BusTerminus;
import com.cpt.model.Route;

public class BusDTO {

	private String registrationId;
	private String routeId;
	private String busTerminusId;
	private String busTerminusName;
	private String manufacturerCompnay;
	private String manufacturerYear;
	private String capacity;
	
	private BusTerminus parentBusTerminus;
	private Route route;
	
	
	public String getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	public String getBusTerminusId() {
		return busTerminusId;
	}
	public void setBusTerminusId(String busTerminusId) {
		this.busTerminusId = busTerminusId;
	}
	public String getBusTerminusName() {
		return busTerminusName;
	}
	public void setBusTerminusName(String busTerminusName) {
		this.busTerminusName = busTerminusName;
	}
	public String getManufacturerCompnay() {
		return manufacturerCompnay;
	}
	public void setManufacturerCompnay(String manufacturerCompnay) {
		this.manufacturerCompnay = manufacturerCompnay;
	}
	public String getManufacturerYear() {
		return manufacturerYear;
	}
	public void setManufacturerYear(String manufacturerYear) {
		this.manufacturerYear = manufacturerYear;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
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

	
}

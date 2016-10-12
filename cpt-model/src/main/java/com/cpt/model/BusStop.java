package com.cpt.model;

public class BusStop extends BoardingPoint{
	
	private int maxPeopleWaitCapacity=20;
	
	
	public int capacity() {
		// GET capacity from property file or database
		// Currently hard coding it to 20		
		return this.maxPeopleWaitCapacity;
	}

	public int getMaxPeopleWaitCapacity() {
		return maxPeopleWaitCapacity;
	}

	public void setMaxPeopleWaitCapacity(int maxPeopleWaitCapacity) {
		this.maxPeopleWaitCapacity = maxPeopleWaitCapacity;
	}
	 

}

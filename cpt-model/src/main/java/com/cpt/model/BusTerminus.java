package com.cpt.model;

public class BusTerminus extends BoardingPoint{
	
	private int maxBusWaitingCapacity=3;
	
	
	public int capacity() {		
		// GET capacity from property file or database
		// Currently hard coding it to 3	
		return this.maxBusWaitingCapacity;
	}

	public int getMaxBusWaitingCapacity() {
		return maxBusWaitingCapacity;
	}

	public void setMaxBusWaitingCapacity(int maxBusWaitingCapacity) {
		this.maxBusWaitingCapacity = maxBusWaitingCapacity;
	}
	 

}

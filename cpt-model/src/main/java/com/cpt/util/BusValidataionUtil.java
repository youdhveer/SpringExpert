package com.cpt.util;

import java.util.Date;

import com.cpt.model.BoardingPoint;
import com.cpt.model.Bus;
import com.cpt.model.BusManufacturer;

public class BusValidataionUtil {

	public static boolean isValidManufacturer(Bus bus){
		if(bus !=null && bus.getManufacturerCompany() !=null 
		   && ( bus.getManufacturerCompany().equalsIgnoreCase(BusManufacturer.ASHOK_LEYLAND.name())
				   || bus.getManufacturerCompany().equalsIgnoreCase(BusManufacturer.TATA.name())
				   || bus.getManufacturerCompany().equalsIgnoreCase(BusManufacturer.TOYOTA.name())
			  )
		   ){
			return true;
		}
		return false;
	}
	
	public static boolean isValidManufacturerYear(Bus bus){
		Date currentDate=new Date();
		
		if(bus !=null && (bus.getManufacturerYear() >=1955
				&& bus.getManufacturerYear() <=currentDate.getYear())){
			return true;
		}
		return false;
	}
	
	public static boolean isValidRoute(Bus bus){
		if(bus !=null && bus.getParentBusTerminus() !=null
				){
			if(bus.getRoute() !=null ){
				BoardingPoint startPoint=bus.getRoute().getStartRoutePoint();
				if(startPoint !=null && startPoint.getId()==bus.getParentBusTerminus().getId()){
					return true;
				}
				BoardingPoint endPoint=bus.getRoute().getEndRoutePoint();
				if(endPoint !=null && endPoint.getId()==bus.getParentBusTerminus().getId()){
					return true;
				}
				return false;
				
			}
			return true;
		}		
		
		return false;
	}
	
}

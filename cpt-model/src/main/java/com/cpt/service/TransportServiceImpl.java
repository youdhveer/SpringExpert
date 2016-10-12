package com.cpt.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpt.dto.BusDTO;
import com.cpt.model.Bus;
import com.cpt.model.BusTerminus;
import com.cpt.model.Route;
import com.cpt.repositories.TransportRepository;
import com.cpt.util.BusValidataionUtil;

@Service("transportService")
public class TransportServiceImpl implements TransportService{

	@Autowired
	private TransportRepository transportRepository;
	
	private static Logger logger=LoggerFactory.getLogger(TransportServiceImpl.class.getName());

	@Override
	public void addBus(BusDTO busDTO) {		
		try {
			
			//busDTO 
			
			Bus bus=new Bus();
			bus.setRegistrationId(busDTO.getRegistrationId());
			bus.setPassengerCapacity(Integer.parseInt(busDTO.getCapacity()));
			bus.setManufacturerCompany(busDTO.getManufacturerCompnay());
			bus.setManufacturerYear(Integer.parseInt(busDTO.getManufacturerYear()));
			if(busDTO.getBusTerminusId() !=null && busDTO.getBusTerminusName() !=null){
				BusTerminus parentBusTerminus =transportRepository.loadBusTerminus(Integer.parseInt(busDTO.getBusTerminusId()), busDTO.getBusTerminusName());
				bus.setParentBusTerminus(parentBusTerminus);
			}
			if(busDTO.getRouteId() !=null){
				Route route=transportRepository.loadRoute(Integer.parseInt(busDTO.getRouteId()));
				bus.setRoute(route);
			}
			
			if(BusValidataionUtil.isValidManufacturer(bus) 
					&& BusValidataionUtil.isValidManufacturerYear(bus)
					&& BusValidataionUtil.isValidRoute(bus)){
				
				transportRepository.createBus(bus);
				
			}else{
				throw new Exception("Invalid manufacturer company or year for bus object !!");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addRoute(Route route) {
		try {
			transportRepository.createRoute(route);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addBusTerminus(BusTerminus busTerminus) {
		try {
			transportRepository.createBusTerminus(busTerminus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Route getRoute(int routeId) {
		Route route=null;
		try {
			route = transportRepository.loadRoute(routeId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return route;
		
	}

	@Override
	public Route getRoute(String busRegisterationNo) {
		Route route=null;
		try {
			route = transportRepository.loadRoute(busRegisterationNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return route;
	}

	@Override
	public List<Route> getRoutesByBusStop() {
		List<Route> routeList=null;
		try {
			routeList = transportRepository.loadRoutesByBusStop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return routeList;
	}
	
	

}

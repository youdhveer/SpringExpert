package com.cpt.service;

import java.util.List;

import com.cpt.dto.BusDTO;
import com.cpt.model.Bus;
import com.cpt.model.BusTerminus;
import com.cpt.model.Route;


public interface TransportService {
	public void addBus(BusDTO bus);
	public void addRoute(Route route) ;
	public void addBusTerminus(BusTerminus busTerminus) ;
	public Route getRoute(int routeId) ;
	public Route getRoute(String busRegisterationNo) ;
	public List<Route> getRoutesByBusStop();
	
}

package com.cpt.repositories;

import java.util.List;

import com.cpt.model.Bus;
import com.cpt.model.BusStop;
import com.cpt.model.BusTerminus;
import com.cpt.model.Route;


public interface TransportRepository {
	public void createBus(Bus bus) throws Exception;
	public void createRoute(Route route) throws Exception;
	public void createBusTerminus(BusTerminus busTerminus) throws Exception;
	public void createBusStop(BusStop busStop) throws Exception;
	public Route loadRoute(int routeId) throws Exception;
	public Route loadRoute(String busRegisterationNo) throws Exception;
	public List<Route> loadRoutesByBusStop() throws Exception;
	
	public BusTerminus loadBusTerminus(int id,String name) throws Exception;
}

package com.cpt.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cpt.model.BoardingPoint;
import com.cpt.model.Bus;
import com.cpt.model.BusStop;
import com.cpt.model.BusTerminus;
import com.cpt.model.Route;

@Repository("transportRepository")
public class TransportRepositoryImpl implements TransportRepository{

	@Override
	public void createBus(Bus bus) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createRoute(Route route) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Route loadRoute(int routeId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Route loadRoute(String busRegisterationNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Route> loadRoutesByBusStop() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void createBusTerminus(BusTerminus busTerminus) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createBusStop(BusStop busStop) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BusTerminus loadBusTerminus(int id, String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

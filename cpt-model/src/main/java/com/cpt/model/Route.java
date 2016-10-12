package com.cpt.model;

import java.util.List;

public class Route {

	private int routeId;
	private String routeName;
	private BoardingPoint startRoutePoint;
	private BoardingPoint endRoutePoint;
	private List<BoardingPoint> routePointLinkedList; //sequence list of route points
	
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	
	public List<BoardingPoint> getRoutePointLinkedList() {
		return routePointLinkedList;
	}
	public void setRoutePointLinkedList(List<BoardingPoint> routePointLinkedList) {
		this.routePointLinkedList = routePointLinkedList;
	}
	public BoardingPoint getStartRoutePoint() {
		return startRoutePoint;
	}
	public void setStartRoutePoint(BoardingPoint startRoutePoint) {
		this.startRoutePoint = startRoutePoint;
	}
	public BoardingPoint getEndRoutePoint() {
		return endRoutePoint;
	}
	public void setEndRoutePoint(BoardingPoint endRoutePoint) {
		this.endRoutePoint = endRoutePoint;
	}
	
	
	
	
}

package com.maps.algorithms.dao;

public interface Location {

	public Location showLocationDetails(String name,float latitude,float longitude) ;
	public Location addLocation(Location location) ;
	public Location updateLocation(Location location) ;
}

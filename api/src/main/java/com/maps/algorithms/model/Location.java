package com.maps.algorithms.model ;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Repository;

@Repository
public class Location {

        @Id
        private String id ;
	private String name ;
	private String details ;
	private GeoLocation geoLocation ;
	public GeoLocation getGeoLocation() {
		return geoLocation;
	}
	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	private String Address ;
	
}

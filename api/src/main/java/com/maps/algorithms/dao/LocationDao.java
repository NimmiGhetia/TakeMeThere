package com.maps.algorithms.dao;

import com.maps.algorithms.model.GeoLocation;
import com.maps.algorithms.model.Location;

public interface LocationDao {

	public Location showLocationDetails(GeoLocation geoLocation);
	public Location addLocation(Location location);
	public Location updateLocation(Location location);
}

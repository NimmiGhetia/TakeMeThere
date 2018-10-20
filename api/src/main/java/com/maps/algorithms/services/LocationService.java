/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maps.algorithms.services;

import com.maps.algorithms.model.BaseResponse;
import com.maps.algorithms.model.GeoLocation;
import com.maps.algorithms.model.Location;
import org.springframework.stereotype.Service;

/**
 *
 * @author nimmi
 */

public interface LocationService {
    	public Location showLocationDetails(GeoLocation geoLocation) ;
        public BaseResponse addLocation(Location location) ;
        public BaseResponse updateLocation(Location location);
	
	

}

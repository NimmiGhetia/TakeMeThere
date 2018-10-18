package com.maps.algorithms.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maps.algorithms.model.BaseResponse;
import com.maps.algorithms.model.GeoLocation;
import com.maps.algorithms.model.Location;
import com.maps.algorithms.services.LocationService;

@RestController
@RequestMapping("/location")
public class LocationController {

	   
    @RequestMapping(value="/show",method=RequestMethod.POST) 
    public Location showLocation(@RequestBody GeoLocation geoLocation)
    {
    	LocationService service=new LocationService() ;
    	Location location=service.showLocationDetails(geoLocation) ;
    	return location ;
    }
    
    @RequestMapping(value="/add",method=RequestMethod.POST) 
    public BaseResponse addLocation(@RequestBody Location location)
    {
    	LocationService service=new LocationService() ;
    	BaseResponse baseResponse=service.addLocation(location) ;
    	return baseResponse ;
    }
    
    @RequestMapping(value="/update",method=RequestMethod.PUT) 
    public BaseResponse updateLocation(@RequestBody Location location)
    {
    	LocationService service=new LocationService() ;
    	BaseResponse baseResponse=service.updateLocation(location) ;
    	return baseResponse ;
    }

	
}

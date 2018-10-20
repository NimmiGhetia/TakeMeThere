package com.maps.algorithms.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maps.algorithms.model.BaseResponse;
import com.maps.algorithms.model.GeoLocation;
import com.maps.algorithms.model.Location;
import com.maps.algorithms.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService ;
    
    @RequestMapping(value="/show",method=RequestMethod.POST) 
    public Location showLocation(@RequestBody GeoLocation geoLocation)
    {
        System.out.println("inside location servoce") ;
    	Location location=locationService.showLocationDetails(geoLocation) ;
    	return location ;
    }
    
    @RequestMapping(value="/add",method=RequestMethod.POST) 
    public BaseResponse addLocation(@RequestBody Location location)
    {
    	BaseResponse baseResponse=locationService.addLocation(location) ;
    	return baseResponse ;
    }
    
    @RequestMapping(value="/update",method=RequestMethod.PUT) 
    public BaseResponse updateLocation(@RequestBody Location location)
    {
    	BaseResponse baseResponse=locationService.updateLocation(location) ;
    	return baseResponse ;
    }	
}

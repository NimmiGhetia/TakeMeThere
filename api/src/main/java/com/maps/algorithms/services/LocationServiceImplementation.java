package com.maps.algorithms.services;

import com.maps.algorithms.dao.LocationDao;
import com.maps.algorithms.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImplementation implements LocationService {

    @Autowired
    private LocationDao locationDao ;
    
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;


	public Location showLocationDetails(GeoLocation geoLocation)
	{
	
                Location location=locationDao.showLocationDetails(geoLocation) ;
		return location ;
		
	}
	public BaseResponse addLocation(Location location)
	{
		BaseResponse baseResponse=null ;
		baseResponse.setCode(CODE_SUCCESS);
		baseResponse.setStatus(SUCCESS_STATUS) ;
		return baseResponse ;
		
	}
	public BaseResponse updateLocation(Location location)
	{
		BaseResponse baseResponse=null ;
		baseResponse.setCode(CODE_SUCCESS);
		baseResponse.setStatus(SUCCESS_STATUS) ;
	
		return baseResponse ;
	}
}

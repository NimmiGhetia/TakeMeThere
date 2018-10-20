/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maps.algorithms.services;

import com.maps.algorithms.model.GeoLocation;
import com.maps.algorithms.model.Location;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author nimmi
 */

public interface CalculatePathService {
    public List<Location> calculatePathUsingAStar(GeoLocation source,GeoLocation destination) ;
    public List<Location> calculatePathUsingBellmanFord(GeoLocation source,GeoLocation destination) ;
    public List<Location> calculatePathUsingDijkstras(GeoLocation source,GeoLocation destination) ; 
		
		
		
}

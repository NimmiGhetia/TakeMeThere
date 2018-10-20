package com.maps.algorithms.services;
import java.util.List;

import com.maps.algorithms.model.GeoLocation;
import com.maps.algorithms.model.Location;
import org.springframework.stereotype.Service;

@Service
public class CalculatePathServiceImplementation implements CalculatePathService {
	
                
		public List<Location> calculatePathUsingAStar(GeoLocation source,GeoLocation destination)
		{
			List<Location> list =null;
			return list ;
		}
		public List<Location> calculatePathUsingBellmanFord(GeoLocation source,GeoLocation destination) 
		{
			List<Location> list =null;
			return list ;
		}
		public List<Location> calculatePathUsingDijkstras(GeoLocation source,GeoLocation destination) 
		{
			List<Location> list =null;
			return list ;
		}
		
}

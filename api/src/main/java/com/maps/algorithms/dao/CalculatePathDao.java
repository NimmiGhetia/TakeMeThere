package com.maps.algorithms.dao;
import java.util.List;

import com.maps.algorithms.model.Location ;

public interface CalculatePathDao {
	
		public List<Location> calculatePathUsingAStar(Location source,Location destination) ;
		public List<Location> calculatePathUsingBellmanFord(Location source,Location destination) ;
		public List<Location> calculatePathUsingDijkstras(Location source,Location destination) ;
		
}

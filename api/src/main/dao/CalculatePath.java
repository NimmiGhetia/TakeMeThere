package dao;
import java.util.List;

import model.Location ;

public interface CalculatePath {
	
		public List<Location> calculatePathUsingAStar(Location source,Location destination) ;
		public List<Location> calculatePathUsingBellmanFord(Location source,Location destination) ;
		public List<Location> calculatePathUsingDijkstras(Location source,Location destination) ;
		
}

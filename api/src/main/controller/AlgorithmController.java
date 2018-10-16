package controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import model.*;
import services.CalculatePathService;

@RestController
@RequestMapping("/algorithm")
public class AlgorithmController {
	
	 	private static final String SUCCESS_STATUS = "success";
	    private static final String ERROR_STATUS = "error";
	    private static final int CODE_SUCCESS = 100;
	    private static final int AUTH_FAILURE = 102;

	    @RequestMapping(value="/AStar",method=RequestMethod.POST) 
	    public List<Location> calculateAStar(@RequestBody LocationEndPoints locationEndPoints)
	    {
	    	CalculatePathService service=new CalculatePathService() ;
	    	List<Location> list=service.calculatePathUsingAStar(locationEndPoints.getSourceLocation(), locationEndPoints.getDestinationLocation()) ;
	    	return list ;
	    }
	    
	    @RequestMapping(value="/Dijkstras",method=RequestMethod.POST) 
	    public List<Location> calculateDijkstras(@RequestBody LocationEndPoints locationEndPoints)
	    {
	    	CalculatePathService service=new CalculatePathService() ;
	    	List<Location> list=service.calculatePathUsingAStar(locationEndPoints.getSourceLocation(), locationEndPoints.getDestinationLocation()) ;
	    	return list ;
	    }
	    
	    @RequestMapping(value="/BellmanFord",method=RequestMethod.POST) 
	    public List<Location> calculateBellmanFord(@RequestBody LocationEndPoints locationEndPoints)
	    {
	    	CalculatePathService service=new CalculatePathService() ;
	    	List<Location> list=service.calculatePathUsingAStar(locationEndPoints.getSourceLocation(), locationEndPoints.getDestinationLocation()) ;
	    	return list ;
	    }
}

package com.maps.algorithms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DefaultController {

	   @RequestMapping(value = "/tp", method = RequestMethod.GET)
	   public String tp()
	    {
	    	return "Success from default" ;
	    }
	   @GetMapping("/get")
	   public String tp2()
	    {
	    	return "Success Get from default" ;
	    }
	  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maps.algorithms;

import com.maps.algorithms.services.FloydWarshallAlgorithm;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author nimmi
 */
public class MapsServletContextListner implements ServletContextListener {
    @Autowired
    FloydWarshallAlgorithm floydWarshallAlgorithm ;
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("ServletContextListener started");
        floydWarshallAlgorithm.floydWarshall();
                // do the things here 
    }
}

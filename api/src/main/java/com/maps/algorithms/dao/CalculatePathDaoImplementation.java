/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maps.algorithms.dao;

import com.maps.algorithms.model.Location;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nimmi
 */
@Repository("calculatePathDao")
public class CalculatePathDaoImplementation implements CalculatePathDao {

    @Override
    public List<Location> calculatePathUsingAStar(Location source, Location destination) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Location> calculatePathUsingBellmanFord(Location source, Location destination) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Location> calculatePathUsingDijkstras(Location source, Location destination) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


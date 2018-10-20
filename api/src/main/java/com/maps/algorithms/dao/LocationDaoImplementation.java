/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maps.algorithms.dao;

import com.maps.algorithms.model.GeoLocation;
import com.maps.algorithms.model.Location;
import static com.mongodb.client.model.Filters.where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nimmi
 */
@Repository("locationDao")
public class LocationDaoImplementation implements LocationDao {
    @Autowired
    private MongoOperations mongoOps;
    private static final String LOCATION_COLLECTION = "Locations";
    @Override
    public Location showLocationDetails(GeoLocation geoLocation) {
        Query searchUserQuery = new Query(Criteria.where("geolocation").is(geoLocation));
        Location location= mongoOps.findOne(searchUserQuery, Location.class) ;
//        System.out.println() ;
//        System.out.println() ;
//        System.out.println() ;
//        System.out.println(location) ;
        return location ;
    }

    @Override
    public Location addLocation(Location location) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Location updateLocation(Location location) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

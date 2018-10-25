/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maps.algorithms.services;

import com.maps.algorithms.dao.ConnectionDao;
import com.maps.algorithms.dao.LocationDao;
import com.maps.algorithms.model.Location;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nimmi
 */
@Service
public class DijkstrasAlgorithm implements Algorithm{
    
    @Autowired
    ConnectionDao connectionDao ;
    @Autowired
    LocationDao locationDao ;
    
    private static final int MAX = 100000;
    
//    public DijkstrasAlgorithm()
//    {
//        System.out.println("calling constructor "+connectionDao+" "+locationDao);
////        this.connectionDao=connectionDao ;
////        this.locationDao=locationDao ;
//    }       
    public class Node {
     
            private String name;

            private List<Node> shortestPath = new LinkedList<>();

            private double distance = Double.MAX_VALUE;

            Map<Node, Double> adjacentNodes = new HashMap<>();

            public void addDestination(Node destination, double distance) {
                adjacentNodes.put(destination, distance);
            }

            public Node(String name) {
                this.name = name;
            }

        public List<Node> getShortestPath() {
            return shortestPath;
        }

        public void setShortestPath(List<Node> shortestPath) {
            this.shortestPath = shortestPath;
        }

        public Map<Node, Double> getAdjacentNodes() {
            return adjacentNodes;
        }

        public void setAdjacentNodes(Map<Node, Double> adjacentNodes) {
            this.adjacentNodes = adjacentNodes;
        }
            
            
        // getters and setters

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Double getDistance() {
                return distance;
            }

            public void setDistance(Double distance) {
                this.distance = distance;
            }
        }
    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        double lowestDistance = Double.MAX_VALUE;
        for (Node node: unsettledNodes) {
            double nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
        public class Graph {

        private Set<Node> nodes = new HashSet<>();

        public void addNode(Node nodeA) {
            nodes.add(nodeA);
        }
 
    // getters and setters 
    }
    private static void calculateMinimumDistance(Node evaluationNode,
        Double edgeWeigh, Node sourceNode) {
          Double sourceDistance = sourceNode.getDistance();
          if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
              evaluationNode.setDistance(sourceDistance + edgeWeigh);
              LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
              shortestPath.add(sourceNode);
              evaluationNode.setShortestPath(shortestPath);
          }
      }
    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0.0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Entry< Node, Double> adjacencyPair: 
              currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Double edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }
    
    public static double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
                  double theta = lon1 - lon2;
                  double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
                              + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
                  dist = Math.acos(dist);
                  dist = rad2deg(dist);
                  dist = dist * 60 * 1.1515;
                  if (unit == 'K') {
                    dist = dist * 1.609344;
                  } else if (unit == 'N') {
                        dist = dist * 0.8684;
                  }
                  else if(unit=='M'){
                      dist=dist*1609.344 ;
                  }
                  return dist;
        }
 
        private static double deg2rad(double deg) {
          return (deg * Math.PI / 180.0);
        }
 
        private static double rad2deg(double rad) {
          return (rad * 180 / Math.PI);
        }
        
    @Override
    public List<Location> calculatePath(String source,String destination) {
        List<Location> list=null ;
        list=connectionDao.findNeighbors(source) ;
        Location sourceLocation=locationDao.showLocationDetailsByName(source) ;
        Map<String,Node> nodes=new HashMap<String,Node>() ;
        Node sourceNode=new Node(source) ;
        nodes.put(source, sourceNode) ;
        List<Node> node=new ArrayList<Node>() ;
        int i=0 ;
        for(Location location:list)
        {
            if(nodes.get(location.getName())!=null)
                    continue ;
            i++ ;
            Node temp=new Node(location.getName()) ;
            node.add(temp) ;
            nodes.put(location.getName(), temp) ;
            List<Location> listOfLocations=this.connectionDao.findNeighbors(location.getName()) ;
            if(listOfLocations!=null) 
            for(Location loc:listOfLocations)
             {
                 if(nodes.get(loc.getName())!=null)
                     continue ;
                 i++ ;
                 Node temp2=new Node(loc.getName()) ;
                 node.add(temp2) ;
                 nodes.put(loc.getName(), temp2) ;
             }
        }
        if(list!=null)   
        for(Location loc:list)
            {
                Node nextNode=nodes.get(loc.getName()) ;
                System.out.println(loc.toString());
                double lat1=sourceLocation.getGeoLocation().getLatitude() ;
                double lng1=sourceLocation.getGeoLocation().getLongitude() ;
                double lat2=loc.getGeoLocation().getLatitude() ;
                double lng2=loc.getGeoLocation().getLongitude() ;
                sourceNode.addDestination(nextNode,  distance(lat1,lng1,lat2,lng2,'M'));
            }
        for(Location location:list)
        {
            System.out.println("inside outer for with parent node="+location.getName()) ;
            List<Location> listOfLocations=this.connectionDao.findNeighbors(location.getName()) ;
            if(listOfLocations!=null)
            for(Location loc:listOfLocations)
            {
                Node nextNode=nodes.get(loc.getName()) ;
                if(nextNode==null)
                    break ;
                double lat1=location.getGeoLocation().getLatitude() ;
                double lng1=location.getGeoLocation().getLongitude() ;
                double lat2=loc.getGeoLocation().getLatitude() ;
                double lng2=loc.getGeoLocation().getLongitude() ;
                Node temp=nodes.get(location.getName()) ;
                if(temp==null)
                    break ;
                temp.addDestination(nextNode,  distance(lat1,lng1,lat2,lng2,'M'));
            }
        } 
        Graph graph=new Graph() ;
        for(Node singleNode:node)
        {
            graph.addNode(singleNode) ;
        }
        graph=DijkstrasAlgorithm.calculateShortestPathFromSource(graph, sourceNode);
        List<Location> result=new ArrayList();
        for(Node finalNode:graph.nodes)
        {
            System.out.println(finalNode.getName()+"=="+destination) ;
            if(finalNode.getName().equals(destination))
            for(Node nextNode: finalNode.getShortestPath())
            {
                Location loc=locationDao.showLocationDetailsByName(nextNode.getName()) ;
                result.add(loc) ;
            }
        }
        return result;
    }
}

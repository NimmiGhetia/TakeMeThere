/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maps.algorithms.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author nimmi
 */
public class DijkstrasAlgorithm implements Algorithm{

    public class Node {
     
            private String name;

            private List<Node> shortestPath = new LinkedList<>();

            private Integer distance = Integer.MAX_VALUE;

            Map<Node, Integer> adjacentNodes = new HashMap<>();

            public void addDestination(Node destination, int distance) {
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

        public Map<Node, Integer> getAdjacentNodes() {
            return adjacentNodes;
        }

        public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
            this.adjacentNodes = adjacentNodes;
        }
            
            
        // getters and setters

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getDistance() {
                return distance;
            }

            public void setDistance(Integer distance) {
                this.distance = distance;
            }
        }
    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeDistance = node.getDistance();
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
        Integer edgeWeigh, Node sourceNode) {
          Integer sourceDistance = sourceNode.getDistance();
          if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
              evaluationNode.setDistance(sourceDistance + edgeWeigh);
              LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
              shortestPath.add(sourceNode);
              evaluationNode.setShortestPath(shortestPath);
          }
      }
    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Entry< Node, Integer> adjacencyPair: 
              currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }
    @Override
    public List<Location> calculatePath(Location source,Location destination) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

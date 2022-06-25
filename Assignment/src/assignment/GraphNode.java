package assignment;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphNode {
    Map<GraphNode, Integer> adjacentNodes = new HashMap<>();
    private String name;
    private List<GraphNode> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;

    public GraphNode(String name) {
        this.name = name;
    }

    public void addDestination(GraphNode destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GraphNode> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<GraphNode> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<GraphNode, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<GraphNode, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }
}

package assignment;

import java.util.HashSet;
import java.util.Set;

public class Graph {

    private Set<GraphNode> nodes = new HashSet<>();

    public void addNode(GraphNode nodeA) {
        nodes.add(nodeA);
    }

    public Set<GraphNode> getNodes() {
        return nodes;
    }

    public void setNodes(Set<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public GraphNode findFinish() {
        for (GraphNode n : this.nodes) {
            if ("Finish".equalsIgnoreCase(n.getName())) {
                return n;
            }
        }
        return null;
    }

}
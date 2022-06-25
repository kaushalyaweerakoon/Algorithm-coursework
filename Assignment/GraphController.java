package assignment;

import java.util.*;
// Dijkstra algorithm
public class GraphController {





    public List<String> getShortestPath(Map <String,Node> nodeMap){
        Graph shortest=createGraph(nodeMap);
        GraphNode finish= shortest.findFinish();

        List<GraphNode> shortestPath = finish.getShortestPath();

        String [] str= new String[shortestPath.size()+1];
        int i=0;
        for(GraphNode n:shortestPath){

            str[i]=n.getName();
            i++;
        }
        str[i]=finish.getName();
//        Arrays.stream(str).forEach(num -> System.out.println(num));
        return createStepList(str,nodeMap);

    }

    private List<String> createStepList(String[] strArray,Map <String,Node> nodeMap){
        List<String> step= new ArrayList<>();

        for (int i=0;i<strArray.length-1;i++) {
            String line="";
            Node node= nodeMap.get(strArray[i]);
            Node node2= nodeMap.get(strArray[i+1]);
            if("Start".equalsIgnoreCase(strArray[i])){
                line="Start at ("+(node.getX()+1)+","+(node.getY()+1)+")";
                step.add(line);
            }

            if(strArray[i+1].equalsIgnoreCase(node.getDownKey())){
                line="Move Down to ("+(node2.getX()+1)+","+(node2.getY()+1)+")";
            }
            else if(strArray[i+1].equalsIgnoreCase(node.getUpKey())){
                line="Move Up to ("+(node2.getX()+1)+","+(node2.getY()+1)+")";
            }
            else if(strArray[i+1].equalsIgnoreCase(node.getLeftKey())){
                line="Move Left to ("+(node2.getX()+1)+","+(node2.getY()+1)+")";
            }
            else if(strArray[i+1].equalsIgnoreCase(node.getRightKey())){
                line="Move Right to ("+(node2.getX()+1)+","+(node2.getY()+1)+")";
            }
            step.add(line);


        }
        step.add("Done!");
        return step;
    }

    public Graph createGraph(Map <String,Node> nodeMap){
        Map<String,GraphNode> graphMap= getGraphMap(nodeMap);

        Graph shortest= new Graph();
        for(String key : graphMap.keySet()) {
            shortest.addNode(graphMap.get(key));

        }
        shortest= calculateShortestPathFromSource(shortest,graphMap.get("Start"));
        return shortest;
    }

    private Map<String,GraphNode>  getGraphMap(Map <String,Node> nodeMap){
        Map<String,GraphNode> graphMap= new HashMap<>();
        for(String key : nodeMap.keySet()) {
            graphMap.put(key, new GraphNode(key));
        }

        for(String key : graphMap.keySet()) {
            Node n = nodeMap.get(key);

            //up
            try{

                if(!n.getUpKey().isBlank()){
//
                    GraphNode gn=graphMap.get(key);
                    gn.addDestination(graphMap.get(n.getUpKey()),n.getUpLen());
                    graphMap.put(key,gn);
                }
            }catch (Exception ignored){}


            try{

                if(!n.getDownKey().isBlank()){

                    GraphNode gn=graphMap.get(key);
                    gn.addDestination(graphMap.get(n.getDownKey()),n.getDownLen());
                    graphMap.put(key,gn);
                }
            }catch (Exception ignored){}

            //left
            try{

                if(!n.getLeftKey().isBlank()){

                    GraphNode gn=graphMap.get(key);
                    gn.addDestination(graphMap.get(n.getLeftKey()),n.getLeftLen());
                    graphMap.put(key,gn);
                }
            }catch (Exception ignored){}

            //right
            try{

                if(!n.getRightKey().isBlank()){

                    GraphNode gn=graphMap.get(key);
                    gn.addDestination(graphMap.get(n.getRightKey()),n.getRightLen());
                    graphMap.put(key,gn);
                }
            }catch (Exception ignored){}

        }

        return graphMap;
    }

    public Graph calculateShortestPathFromSource(Graph graph, GraphNode source) {
        source.setDistance(0);

        Set<GraphNode> settledNodes = new HashSet<>();
        Set<GraphNode> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            GraphNode currentNode = getLowestDistanceNode(unsettledNodes);

            unsettledNodes.remove(currentNode);
            for (Map.Entry< GraphNode, Integer> adjacencyPair:
                    currentNode.getAdjacentNodes().entrySet()) {
                GraphNode adjacentNode = adjacencyPair.getKey();
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

    private GraphNode getLowestDistanceNode(Set < GraphNode > unsettledNodes) {
        GraphNode lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (GraphNode node: unsettledNodes) {

            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private void calculateMinimumDistance(GraphNode evaluationNode,
                                                 Integer edgeWeigh, GraphNode sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<GraphNode> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}

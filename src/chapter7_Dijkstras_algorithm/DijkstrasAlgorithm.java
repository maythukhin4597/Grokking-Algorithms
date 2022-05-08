package chapter7_Dijkstras_algorithm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class DijkstrasAlgorithm {

    private static final List<String> processed = new ArrayList<>();

    public static void main(String[] args) {

        Hashtable<String, Hashtable<String, Double>> graph = new Hashtable<>();
        graph.put("start", new Hashtable<>() {{put("a", 6.0);put("b", 2.0);}});
        graph.put("a", new Hashtable<>() {{put("fin", 1.0);}});
        graph.put("b", new Hashtable<>() {{put("a", 3.0);put("fin", 5.0);}});
        graph.put("fin", new Hashtable<>());

        Hashtable<String, Double> costs = new Hashtable<>();
        costs.put("a", 6.0);
        costs.put("b", 2.0);
        costs.put("fin", Double.MAX_VALUE);

        Hashtable<String, String> parents = new Hashtable<>();
        parents.put("a", "start");
        parents.put("b”", "start");
        parents.put("fin", "");

        findShortestPath(graph,parents,costs);
        System.out.println(costs);
    }

    static void findShortestPath(Hashtable<String, Hashtable<String, Double>> graph, Hashtable<String, String> parents, Hashtable<String, Double> costs) {

        // Find the lowest-cost node that you haven’t processed yet.
        String node = findLowestCostNode(costs);
        Hashtable<String, Double> neighbors;

        // If you’ve processed all the nodes, this while loop is done
        while (!node.isBlank()) {
            Double cost = costs.get(node);
            neighbors = graph.get(node);
            // Go through all the neighbors of this node.
            for (String each : neighbors.keySet()) {
                Double newCost = cost + neighbors.get(each);
                // If it’s cheaper to get to this neighbor by going through this node update the cost for this node.
                if (costs.get(each) > newCost) {
                    costs.put(each, newCost);
                    // This node becomes the new parent for this neighbor.
                    parents.put(each, node);
                }
            }
            // Mark the node as processed.
            processed.add(node);
            node = findLowestCostNode(costs);
        }
    }

    private static String findLowestCostNode(Hashtable<String, Double> costs) {
        Double lowestCost = Double.MAX_VALUE;
        String lowestCostNode = "";
        // Go through each node.
        for (String node : costs.keySet()) {
            Double cost = costs.get(node);
            // If it’s the lowest cost so far and hasn’t been processed yet, set it as the new lowest-cost node.
            if (cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }
        return lowestCostNode;
    }
}
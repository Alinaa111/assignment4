import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DijkstraSearch<T> extends Search<T> {
    private final Set<T> unsettledNodes;
    private final Map<T, Double> distances;
    private final WeightedGraph<T> graph;

    public DijkstraSearch(WeightedGraph<T> graph, T source) {
        super(source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;

        dijkstra();
    }

    public void dijkstra(){
        distances.put(source, 0D);
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            T currentNode = getVertexWithMinimumWeight(unsettledNodes);

            marked.add(currentNode);
            unsettledNodes.remove(currentNode);

            for (T neighbor : graph.adjacencyList(currentNode)) {
                double newDistance = getShortestDistance(currentNode) + getDistance(currentNode, neighbor);

                if (getShortestDistance(neighbor) > newDistance) {
                    distances.put(neighbor, newDistance);
                    edgeTo.put(neighbor, currentNode);
                    unsettledNodes.add(neighbor);
                }
            }
        }
    }

    private double getDistance(T node, T target) {
        Map<Vertex<T>, Double> neighbors = graph.getAdjacentVertices(node);

        for (Map.Entry<Vertex<T>, Double> entry : neighbors.entrySet()) {
            if (entry.getKey().getData().equals(target)) {
                return entry.getValue();
            }
        }

        throw new RuntimeException("No edge from " + node + " to " + target);
    }


    private T getVertexWithMinimumWeight(Set<T> vertices) {
        T minimum = null;
        for (T vertex : vertices) {
            if (minimum == null || getShortestDistance(vertex) < getShortestDistance(minimum)) {
                minimum = vertex;
            }
        }

        return minimum;
    }

    private double getShortestDistance(T destination) {
        Double d = distances.get(destination);

        if (d == null) {
            return Double.MAX_VALUE;
        }
        return d;
    }
}

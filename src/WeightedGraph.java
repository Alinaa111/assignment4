import java.util.*;

public class WeightedGraph<T> {
    private final boolean undirected;
    private final Map<T, Vertex<T>> vertices;

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
        this.vertices = new HashMap<>();
    }

    // Add a vertex by its data
    public void addVertex(T data) {
        vertices.putIfAbsent(data, new Vertex<>(data));
    }

    // Add an edge between two data values
    public void addEdge(T sourceData, T destData, double weight) {
        addVertex(sourceData);
        addVertex(destData);

        Vertex<T> source = vertices.get(sourceData);
        Vertex<T> dest = vertices.get(destData);

        source.addAdjacentVertex(dest, weight);
        if (undirected) {
            dest.addAdjacentVertex(source, weight);
        }
    }

    public boolean hasVertex(T data) {
        return vertices.containsKey(data);
    }


    public Map<Vertex<T>, Double> getAdjacentVertices(T data) {
        if (!hasVertex(data)) return Collections.emptyMap();
        return vertices.get(data).getAdjacentVertices();
    }

    public List<T> adjacencyList(T data) {
        if (!hasVertex(data)) return Collections.emptyList();

        List<T> neighbors = new ArrayList<>();
        for (Vertex<T> v : vertices.get(data).getAdjacentVertices().keySet()) {
            neighbors.add(v.getData());
        }
        return neighbors;
    }

}

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<Vertex> extends Search<Vertex>{
    public BreadthFirstSearch(WeightedGraph<Vertex> graph, Vertex source) {
        super(source);

        bfs(graph, source);
    }

    private void bfs(WeightedGraph<Vertex> graph, Vertex source) {
        marked.add(source);


        Queue<Vertex> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex v = queue.remove();

            for (Vertex vertex : graph.adjacencyList(v)) {
                if (!marked.contains(vertex)) {
                    marked.add(vertex);
                    edgeTo.put(vertex, v);
                    queue.add(vertex);
                }
            }
        }
    }
}
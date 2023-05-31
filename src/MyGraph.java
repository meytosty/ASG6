import java.util.*;

public class MyGraph<V> {
    private Map<Vertex<V>, List<Edge<V>>> graph;

    public MyGraph() {
        graph = new HashMap<>();
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        Edge<V> edge = new Edge<>(source, destination, weight);
        source.addAdjVertex(destination, weight);

        graph.computeIfAbsent(source, k -> new ArrayList<>()).add(edge);
        graph.computeIfAbsent(destination, k -> new ArrayList<>());

    }

    public Map<Vertex<V>, Double> dijkstra(Vertex<V> start) {
        Map<Vertex<V>, Double> distances = new HashMap<>();
        for (Vertex<V> node : graph.keySet()) {
            distances.put(node, Double.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0);

        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> currentVertex = queue.poll();
            double currentDistance = distances.get(currentVertex);

            for (Edge<V> neighbor : graph.get(currentVertex)) {
                double distance = currentDistance + neighbor.getWeight();
                double neighborDistance = distances.get(neighbor.getDest());

                if (distance < neighborDistance) {
                    distances.put(neighbor.getDest(), distance);
                    queue.add(neighbor.getDest());
                }
            }
        }

        return distances;
    }

    public void BFS(Vertex<V> start) {
        Set<Vertex<V>> visited = new HashSet<>();
        Queue<Vertex<V>> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> currentVertex = queue.poll();
            System.out.print(currentVertex + " ");
            List<Edge<V>> edges = graph.get(currentVertex);

            for (Edge<V> edge : edges) {
                Vertex<V> neighbor = edge.getDest();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}

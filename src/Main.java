import java.util.Map;
public class Main {
    public static void main(String[] args) {
        MyGraph<Integer> myGraph = new MyGraph<>();

        Vertex<Integer> s1 = new Vertex<>(1);
        Vertex<Integer> s2 = new Vertex<>(2);
        Vertex<Integer> s3 = new Vertex<>(3);
        Vertex<Integer> s4 = new Vertex<>(4);
        Vertex<Integer> s5 = new Vertex<>(5);

        myGraph.addEdge(s1, s2, 5d);
        myGraph.addEdge(s1, s3, 6d);
        myGraph.addEdge(s2, s4, 7d);
        myGraph.addEdge(s2, s5, 8d);

        Map<Vertex<Integer>, Double> distances = myGraph.dijkstra(s1);
        System.out.println("Dijkstra's Shortest Paths:");
        for (Vertex<Integer> vertex : distances.keySet()) {
            System.out.println("From " + s1 + " to " + vertex + ": " + distances.get(vertex));
        }

        System.out.println("\nBreadth-First Search:");
        myGraph.BFS(s2);
    }
}

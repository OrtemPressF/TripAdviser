public class Main {
    public static void main(String[] args) {
        Map graph = new Map(5); // Creates a graph with 5 vertices
        graph.addEdge(0, 1, 2); // Adds an edge between vertex 0 and vertex 1 with weight 2
        graph.addEdge(1, 2, 3); // Adds an edge between vertex 1 and vertex 2 with weight 3
        graph.printMatrix();
    }
}
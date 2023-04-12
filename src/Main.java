public class Main {
    public static void main(String[] args) {
        String[] vertexNames = {"Museum", "Nature", "Park", "Art Gallery", "Restaurant"};
        Map graph = new Map(20); // Creates a graph with 20 vertices
graph.setVertexName(0, "UserLocation");
        for (int i = 1; i < 20; i++) {
            graph.setVertexName(i, vertexNames[(int) (Math.random() * 5)]);
        }


// Adds edges between all pairs of vertices
        for (int i = 0; i < 20; i++) {
            for (int j = i + 1; j < 20; j++) {
                int weight = (int) (Math.random() * 6) + 1;
                graph.addEdge(i, j, weight); // Adds an edge between vertices i and j with weight 1
            }
        }

        graph.printMatrix(); // Prints the adjacency matrix
        graph.traverseFromVertexOfType(0, "Art Gallery");

    }
}
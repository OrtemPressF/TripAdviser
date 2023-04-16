public class Main {
    public static void main(String[] args) {
        String[] vertexNames = {"Museum", "Nature", "Park", "Art Gallery", "Restaurant"};
        Map graph = new Map(6); // Creates a graph with 20 vertices
        graph.setVertexName(0, "UserLocation");
//        for (int i = 1; i < 20; i++) {
//            graph.setVertexName(i, vertexNames[(int) (Math.random() * 5)]);
//        }
        graph.setVertexName(1, "Art Gallery");
        graph.setVertexName(2, "Park");
        graph.setVertexName(3, "Restaurant");
        graph.setVertexName(4, "Museum");
        graph.setVertexName(5, "Nature");
//        graph.setVertexName(6, "Park");
//        graph.setVertexName(7, "Nature");
//        graph.setVertexName(8, "Restaurant");
//        graph.setVertexName(9, "Art Gallery");
//        graph.setVertexName(10, "Nature");
//        graph.setVertexName(11, "Park");
//        graph.setVertexName(12, "Nature");
//        graph.setVertexName(13, "Museum");
//        graph.setVertexName(14, "Park");
//        graph.setVertexName(15, "Art Gallery");
//        graph.setVertexName(16, "Museum");
//        graph.setVertexName(17, "Restaurant");
//        graph.setVertexName(18, "Park");
//        graph.setVertexName(19, "Restaurant");



//
//        for (int i = 0; i < 5; i++) {
//            for (int j = i + 1; j < 5; j++) {
//                int weight = (int) (Math.random() * 6) + 1;
//                graph.addEdge(i, j, weight); // Adds an edge between vertices i and j with weight
//            }
//        }
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 4);
        graph.addEdge(4, 5, 6);


        graph.printMatrix(); // Prints the adjacency matrix
        graph.findFastestPathThroughAllOfType(0, "Museum");


    }
}
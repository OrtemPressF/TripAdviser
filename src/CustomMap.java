import MapCore.TownMap;
import interfaces.Map;
/**

 This class represents a custom map which can be used in the navigation system.

 It provides a method to set up the map with vertices and edges.
 */
public class CustomMap {

    /**

     Creates a new map with 20 vertices and sets up the names of the vertices and the edges between them.

     @return A new map object with 20 vertices and pre-defined vertex names and edges.
     */
    public static Map setMap() {
// Define an array of vertex names

        String[] vertexNames = {"Historical places", "Nature", "Amusement and fun places", "Cultural value", "Political significance places"};
        //"Historical places", "Nature", "Amusement and fun places", "Cultural value", "Political significance places"
        Map graph = new TownMap(Config.verticesAmount); // Creates a graph with 20 vertices
//        for (int i = 1; i < 20; i++) {
//            graph.setVertexName(i, vertexNames[(int) (Math.random() * 5)]);
//        }
        graph.setVertexName(0, "Nature");
        graph.setVertexName(1, "Cultural value");
        graph.setVertexName(2, "Amusement and fun places");
        graph.setVertexName(3, "Political significance places");
        graph.setVertexName(4, "Cultural value");
        graph.setVertexName(5, "Political significance places");
        graph.setVertexName(6, "Amusement and fun places");
        graph.setVertexName(7, "Nature");
        graph.setVertexName(8, "Political significance places");
        graph.setVertexName(9, "Cultural value");
        graph.setVertexName(10, "Nature");
        graph.setVertexName(11, "Amusement and fun places");
        graph.setVertexName(12, "Nature");
        graph.setVertexName(13, "Historical places");
        graph.setVertexName(14, "Amusement and fun places");
        graph.setVertexName(15, "Cultural value");
        graph.setVertexName(16, "Historical places");
        graph.setVertexName(17, "Political significance places");
        graph.setVertexName(18, "Amusement and fun places");
        graph.setVertexName(19, "Political significance places");


//
//        for (int i = 0; i < 20; i++) {
//            for (int j = i + 1; j < 20; j++) {
//                int weight = (int) (Math.random() * 6) + 1;
//                graph.addEdge(i, j, weight); // Adds an edge between vertices i and j with weight
//            }
//        }
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 4);

        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 4);
        graph.addEdge(1, 7, 2);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 3, 6);
        graph.addEdge(2, 11,7);
        graph.addEdge(2, 17,8);
        graph.addEdge(2, 9, 4);
        graph.addEdge(4, 5, 1);
        graph.addEdge(4, 12,5);
        graph.addEdge(5, 8, 2);
        graph.addEdge(5, 1, 4);
        graph.addEdge(6, 7, 3);
        graph.addEdge(6, 15,5);
        graph.addEdge(7, 8, 1);
        graph.addEdge(7, 18,7);
        graph.addEdge(8, 9, 1);
        graph.addEdge(8, 2, 4);
        graph.addEdge(9, 10,1);
        graph.addEdge(9, 1, 5);
        graph.addEdge(10,11,3);
        graph.addEdge(10,15,3);
        graph.addEdge(11,12,2);
        graph.addEdge(11,3, 6);
        graph.addEdge(12,13,2);
        graph.addEdge(12,7, 5);
        graph.addEdge(13,14,2);
        graph.addEdge(13,4, 7);
        graph.addEdge(14,15,1);
        graph.addEdge(14,9, 3);
        graph.addEdge(15,16,2);
        graph.addEdge(15,13,3);
        graph.addEdge(16,17,2);
        graph.addEdge(16,8, 4);
        graph.addEdge(17,18,3);
        graph.addEdge(17,1, 9);
        graph.addEdge(17,6, 6);

        return graph;
    }
   }

package interfaces;

/**
 An interface for a map containing vertices and edges with associated weights.
 */
public interface Map {

    /**

     Adds an edge between two vertices with an associated weight to the map.
     @param source the source vertex of the edge
     @param destination the destination vertex of the edge
     @param weight the weight of the edge
     */
    void addEdge(int source, int destination, int weight);
    /**

     Gets the weight of an edge between two vertices in the map.
     @param source the source vertex of the edge
     @param destination the destination vertex of the edge
     @return the weight of the edge, or -1 if there is no edge between the two vertices
     */
    int getEdgeWeight(int source, int destination);
    /**

     Sets the name of a vertex in the map.
     @param vertex the vertex to set the name of
     @param name the name to set for the vertex
     */
    void setVertexName(int vertex, String name);
    /**

     Finds the fastest path from the start location to all vertices of a given type in the map, and prints the path and travel time.
     @param vertexType the type of vertex to search for
     @param startLocation the starting location for the search
     @param speed the speed at which the user is traveling
     */
    void findFastestPathsToAllOfType(String vertexType, int startLocation, int speed);
    /**

     Prints the adjacency matrix representation of the map.
     */
    void printMatrix();
}




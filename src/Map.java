import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Map {
    private int numVertices;
    private int[][] matrix;
    private String[] names;
    private int[] distances; // declare distances as an instance variable

    public Map(int numVertices) {
        this.numVertices = numVertices;
        matrix = new int[numVertices][numVertices];
        names = new String[numVertices];
        distances = new int[numVertices]; // initialize distances array
    }

    public void addEdge(int source, int destination, int weight) {
        matrix[source][destination] = weight;
        matrix[destination][source] = weight; // If the graph is undirected, add this line as well
    }

    public int getEdgeWeight(int source, int destination) {
        return matrix[source][destination];
    }

    public void setVertexName(int vertex, String name) {
        names[vertex] = name;
    }

    public String getVertexName(int vertex) {
        return names[vertex];
    }

    public void findFastestPathToAllOfType(int startVertex, String vertexType) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(i -> distances[i]));
        Arrays.fill(distances, Integer.MAX_VALUE);
        boolean[] visited = new boolean[numVertices];
        distances[startVertex] = 0;
        queue.add(startVertex);

        int numFound = 0; // initialize the number of objects found to zero

        while (!queue.isEmpty() && numFound < numVertices) {
            int currentVertex = queue.poll();
            if (visited[currentVertex]) {
                continue;
            }
            visited[currentVertex] = true;
            if (names[currentVertex].equals(vertexType)) {
                numFound++; // increment the number of objects found
                System.out.println("Distance to " + vertexType + " at vertex " + currentVertex + ": " + distances[currentVertex]);
            }
            for (int neighbor = 0; neighbor < numVertices; neighbor++) {
                int weight = matrix[currentVertex][neighbor];
                if (weight != 0 && !visited[neighbor]) {
                    int newDistance = distances[currentVertex] + weight;
                    if (newDistance < distances[neighbor]) {
                        distances[neighbor] = newDistance;
                        queue.add(neighbor);
                    }
                }
            }
        }
        System.out.println("Total distance to all " + vertexType + " objects: " + distances[numVertices-1]);
    }
    public void printMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
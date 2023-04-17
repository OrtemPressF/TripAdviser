import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Map {
    int[][] matrix;
    String[] names;
    int numVertices;
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
        int[] parent = new int[numVertices];
        Arrays.fill(parent, -1); // initialize parent array to -1
        boolean[] visited = new boolean[numVertices];
        distances[startVertex] = 0;
        queue.add(startVertex);

        int numFound = 0;
        int minDistance = 0; // initialize to 0

        while (!queue.isEmpty() && numFound < numVertices) {
            int currentVertex = queue.poll();
            if (visited[currentVertex]) {
                continue;
            }
            visited[currentVertex] = true;
            if (names[currentVertex].equals(vertexType)) {
                numFound++;
                if (numFound == 1) {
                    minDistance = distances[currentVertex]; // initialize minDistance to the first park object found
                } else if (distances[currentVertex] > minDistance) {
                    minDistance = distances[currentVertex];
                }
                // print path to target vertex
                System.out.print("Path to " + vertexType + " at vertex " + currentVertex + ": ");
                Stack<Integer> path = new Stack<>();
                int v = currentVertex;
                while (v != startVertex) {
                    path.push(v);
                    v = parent[v];
                }
                path.push(startVertex);
                while (!path.isEmpty()) {
                    System.out.print(getVertexName(path.pop()) + " ");
                }
                System.out.println();
            }
            for (int neighbor = 0; neighbor < numVertices; neighbor++) {
                int weight = matrix[currentVertex][neighbor];
                if (weight != 0 && !visited[neighbor]) {
                    int newDistance = distances[currentVertex] + weight;
                    if (newDistance < distances[neighbor]) {
                        distances[neighbor] = newDistance;
                        parent[neighbor] = currentVertex; // update parent of neighbor
                        queue.add(neighbor);
                    }
                }
            }
        }
        if (numFound > 0) {
            System.out.println("Total distance to all " + vertexType + " objects: " + minDistance);
        } else {
            System.out.println("No " + vertexType + " objects found.");
        }
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
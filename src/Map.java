import java.util.Stack;

public class Map {
    int[][] matrix;
    String[] names;
    int numVertices;

    public Map(int numVertices) {
        this.numVertices = numVertices;
        matrix = new int[numVertices][numVertices];
        names = new String[numVertices];
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

    public void traverseFromVertexOfType(int startVertex, String vertexType) {
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.empty()) {
            int currentVertex = stack.pop();
            visited[currentVertex] = true;
            System.out.print(names[currentVertex] + " -> ");

            for (int neighbor = 0; neighbor < numVertices; neighbor++) {
                if (matrix[currentVertex][neighbor] != 0 && !visited[neighbor] && names[neighbor].equals(vertexType)) {
                    stack.push(neighbor);
                }
            }
        }
        System.out.println();
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


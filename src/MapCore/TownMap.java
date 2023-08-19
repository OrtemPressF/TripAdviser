package MapCore;

import interfaces.Map;

import java.util.*;

/**
 * A methods, that help to find the path through the defined map
 */

public class TownMap implements Map {
    private int[][] matrix;
    private List<Place> names;
    private int numVertices;
    private int[] distances; // declare distances as an instance variable
    private int totalDistance;

    private int time;

    private int speed;


    public TownMap(int numVertices) {
        this.numVertices = numVertices;
        this.matrix = new int[numVertices][numVertices];
        this.names = new ArrayList<>(numVertices);
        this.distances = new int[numVertices]; // initialize distances array
    }


    @Override
    public void addEdge(int source, int destination, int weight) {
        matrix[source][destination] = weight;
        matrix[destination][source] = weight; // Make the graph undirected
    }
    @Override
    public int getEdgeWeight(int source, int destination) {
        return matrix[source][destination];
    }
    @Override
    public void setVertexName(int vertex, String name) {
        names.add(vertex, new Place(name));
    }

    public String getVertexName(int vertex) {
        return names.get(vertex).getName();
    }
    @Override
    /**

     Finds the fastest paths from the startLocation to all vertices of the specified type,

     using Dijkstra's algorithm with a priority queue.

     The speed parameter specifies the speed at which the traveler is moving, and is used to

     calculate the time taken to traverse each edge.

     @param vertexType the type of vertices to which to find the fastest paths

     @param startLocation the starting vertex

     @param speed the speed at which the traveler is moving
     */


    public void findFastestPathsToAllOfType(String vertexType, int startLocation, int speed) {
        System.out.println("Speed: " + speed);
        int numObjectsFound = 0;
        boolean[] objectFound = new boolean[numVertices];
        totalDistance = 0; // initialize totalDistance



        while (numObjectsFound < numVertices) {              // While there are still vertices to visit in the queue
            Queue<Integer> queue = new LinkedList<>();
            queue.add(startLocation);
            boolean[] visited = new boolean[numVertices];
            visited[startLocation] = true;
            int[] parent = new int[numVertices];
            Arrays.fill(parent, -1);
            int lastObjectLocation = -1;
            int distanceToLastObject = Integer.MAX_VALUE;

            distances[startLocation] = 0;

            // Perform breadth-first search to find the shortest path to all vertices of the given type
            while (!queue.isEmpty()) {
                int currentVertex = queue.remove();
                for (int neighbor = 0; neighbor < numVertices; neighbor++) {               // For each neighbor of the current vertex
                    if (matrix[currentVertex][neighbor] != 0 && !visited[neighbor]) {
                        visited[neighbor] = true;
                        parent[neighbor] = currentVertex;
                        queue.add(neighbor);
                        distances[neighbor] = distances[currentVertex] + matrix[currentVertex][neighbor];

                        // If the neighbor is of the specified vertex type
                        if (names.get(neighbor).getName().equals(vertexType)) {
                            if (!objectFound[neighbor] && distances[neighbor] < distanceToLastObject) {                  // If the object has not already been found and the distance to it is shorter than the previous object found
                                lastObjectLocation = neighbor;
                                distanceToLastObject = distances[neighbor];
                            }
                        }
                    }
                }
            }

            Scanner scanner = null;
            if (lastObjectLocation != -1) {                                  // If an object was found during the search, update the necessary variables
                System.out.print("Shortest path to " + vertexType + ": ");
                Stack<Integer> path = new Stack<>();
                int v = lastObjectLocation;
                while (v != startLocation) {
                    path.push(v);
                    v = parent[v];
                }
                path.push(startLocation);
                while (!path.isEmpty()) {
                    System.out.print(getVertexName(path.pop()));
                    if (!path.isEmpty()) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println();
                float timeInMinutes = (float)distanceToLastObject / (float)speed * 60;
                float timeInMinutesTotal = ((float)totalDistance+(float) distanceToLastObject)/ (float)speed * 60;
                System.out.println("Distance: " + distanceToLastObject + "km");
                System.out.println("Time is: " + timeInMinutes + " minutes");
                totalDistance = distanceToLastObject + totalDistance;
                objectFound[lastObjectLocation] = true;
                numObjectsFound++;
                System.out.println("Total distance is: " + totalDistance + "km");
                System.out.println("Total time is: " + (timeInMinutesTotal) + " minutes");

                if (names.get(lastObjectLocation).getName().equals(vertexType)) {
                    System.out.print("Do you want to continue (c) or change the type of place of interest (t)? ");
                    scanner = new Scanner(System.in);
                    String input = scanner.nextLine();
                    if (input.equals("t")) {
                        System.out.print("Enter the new type of place of interest: \n");
                        vertexType = changeVer();
                    }
                }
                startLocation = lastObjectLocation;
            } else {
                System.out.println("No more " + vertexType + " objects found. You have visited them all ");
                System.out.print("Enter the new type of place of interest:\n ");
                vertexType = changeVer();

            }
        }
    }

    public static String changeVer() {
        Scanner scannerNew = new Scanner(System.in);
        //"Historical places", "Nature", "Amusement and fun places", "Cultural value", "Political significance places"
        List<String> vertexNames = List.of("Historical places", "Nature", "Amusement and fun places", "Cultural value", "Political significance places");
        vertexNames.forEach( v ->
            System.out.println(v)                             //lambda výraz
        );


        int choice = scannerNew.nextInt();
        if (choice < 1 || choice > vertexNames.size()) {
            System.out.println("Invalid choice. Please try again.");
            return changeVer();
        } else {
            return vertexNames.get(choice - 1);
        }
    }

    @Override
    public void printMatrix() {
        Arrays.stream(matrix).flatMapToInt(Arrays::stream).forEach(e -> System.out.println(e + " "));
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public List<Place> getNames() {
        return names;
    }

    public void setNames(List<Place> names) {
        this.names = names;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public int[] getDistances() {
        return distances;
    }

    public void setDistances(int[] distances) {
        this.distances = distances;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
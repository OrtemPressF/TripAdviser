public class Main {
    public static void main(String[] args) {
        Map g = new Map(10);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 4);


        //print the DFS Traversal sequence
        System.out.println("Depth First Traversal for given graph"+
                "(with 0 as starting vertex)");
        g.DFS(0);    }
}
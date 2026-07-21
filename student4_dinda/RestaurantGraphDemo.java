package student4_dinda;

public class RestaurantGraphDemo {
    public static void main(String[] args) {
        RestaurantGraph graph = new RestaurantGraph();
        graph.addNode("Meja1");
        graph.addNode("Meja2");
        graph.addNode("Meja3");
        graph.addNode("Meja4");
        graph.addNode("Meja5");
        graph.addEdge("Meja1", "Meja2");
        graph.addEdge("Meja2", "Meja3");
        graph.addEdge("Meja3", "Meja4");
        graph.addEdge("Meja1", "Meja5");
        graph.printGraph();
        graph.BFS("Meja1");
        graph.DFS("Meja1");
        System.out.println("Ada jalur Meja1\u2192Meja4? " + graph.haspath("Meja1, Meja4"));
    }
}

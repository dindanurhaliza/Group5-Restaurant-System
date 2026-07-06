package student4_dinda;

//================================================================
// RestaurantGraph.java
// NIM  : 251552010017
// Nama : Dinda Nurhaliza Siregar
// Kelas: Group 5 - Restaurant Order Management System
// Peran: S4 - Graph (Adjacency List + BFS/DFS)
//
// Pemodelan Domain (Domain Application Relevance):
// - Node (Vertex): Merepresentasikan meja-meja di restoran (e.g. Meja1, Meja2, dst).
// - Edge (Adjacency): Merepresentasikan zona pelayanan pelayan (waiter zones) yang sama.
//================================================================

public class RestaurantGraph {

    // INNER CLASS: Vertex
    private static class Vertex {
        String name;
        Node adjHead;

        Vertex(String name) {
            this.name = name;
            this.adjHead = null;
        }
    }

    // INNER CLASS: Node
    private static class Node {
        String vertexName;
        Node next;

        Node(String vertexName) {
            this.vertexName = vertexName;
            this.next = null;
        }
    }

    // Fields
    private static final int DEFAULT_CAPACITY = 10;
    private Vertex[] vertices;
    private int size;
    private int capacity;

    // Constructor
    public RestaurantGraph() {
        this.vertices = new Vertex[DEFAULT_CAPACITY];
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}

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

    // ADDNODE (String name)
    public void addNode(String name) {
        if (name == null || name.trim().isEmpty()) {
            return;
        }
        if (findVertex(name) != null) {
            return; // Meja sudah terdaftar
        }
        if (size == capacity) {
            resize();
        }
        vertices[size++] = new Vertex(name);
    }

    // ADDEDGE (String from, String to)
    public void addEdge(String from, String to) {
        if (from == null || to == null) {
            return;
        }
        Vertex vFrom = findVertex(from);
        Vertex vTo = findVertex(to);

        if (vFrom == null || vTo == null) {
            return;
        }

        if (hasDirectEdge(vFrom, to)) {
            return;
        }

        appendAdj(vFrom, to);
        appendAdj(vTo, from);
    }

    // Helpers
    private Vertex findVertex(String name) {
        for (int i = 0; i < size; i++) {
            if (vertices[i].name.equals(name)) {
                return vertices[i];
            }
        }
        return null;
    }

    private int getVertexIndex(String name) {
        for (int i = 0; i < size; i++) {
            if (vertices[i].name.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private boolean hasDirectEdge(Vertex v, String name) {
        Node curr = v.adjHead;
        while (curr != null) {
            if (curr.vertexName.equals(name)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    private void appendAdj(Vertex v, String name) {
        Node newNode = new Node(name);
        if (v.adjHead == null) {
            v.adjHead = newNode;
        } else {
            Node curr = v.adjHead;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    private void resize() {
        this.capacity *= 2;
        Vertex[] newVertices = new Vertex[this.capacity];
        for (int i = 0; i < size; i++) {
            newVertices[i] = vertices[i];
        }
        this.vertices = newVertices;
    }

    // PRINTGRAPH ()
    public void printGraph() {
        System.out.println("=== Denah Restoran ===");
        for (int i = 0; i < size; i++) {
            Vertex v = vertices[i];
            System.out.print(v.name + " -> [");
            Node curr = v.adjHead;
            boolean first = true;
            while (curr != null) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(curr.vertexName);
                first = false;
                curr = curr.next;
            }
            System.out.println("]");
        }
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}

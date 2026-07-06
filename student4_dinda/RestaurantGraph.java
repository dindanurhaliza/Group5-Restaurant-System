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

    // INNER CLASS: StringQueue for BFS queue operations without java.util
    private static class StringQueue {
        private static class QueueNode {
            String data;
            QueueNode next;
            QueueNode(String data) {
                this.data = data;
                this.next = null;
            }
        }
        private QueueNode head = null;
        private QueueNode tail = null;

        void enqueue(String data) {
            QueueNode newNode = new QueueNode(data);
            if (tail == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        String dequeue() {
            if (head == null) return null;
            String val = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return val;
        }

        boolean isEmpty() {
            return head == null;
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

    // BFS (String start)
    public void BFS(String start) {
        System.out.println("=== BFS dari " + start + " ===");
        int startIndex = getVertexIndex(start);
        if (startIndex == -1) {
            System.out.println("Error: Meja awal tidak ditemukan.");
            return;
        }

        boolean[] visited = new boolean[size];
        StringQueue queue = new StringQueue();

        visited[startIndex] = true;
        queue.enqueue(start);

        boolean first = true;
        while (!queue.isEmpty()) {
            String currName = queue.dequeue();
            
            if (!first) {
                System.out.print(" -> ");
            }
            System.out.print(currName);
            first = false;

            int currIdx = getVertexIndex(currName);
            if (currIdx != -1) {
                Vertex currVertex = vertices[currIdx];
                Node neighbor = currVertex.adjHead;
                while (neighbor != null) {
                    int nIndex = getVertexIndex(neighbor.vertexName);
                    if (nIndex != -1 && !visited[nIndex]) {
                        visited[nIndex] = true;
                        queue.enqueue(neighbor.vertexName);
                    }
                    neighbor = neighbor.next;
                }
            }
        }
        System.out.println();
    }

    // DFS (String start)
    public void DFS(String start) {
        System.out.println("=== DFS dari " + start + " ===");
        int startIndex = getVertexIndex(start);
        if (startIndex == -1) {
            System.out.println("Error: Meja awal tidak ditemukan.");
            return;
        }

        boolean[] visited = new boolean[size];
        boolean[] isFirst = new boolean[]{true};
        dfsHelper(start, visited, isFirst);
        System.out.println();
    }

    private void dfsHelper(String current, boolean[] visited, boolean[] isFirst) {
        int index = getVertexIndex(current);
        if (index == -1) return;
        
        visited[index] = true;

        if (!isFirst[0]) {
            System.out.print(" -> ");
        }
        System.out.print(current);
        isFirst[0] = false;

        Vertex v = vertices[index];
        Node neighbor = v.adjHead;
        while (neighbor != null) {
            int nIndex = getVertexIndex(neighbor.vertexName);
            if (nIndex != -1 && !visited[nIndex]) {
                dfsHelper(neighbor.vertexName, visited, isFirst);
            }
            neighbor = neighbor.next;
        }
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}

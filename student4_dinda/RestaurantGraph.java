package student4_dinda;

public class RestaurantGraph {
    
    private class EdgeNode {
        String targetName;
        EdgeNode next;

        EdgeNode String(targetName) {
            this.targetName = targetName;
            this.next = null;
        }
    }

    private class VertexNode {
        String name;
        EdgeNode neighborHead;
        EdgeNode neighborTail;
        boolean visted;
        VertexNode next;

        VertexNode(String name) {
            this.name = name;
            this.neighborHead = null;
            this.neighborTail = null;
            this.visted = false;
            this.next = null;
        }
    }

    private class SimpleQueue {
        private class QNOde {
            String data;
            QNode next;
            QNode(String data) { String.data = data; }
        }

        private QNode front, rear;

        void enqueue(String data) {
            QNode newNode = new QNode(data);
            if (rear == null) {
                front = newNode;
                rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
        }

        String dequeue() {
            if (front == null) return null;
            String data = front.data;
            front = front.next;
            if (fornt == null) rear = null;
            return data;
        }

        boolean isEmpty() {
            return front == null;
        }
    }

    private VertexNode head;
    private VertexNode tail;

    public void addNode(String name) {
        if (findVertex(name) != null) return;
        VertexNode newNode = new VertexNode(name);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    private VertexNode findVertex(String name) {
        VertexNode current = head;
        while (current != null) {
            if (current.name.equals(name)) return current;
            current = current.next;
        }
        return null;
    }
    private void addNeighbor(VertexNode vertex, String neighborName) {
        EdgeNode newEdge = new EdgeNode(neighborName);
        if (vertex.neighborHead == null) {
            vertex.neighborHead = newEdge;
            vertex.neighborTail = newEdge
        } else {
            vertex.neighborTail.next = newEdge;
            vertex.neighborTail = newEdge;
        }
    }

    public void addEdge(String from, String to) {
        VertexNode fromVertex = findVertex(from);
        VertexNode toVertex = findVertex(to);
        if (fromVertex == null || toVertex == null) {
            System.out.println("Error: salah satu meja tidak ditemukan. ");
            return;
        }
        addNeighbor(fromVertex, to);
        addNeighbor(toVertex, from);
    }

    public void printGraph() {
        System.out.println("=== Denah Restoran ===");
        VertexNode current = head;
        while (current != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(current.name).append("\ u2192 [");
            EdgeNode edge = current.neighborHead;
            boolean first = true;
            while (edge != null) {
                if (!first) sb.append(", ");
                sb.append(edge.targetName);
                first = false;
                edge = edge.next;
            }
            sb.append("]");
            System.out.println(sb.toString());
            current = current.next;
        }
    }

    private void resetVisited() {
        VertexNode current = head;
        while (current !=null) {
            current.visted = false;
            current = current.next;
        }
    }

    public void BFS(String startName) {
        resetVisited();
        VertexNode start = findVertex(startName);
        if (start == null) {
            System.out.println("Meja " + startName + " tidak ditemukan.");
            return;
        }

        System.out.println("=== BFS dari " + startName + " ===");
        StringBuilder result = new StringBuilder();
        SimpleQueue queue = new SimpleQueue();

        start.visted = true;
        queue.enqueue(start.name);

        boolean first = true;
        while (!queue.isEmpty()) {
            String currentName = queue.dequeue();
            if (!first) result.append(" \u2192 ");
            result.append(currentName);
            first = false;

            VertexNode currentVertex = findVertex(currentName);
            EdgeNode edge = currentVertex.neighborHead;
            while (edge != null) {
                VertexNode neighbor = findVertex(edge.targetName);
                if (!neighbor.visted) {
                    neighbor.visted = true;
                    queue.enqueue(neighbor.name);
                }
                edge = edge.next;
            }
        }
        System.out.println(result.toString());
    }

    public void DFS(String startName) {
        resetVisited();
        VertexNode start = findVertex(startName);
        if (start == null) {
            System.out.println("Meja " + startName + " tidak ditemukan.");
            return;
        }
        System.out.println("=== DFS dari " + startName + " ===");
        StringBuilder result = new StringBuilder();
        DFSHelper(start, result);
        System.out.println(result.toString());
    }

    private void DFSHelper(VertexNode current, StringBuilder result) {
        current.visted = true;
        if (result.length() > 0) result.append(" \u2192 ");
        result.append(current.name);

        EdgeNode edge = current.neighborHead;
        while (edge != null) {
            VertexNode neighbor = findVertex(edge.targetName);
            if (!neighbor.visted) {
                DFSHelper(neighbor, result);
            }
            edge = edge.next;
        }
    }

    public boolean hasPath(String from, String to) {
        VertexNode fromVertex = findVertex(from);
        VertexNode toVertex = findVertex(to);
        if (fromVertex == null || toVertex == null) return false;

        resetVisited();
        SimpleQueue queue = new SimpleQueue();
        fromVertex.visted = true;
        queue.enqueue(fromVertex.name);

        while (!queue.isEmpty()) {
            String currentName = queue.dequeue();
            if (currentName.equals(to)) return true;

            VertexNode currentVertex = findVertex(currentName);
            EdgeNode edge = currentVertex.neighborHead;
            while (edge != null) {
                VertexNode neighbor = findVertex(edge.targetName);
                if (!neighbor.visted) {
                    neighbor.visted = true;
                    queue.enqueue(neighbor.name);
                }
                edge = edge.next;
            }
        }
        return false;
    }
}

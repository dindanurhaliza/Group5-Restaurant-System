package student4_dinda;

//================================================================
// RestaurantGraphDemo.java
// NIM  : 251552010017
// Nama : Dinda Nurhaliza Siregar
// Kelas: Group 5 - Restaurant Order Management System
// Peran: S4 - Graph (Adjacency List + BFS/DFS)
//
// Demo class untuk mendemonstrasikan fungsionalitas RestaurantGraph.
// Menghasilkan output yang persis sama dengan spesifikasi UAS (Section 7.3).
//================================================================

public class RestaurantGraphDemo {

    public static void main(String[] args) {
        // Inisialisasi graf baru
        RestaurantGraph graph = new RestaurantGraph();

        // 1. Menambahkan node (meja) ke dalam graf
        graph.addNode("Meja1");
        graph.addNode("Meja2");
        graph.addNode("Meja3");
        graph.addNode("Meja4");
        graph.addNode("Meja5");

        // 2. Menghubungkan meja (membuat edge / zona pelayanan pelayan)
        graph.addEdge("Meja1", "Meja2");
        graph.addEdge("Meja2", "Meja3");
        graph.addEdge("Meja3", "Meja4");
        graph.addEdge("Meja1", "Meja5");

        // 3. Menampilkan representasi graf (Denah Restoran)
        graph.printGraph();

        // 4. Melakukan penelusuran BFS
        graph.BFS("Meja1");

        // 5. Melakukan penelusuran DFS
        graph.DFS("Meja1");

        // 6. Mengecek keterhubungan (Pathfinding)
        System.out.println("Ada jalur Meja1→Meja4? " + graph.hasPath("Meja1", "Meja4"));
    }
}

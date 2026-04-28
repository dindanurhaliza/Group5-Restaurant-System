package student4_dinda;

import shared.MenuItem;

//===============================================================
// MenuCategoryIndexDemo.java
// NIM : 251552010017
// Nama : Dinda Nurhaliza Siregar
// Demo class untuk MenuCategoryIndex (HashMap Manual)
// Output harus sesuai Sample Run di soal (Section 6.3 / 7.3)
//===============================================================

public class MenuCategoryIndexDemo {

    public static void main(String[] args) {


        System.out.println("===================================================");
        System.out.println(" DEMO: MenuCategoryIndex (HashMap Manual)" );
        System.out.println(" NIM : 251552010017 - Dinda Nurhaliza S. ");
        System.out.println("==================================================\n");


        // --- Inisialisasi HashMap ---
        MenuCategoryIndex index = new MenuCategoryIndex();

        // --- PUT: Menambahkan 4 menu ---
        index.put("M001", new MenuItem(001, "Nasi Goreng", "Makanan", 25000.0));
        index.put("M002", new MenuItem(002, "Es Teh Manis", "Minuman", 8000.0));
        index.put("M003", new MenuItem(003, "Ayam Bakar", "Makanan", 35000.0));
        index.put("M004", new MenuItem(004, "Jus Alpukat", "Minuman", 15000.0));

        // --- SIZE ---
        System.out.println("Total: " + index.size());

        // --- CONTAINSKEY ---
        System.out.println("Ada M002? " + index.containsKey("M002"));

        // --- GET: Ambil menu yang ada ---
        index.get("M001");

        // --- LISTALLKEYS ---
        index.listAllKeys();

        // --- REMOVE ---
        index.remove("M002");

        // --- SIZE setelah hapus ---
        System.out.println("Total setelah hapus: " + index.size());

        // --- Edge case: GET key yang sudah di hapus ---
        System.out.println("\n--- Edge Case Tests ---");
        index.get("M002");                              // tidak ditemukan
        System.out.println("Ada M002? " + index.containsKey("M002")); // false
        index.remove("M999");                           // key tidak ada

        // --- PUT: Update value pada key yang sudah ada ---
        System.out.println("\n--- Test UPDATE (put key yang sama) ---");
        index.put("M001", new MenuItem(001, "Nasi Goreng Special", "Makanan", 30000.0));
        index.get("M001");  // harga harus sudah diupdate


        System.out.println("\n========================================================");
        System.out.println(" Demo selesai.");
        System.out.println("==========================================================");
    }
    
}

    
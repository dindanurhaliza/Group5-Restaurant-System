# 🍽️ Restaurant Order Management System

Proyek ini adalah sistem berbasis konsol untuk mengelola menu, antrian dapur, dan denah meja di sebuah restoran.
Dibangun menggunakan struktur data dan algoritma yang diimplementasikan secara manual dalam Java — tanpa menggunakan built-in library seperti `ArrayList`, `HashMap`, atau `Collections.sort()`.

---

## 👥 Anggota Kelompok & Pembagian Tugas

### Assignment 1 — Struktur Data

| Student | Data Structure | Module Class | Key Methods |
|---------|---------------|--------------|-------------|
| Rusdi Aditya | Dynamic Array | `MenuManager.java` | `addItem`, `removeItem`, `findById`, `findByCategory`, `listAll`, `size`, `isEmpty` |
| Muhammad Dzaki Al Hassani Ihsan | Queue (linked nodes) | `KitchenQueue.java` | `enqueue`, `dequeue`, `peek`, `isEmpty`, `size`, `displayQueue` |
| Ahmad Nurul Fajar | Stack (linked nodes) | `CompletedOrderStack.java` | `push`, `pop`, `peek`, `isEmpty`, `size`, `displayHistory` |
| Dinda Nurhaliza Siregar | HashMap (array of buckets) | `MenuCategoryIndex.java` | `put`, `get`, `remove`, `containsKey`, `listAllKeys`, `size` |

### Assignment 2 — Algoritma

| Student | Algorithm | Module Class | Key Methods |
|---------|-----------|--------------|-------------|
| Rusdi Aditya | Sorting (Insertion + Merge Sort) | `MenuSorter.java` | `sortByPrice`, `sortByCategory`, `printList` |
| Muhammad Dzaki Al Hassani Ihsan | Priority Queue (sorted insertion) | `PriorityKitchenQueue.java` | `enqueue`, `dequeueMax`, `peek`, `isEmpty`, `display` |
| Ahmad Nurul Fajar | Binary Search Tree (BST) | `OrderBST.java` | `insert`, `search`, `delete`, `inOrderTraversal`, `findMin`, `findMax` |
| Dinda Nurhaliza Siregar | Graph (adjacency list + BFS/DFS) | `RestaurantGraph.java` | `addNode`, `addEdge`, `BFS`, `DFS`, `hasPath`, `printGraph` |

---

## 🗂️ Shared Entity Classes

Kelas-kelas berikut digunakan bersama oleh seluruh anggota kelompok:

```java
// MenuItem.java
String id, name, category;
int price;

// Order.java
String id;
int tableNo, totalPrice;

// OrderItem.java
String menuItemId;
int qty, subtotal;
```

---

## 📦 Struktur Folder

```
Restaurant-Order-Management-System-Group5
├── shared
│    ├── MenuItem.java
│    ├── Order.java
│    ├── OrderItem.java
├── Student-1-[Rusdi Aditya]
│    ├── MenuManager.java              # S1 - Dynamic Array
│    ├── MenuManagerDemo.java
│    ├── MenuSorter.java               # S1 - Sorting
│    ├── MenuSorterDemo.java
├── Student-2-[Muhammad Dzaki Al Hassani Ihsan]
│    ├── KitchenQueue.java             # S2 - Queue
│    ├── KitchenQueueDemo.java
│    ├── PriorityKitchenQueue.java     # S2 - Priority Queue
│    ├── PriorityKitchenQueueDemo.java
├── Student-3-[Ahmad Nurul Fajar]
│    ├── CompletedOrderStack.java      # S3 - Stack
│    ├── CompletedOrderStackDemo.java
│    ├── OrderBST.java                 # S3 - Binary Search Tree
│    ├── OrderBSTDemo.java
├── Student-4-[Dinda Nurhaliza Siregar]
│    ├── MenuCategoryIndex.java        # S4 - HashMap
│    ├── MenuCategoryIndexDemo.java
│    ├── RestaurantGraph.java          # S4 - Graph
│    ├── RestaurantGraphDemo.java
└── README.md                          # README File
```

---

## 🔍 Penjelasan Tiap Modul

### S1 — MenuManager (Dynamic Array)
Menyimpan daftar seluruh menu restoran menggunakan array dinamis yang bisa membesar otomatis.
Memungkinkan pencarian menu berdasarkan ID atau kategori.

### S1 — MenuSorter (Sorting)
Mengurutkan daftar menu berdasarkan harga menggunakan Insertion Sort, dan berdasarkan kategori alfabetis menggunakan Merge Sort.

### S2 — KitchenQueue (Queue)
Mengatur antrian pesanan yang masuk ke dapur menggunakan struktur Queue (FIFO — First In First Out).
Pesanan yang pertama masuk akan pertama dimasak.

### S2 — PriorityKitchenQueue (Priority Queue)
Mengatur antrian dapur dengan prioritas — order dari meja VIP dimasak lebih dulu dibanding order reguler, menggunakan sorted insertion.

### S3 — CompletedOrderStack (Stack)
Menyimpan riwayat pesanan yang telah selesai dimasak menggunakan struktur Stack (LIFO — Last In First Out).
Pesanan terakhir yang selesai bisa dibatalkan (undo) lebih dulu.

### S3 — OrderBST (Binary Search Tree)
Menyimpan seluruh order dalam struktur BST yang di-key oleh Order ID, memungkinkan pencarian cepat dan listing terurut lewat in-order traversal.

### S4 — MenuCategoryIndex (HashMap + Chaining)
Mengindeks menu berdasarkan kategori menggunakan HashMap dengan teknik chaining untuk menangani collision.

### S4 — RestaurantGraph (Graph + BFS/DFS)
Memodelkan denah restoran sebagai graf — meja sebagai node, edge merepresentasikan zona pelayan yang sama antar meja. BFS dan DFS dipakai untuk menelusuri meja yang saling terjangkau.

**Contoh output:**
```
=== Denah Restoran ===
Meja1 → [Meja2, Meja5]
Meja2 → [Meja1, Meja3]
Meja3 → [Meja2, Meja4]
Meja4 → [Meja3]
Meja5 → [Meja1]

=== BFS dari Meja1 ===
Meja1 → Meja2 → Meja5 → Meja3 → Meja4

=== DFS dari Meja1 ===
Meja1 → Meja2 → Meja3 → Meja4 → Meja5

Ada jalur Meja1→Meja4? true
```

---

## ▶️ Cara Menjalankan

1. Clone repository ini
```bash
git clone https://github.com/username/restaurant-order-management-system.git
```

2. Masuk ke folder project
```bash
cd restaurant-order-management-system
```

3. Compile modul yang ingin dijalankan, misalnya modul S4
```bash
cd Student-4-[Dinda Nurhaliza Siregar]
javac RestaurantGraph.java RestaurantGraphDemo.java
```

4. Jalankan program
```bash
java RestaurantGraphDemo
```

---

## 🌿 Git Workflow

Setiap anggota bekerja di branch masing-masing:

```
main
├── feature/menu-manager           # S1 (Assignment 1)
├── feature/menu-sorter            # S1 (Assignment 2)
├── feature/kitchen-queue          # S2 (Assignment 1)
├── feature/priority-kitchen-queue # S2 (Assignment 2)
├── feature/completed-order-stack  # S3 (Assignment 1)
├── feature/order-bst              # S3 (Assignment 2)
├── feature/menu-category-index    # S4 (Assignment 1)
└── feature/restaurant-graph       # S4 (Assignment 2)
```

Setelah selesai, buat **Pull Request** ke branch `main` dan selesaikan merge conflict jika ada.

---

## 📹 Video Submission

| Video | Judul | Durasi |
|-------|-------|--------|
| Video 1 | Problem Decomposition | 5–8 menit |
| Video 2 | Application Design (Class Diagram) | 5–10 menit |
| Video 3 | Live Coding | Bebas (boleh dibagi beberapa bagian) |
| Video 4 | Git Workflow | 5–8 menit |

---

## 📝 Catatan

- Seluruh struktur data dan algoritma diimplementasikan **dari scratch** tanpa built-in Java collections
- Bahasa yang digunakan: **Bahasa Indonesia / English** (keduanya diterima)
- Dalam proses pengerjaan boleh menggunakan AI, dengan catatan bukan built-in IDE, atau auto completion.
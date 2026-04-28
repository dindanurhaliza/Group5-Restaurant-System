package student4_dinda;

import shared.MenuItem;

//================================================================
// MenuCategoryIndex.java
// NIM  : 251552010017
// Nama : Dinda Nurhaliza Siregar
// Kelas: Group 5 - Restaurant Order Management System
// Peran: S4 - HashMap Manual (Array of Buckets + Chaining)
//================================================================

public class MenuCategoryIndex {


// ---------------------------------------------------------------
    // INNER CLASS: Entry
    // Node tunggal dalam linked list (chain) di setiap bucket.
    // Setiap Entry menyimpan key, value, dan pointer ke Entry berikutnya.

// ---------------------------------------------------------------
    private static class Entry {
        String key;
        MenuItem value;
        Entry next;

        Entry(String key, MenuItem value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }


// -------------------------------------------------------------
    // FIELDS

// -------------------------------------------------------------
    private static final int INITIAL_CAPACITY = 16;
    private Entry[] buckets;
    private int size;


// -------------------------------------------------------------
    // CONSTRUCTOR
    // Inisialisasi array bucket kosong berukuran 16.
    // Semua slot bernilai null di awal.

// -------------------------------------------------------------
    public MenuCategoryIndex() {
        buckets = new Entry[INITIAL_CAPACITY];
        size = 0;
    }


// ------------------------------------------------------------
    // PRIVATE HELPER: hash(Stringkey)
    // Mengubah key (String) menjadi indeks bucket yang valid (0-15).
    // Menggunakan Polynomial Rolling Hash dengan konstanta 31.
    // Rumus: hashCode = 31 * hashCode + ASCII(char)
    // Math.abs() memastikan hasilnya positif.
    // % buckets.length memastikan hasilnya masuk rentang 0..15.

// ------------------------------------------------------------
    private int hash(String key) {
        if (key == null) return 0;
        int hashCode = 0;
        for (int i = 0; i < key.length(); i++) {
            hashCode = 31 * hashCode + key.charAt(i);
        }
        return Math.abs(hashCode) % buckets.length;
    }


// -----------------------------------------------------------
    // PUT(String key, MenuItem value)
    // Menambah atau memperbarui entry berdasarkan key.
    //
    // Alur:
    // 1. Hitung indeks bucket dari key.
    // 2. Traversal chain di bucket tersebut.
    //    - Jika key sudah ada → UPDATE value, langsung return.
    // 3. Jika key belum ada → buat Entry baru dan PREPEND 
    //    (sisipkan di kepala chain) → O(1).
    // 4. Increment size.

// -----------------------------------------------------------
    public void put(String key, MenuItem value) {
        int index = hash(key);
        Entry current = buckets[index];

        // Cek apakah key sudah ada (UPDATE)
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        // Key belum ada → INSERT di kepala chain (prepend)
        Entry newEntry = new Entry(key, value);
        newEntry.next = buckets[index];    // sambungkan ke chain lama
        buckets[index] = newEntry;         // jadikan kepala baru
        size++;
    }


// ------------------------------------------------------------
    // GET(String key)
    // Mengambil MenuItem bedasarkan key.
    //
    // Alur:
    // 1. Hitung indeks bucket.
    // 2. Traversal chain sampai key cocok → return value.
    // 3. Jika tidak ditemukan → cetak pesan & return null.

// -------------------------------------------------------------
    public MenuItem get(String key) {
        int index = hash(key);
        Entry current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                System.out.println("Ditemukan: " + current.value);
                return current.value;
            }
            current = current.next;
        }

        System.out.println("Tidak ditemukan: ID " + key);
        return null;
    }


// -------------------------------------------------------------
    // REMOVE(String key)
    // Menghapus entry berdasarkan key.
    //
    // Menggunakan teknik TWO-POINTER (previous + current):
    // - Jika node yang dihapus di KEPALA chain:
    //     previous.next = current.next
    //   (node current terisolasi, diambil GC Java)

 // --------------------------------------------------------
    public boolean remove(String key) {
        int index      = hash(key);
        Entry current  = buckets[index];
        Entry previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    // Node ada di kepala chain
                    buckets[index] = current.next;
                } else {
                    // Node ada di tengah atau akhir chain
                    previous.next = current.next;
                }
                size--;
                System.out.println("Menu " + key + " berhasil dihapus.");
                return true;
            }
            previous = current;
            current = current.next;
        }

        System.out.println("Gagal menghapus: ID " + key + "tidak ditemukan.");
        return false;
    }
    

// ---------------------------------------------------------
    // CONTAINSKEY(String key)
    // Mengecek apakah key ada di HashMap.
    // Reuse metode get() — jika hasilnya bukan null, key ada.
    // Tidak mencetak pesan dari get() karena ini cek boolean saja,
    // sehingga kita lakukan traversal manual tanpa print.

// ----------------------------------------------------------
    public boolean containsKey(String key) {
        int index = hash(key);
        Entry current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


// ------------------------------------------------------------
    // LISTALLKEY()
    // Menampilkan semua key yang tersimpan.
    // Loop semua 16 buckets, lalu traversal tiap chain-nya.

// ------------------------------------------------------------
    public void listAllKeys() {
        System.out.println("=== Semua ID Menu (" + size + " item) ===\n");
        StringBuilder sb      = new StringBuilder();
        int             count = 0;

        for (int i = 0; i < buckets.length; i++) {
            Entry current = buckets[i];
            while (current != null) {
                if (count > 0) sb.append(",");
                sb.append(current.key);
                count++;
                current = current.next;
            }
        }

        if (count == 0) {
            System.out.println(" (Tidak ada menu tersimpan)");
        } else {
            System.out.println(sb.toString());
        }
    }


// ----------------------------------------------------------------
    // SIZE()
    // Mengembalikan jumlah entry yang tersimpan.
    // Field size sudah dikelola manual di put() dan remove(),
    // sehingga ini cukup O(1) — tidak perlu hitung ulang.

// ----------------------------------------------------------------
    public int size() {
        return size;
    }
}

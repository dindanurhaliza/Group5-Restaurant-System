import java.util.PriorityQueue;
import java.util.Comparator;

// Class Penumpang
class Passenger {
    String name;
    String kelas;

    Passenger(String name, String kelas) {
        this.name = name;
        this.kelas = kelas;

    }
}

public class PriorityBoardingQueue {

    // Fungsi untuk menentukan prioritas
    public static int getPriority(String kelas) {
        if (kelas.equalsIgnoreCase("First")) return 1;
        if (kelas.equalsIgnoreCase("Bisnis")) return 2;
        return 3; // Ekonomi
    }
public static void main(String[] args) {

    // Priority Queue dengan aturan prioritas
    PriorityQueue<Passenger> queue = new PriorityQueue<>(
        new comparator<Passenger>() {
            public int compare(Passenger a, Passenger b) {
                return getPriority(a.kelas) - getPriority(b.Kelas);
            }
        }
    );

// Data contoh (acak)
queue.add(new Passenger("Andi", "Ekonomi"));
queue.add(new Passenger("Budi", "First"));
queue.add(new Passenger("Citra", "Bisnis"));
queue.add(new Passenger("Dewi", "Ekonomi"));

// Output
System.out.println("=== Urutan Boarding ===");

while (!queue.isEmpty()) {
    Passenger p = queue.poll();
    System.out.println(p.name + " (" + p.kelas +  ")");
        }
    }
}
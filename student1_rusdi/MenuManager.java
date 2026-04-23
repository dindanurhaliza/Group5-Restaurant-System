package student1_rusdi;
import java.util.ArrayList;
// class support soalnya file shared belom jadi hehe

class MenuItem {
    int id;
    String name;
    double price;

    MenuItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}


public class MenuManager {
    private ArrayList<MenuItem> daftarMenu;
    public MenuManager() {
        this.daftarMenu = new ArrayList<>();
    }

    // fungsi utama s1 buat nsmbah menu
    public void tambahMenu(int id, String nama, double price) {
        MenuItem baru = new MenuItem(id, nama, price);
        daftarMenu.add(baru);
        System.out.println("berhasil input menu: " + nama);
    }

    // fungsi utama menampilkan daftar 
    public void tampilkanMenu() {
        System.out.println("\n=== REATORAN KEL 5 - DAFTAR MENU ===");
        for (MenuItem m : daftarMenu) {
            System.out.println("id:" + m.id + "| " + m.name +" | Harga: Rp" + m.price);
        }
    } 

    //main method langsung run 
    public static void main (String[] args) {
        MenuManager app = new MenuManager();

        //input menu
        app.tambahMenu(101, "Nasi goreng", 25000);
        app.tambahMenu(102, "ayam bakar ", 32000);
        app.tambahMenu(201, "es jeruk", 5000);

        // tampilkan hasil 
        app.tampilkanMenu();
    }
}
package student1_rusdi;

import shared.MenuItem;

public class MenuManager {
    private MenuItem[] daftarMenu;
    private int size;
    private int capacity;

    public MenuManager() {
        this.capacity = 2;
        this.daftarMenu = new MenuItem[capacity];
        this.size = 0;

    }

    private void grow() {
        this.capacity = this.capacity*2;
        MenuItem[] newArray = new MenuItem[capacity];


        for (int i = 0; i < size; i++) {
            newArray[i] = daftarMenu[i];
        }

        this.daftarMenu = newArray;
        System.out.println("over over array diperluas" + capacity + "-");

    }


    public void tambahMenu(int id, String nama, double price){
        if (size == capacity){
            grow();
        }
        MenuItem baru = new MenuItem(id, nama, "makanan", price);
        daftarMenu[size] = baru;
        size ++;
        System.out.println("input menu:" + nama);

    }
    public void tampilkanMenu() {
        System.out.println("daftar menu");

        for (int i = 0; i < size; i++) {
            MenuItem m = daftarMenu[i];
            System.out.println("id: " + m.id + " | " + m.name + "| Harga: Rp" + m.price);

        }
        }
        public static void main(String[] agrs) {
            MenuManager app = new MenuManager();
            
            app.tambahMenu(101, "NASI GORENG", 20000);
            app.tambahMenu(102, "AYAM BAKAR", 25000);
            app.tambahMenu(202, "ES JERUK",5000);
            app.tambahMenu(203, "KOPI", 6000);
            app.tambahMenu(204, "CENDOL DUREN", 10000);
            

            app.tampilkanMenu();
    }
}



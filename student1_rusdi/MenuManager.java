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

private void grow(){
    this.capacity = this.capacity*2;
    MenuItem[] newArray = new MenuItem[capacity];

    for (int i = 0; i < size; i++){
        newArray[i] = daftarMenu[i];


}

this.daftarMenu = newArray;
System.out.println("LOG: kapasitas mencapai batar. array diperluas " + capacity + "---");
}


public void tambahMenu(int id, String nama, double price) {
    if (size == capacity){
        grow();
    }

        MenuItem baru = new MenuItem(id, nama, "makanan", price);
        daftarMenu[size] = baru;
        size++;
        System.out.println("berhasil input menu" + nama);

    
}

public void tampilkanMenu(){
    System.out.println("\n=== DAFTAR MENU ===");
    for(int i = 0; i < size; i++){
        MenuItem m = daftarMenu[i];
        System.out.println("ID:" + m.id + " | "  + m.name + " | Harga: Rp" + m.price
        );

    }
}

public static void main(String[] args) {
    MenuManager app = new MenuManager();
    app.tambahMenu(101, "nasi goreng", 20000);
     app.tambahMenu(102, "ayam bakar", 25000);
      app.tambahMenu(202, "es jeruk", 5000);
       app.tambahMenu(203, "kopi", 6000);
       app.tambahMenu(204, "cendol duren", 10000);
       
       app.tampilkanMenu();
}

}
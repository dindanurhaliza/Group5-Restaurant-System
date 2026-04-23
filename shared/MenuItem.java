package shared;

public class MenuItem {
    public int id;
    public String name;
    public String type; // makanan atau minuman
    public double price; 

    public MenuItem(int id, String name, String type, double price)

{
    this.id = id;
    this.name = name;
    this.type = type;
    this.price = price;

}
}


package shared;

public class Order {
    private String id;
    private int tableNo;
    private int totalPrice;

    public Order(String id, int tableNo, int totalPrice) {
        this.id = id;
        this.tableNo = tableNo;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(Stirng Id) {
        this.id = id;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "[" + id + "] Meja " + tableNo + " - Rp" + totalPrice;
    }
}

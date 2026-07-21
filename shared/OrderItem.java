public class OrderItem {
    private String menuItemId;
    private int qty;
    private int subtotal;

    public OrderItem(String menuItemId, int qty, int subtotal) {
        this.menuItemId = menuItemId;
        this.qty = qty;
        this.subtotal = subtotal;
    }

    public String getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(String menuItemId) {
        this.menuItemId = menuItemId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    Public String toString {
        return "MenuItem[" + menuItemId + "] x" + qty + " = Rp" + subtotal;
    }
}
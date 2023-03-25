/*
 * Name: Tien Tran
 * Date: 03/24/2023
 * Description: Sales and inventory Java project
 */

public class InventoryItem {
    private String itemName;
    private String itemId;
    private int quantity;
    private double price;
    private double sales;

    public InventoryItem(String itemName, String itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.sales = 0.0;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public void addSales(double amount) {
        this.sales += amount;
    }

    public String toString() {
        return itemName + "," + itemId + "," + quantity + "," + price + "," + sales;
    }
}

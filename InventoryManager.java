/*
 * Name: Tien Tran
 * Date: 03/24/2023
 * Description: Sales and inventory Java project
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InventoryManager {
    private ArrayList<InventoryItem> inventory;

    public InventoryManager() {
        inventory = new ArrayList<InventoryItem>();
    }

    public void addInventoryItem(InventoryItem item) {
        inventory.add(item);
    }

    public void removeInventoryItem(String itemId) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getItemId().equals(itemId)) {
                inventory.remove(i);
                break;
            }
        }
    }

    public void updateInventoryItem(String itemId, InventoryItem newItem) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getItemId().equals(itemId)) {
                inventory.set(i, newItem);
                break;
            }
        }
    }

    public void inputSales() {
        Scanner scanner = new Scanner(System.in);
        for (InventoryItem item : inventory) {
            System.out.printf("Enter sales for %s (item ID %s): ", item.getItemName(), item.getItemId());
            double sales = scanner.nextDouble();
            item.addSales(sales);
        }
        scanner.close();
    }

    public void generateSalesReport() {
        double totalSales = 0;
        for (InventoryItem item : inventory) {
            double itemSales = item.getSales();
            totalSales += itemSales;
            System.out.printf("%s (item ID %s) - Total sales: $%.2f\n", item.getItemName(), item.getItemId(), itemSales);
        }
        System.out.printf("Total sales for store: $%.2f\n", totalSales);
    }

    public void saveInventoryToFile(String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        for (InventoryItem item : inventory) {
            writer.write(item.toString());
            writer.write("\n");
        }
        writer.close();
    }

    public void loadInventoryFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            String itemName = parts[0];
            String itemId = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            double price = Double.parseDouble(parts[3]);
            InventoryItem item = new InventoryItem(itemName, itemId, quantity, price);
            if (parts.length == 5) {
                double sales = Double.parseDouble(parts[4]);
                item.setSales(sales);
            }
            inventory.add(item);
        }
        scanner.close();
    }

}

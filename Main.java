/*
* Name: Tien Tran
* Date: 03/24/2023
* Description: Sales and inventory Java project
*/

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Update item");
            System.out.println("4. Input sales");
            System.out.println("5. Generate sales report");
            System.out.println("6. Save inventory to file");
            System.out.println("7. Load inventory from file");
            System.out.println("8. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();

                    System.out.print("Enter item ID: ");
                    String itemId = scanner.nextLine();

                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    System.out.print("Enter price per unit: ");
                    double price = scanner.nextDouble();

                    InventoryItem item = new InventoryItem(itemName, itemId, quantity, price);
                    manager.addInventoryItem(item);

                    System.out.println("Item added to inventory.");
                    break;

                case 2:
                    System.out.print("Enter item ID to remove: ");
                    String idToRemove = scanner.nextLine();
                    manager.removeInventoryItem(idToRemove);

                    System.out.println("Item removed from inventory.");
                    break;

                case 3:
                    System.out.print("Enter item ID to update: ");
                    String idToUpdate = scanner.nextLine();

                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();

                    System.out.print("Enter new price per unit: ");
                    double newPrice = scanner.nextDouble();

                    InventoryItem newItem = new InventoryItem("", idToUpdate, newQuantity, newPrice);
                    manager.updateInventoryItem(idToUpdate, newItem);

                    System.out.println("Item updated in inventory.");
                    break;

                case 4:
                    manager.inputSales();
                    System.out.println("Sales data inputted.");
                    break;

                case 5:
                    manager.generateSalesReport();
                    break;

                case 6:
                    System.out.print("Enter file name to save inventory to: ");
                    String fileNameToSave = scanner.nextLine();
                    try {
                        manager.saveInventoryToFile(fileNameToSave);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("Inventory saved to file.");
                    break;

                case 7:
                    System.out.print("Enter file name to load inventory from: ");
                    String fileNameToLoad = scanner.nextLine();
                    try {
                        manager.loadInventoryFromFile(fileNameToLoad);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("Inventory loaded from file.");
                    break;

                case 8:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}

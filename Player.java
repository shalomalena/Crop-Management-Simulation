import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Map;

public class Player {
    private int money;
    CropNode crop = cropDetailsBST.search(type);

    private HashMap<String, Integer> inventory;
    private HashMap<String, String> cropStatus; // Tracks the status of each crop
    private Queue<String> tasks;
    private Random random;
    private int waterInventory;
    private int fertilizerInventory;
    private HashMap<String, Boolean> watered; // Tracks if a crop has been watered

    public Player() {
        this.money = 500;
        this.cropDetailsBST = new CropDetailsBST();
        this.inventory = new HashMap<>();
        this.cropStatus = new HashMap<>();
        this.tasks = new LinkedList<>();
        this.random = new Random();
        this.waterInventory = 100;
        this.fertilizerInventory = 20;
        this.watered = new HashMap<>();
        initializeCrops();
    }

    private void initializeCrops() {
        cropDetailsBST.insert("Wheat", 5, 50, 10, 2, 1.5);
        cropDetailsBST.insert("Corn", 7, 70, 15, 3, 2.0);
        cropDetailsBST.insert("Carrot", 4, 40, 8, 1, 2.5);
        cropDetailsBST.insert("Potato", 6, 60, 12, 2, 2.0);
        cropDetailsBST.insert("Tomato", 3, 30, 6, 1, 3.0);
    }

    public boolean buyCrop(String type) {
        CropNode crop = cropDetailsBST.search(type);
        if (crop != null && money >= crop.salePrice) {
            money -= crop.salePrice;
            inventory.put(type, inventory.getOrDefault(type, 0) + 1);
            cropStatus.put(type, "Bought");
            System.out.println("Purchased " + type + " for " + crop.salePrice);
            return true;
        } else {
            System.out.println("Not enough money or crop not available.");
            return false;
        }
    }

    public void sellCrop(String type) {
        Integer count = inventory.get(type);
        if (count != null && count > 0 && "Harvested".equals(cropStatus.get(type))) {
            CropNode crop = cropDetailsBST.search(type);
            if (crop != null) {
                int revenue = (int) (count * crop.salePrice * crop.yieldMultiplier);
                money += revenue;
                inventory.put(type, 0); // Remove all of this crop from inventory after selling
                cropStatus.put(type, "Sold");
                System.out.println("Sold " + count + " units of " + type + " for $" + revenue);
            } else {
                System.out.println("Crop details not found for " + type);
            }
        } else {
            System.out.println("No " + type + " ready or available to sell.");
        }
    }

    public void displayMoney() {
        System.out.println("Current money: $" + money);
    }

    public void displayInventory() {
        System.out.println("Current Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Water Inventory: " + waterInventory + " liters");
        System.out.println("Fertilizer Inventory: " + fertilizerInventory + " kg");
    }

    public void processTask(String task) {
        String[] parts = task.split(" ");
        String action = parts[0];
        String cropType = parts[1];

        switch (action) {
            case "Plant":
                plantCrop(cropType);
                tasks.offer(cropType);
                break;
            case "Water":
                waterCrop(cropType);
                break;
            case "Fertilize":
                fertilizeCrop(cropType);
                break;
            case "Harvest":
                harvestCrop(cropType);
                break;
            default:
                System.out.println("Unknown task: " + task);
                break;
        }
    }

    private void plantCrop(String type) {
        inventory.put(type, inventory.getOrDefault(type, 0) + 1);
        cropStatus.put(type, "Planted");
        System.out.println("Planted " + type);
    }

    private void waterCrop(String type) {
        if (waterInventory > 0) {
            waterInventory -= 5; // Example water usage per task
            watered.put(type, true);
            cropStatus.put(type, "Watered");
            System.out.println("Watered " + type);
        } else {
            System.out.println("Not enough water.");
        }
    }

    private void fertilizeCrop(String type) {
        if (fertilizerInventory > 0) {
            fertilizerInventory -= 1; // Example fertilizer usage per task
            CropNode crop = cropDetailsBST.search(type);
            if (crop != null) {
                crop.salePrice *= 2; // Double the sale price of the crop
            }
            cropStatus.put(type, "Fertilized");
            System.out.println("Fertilized " + type);
        } else {
            System.out.println("Not enough fertilizer.");
        }
    }

    private void harvestCrop(String type) {
        if (type.isEmpty()) {
            // If no specific crop type is provided, harvest the first crop from the tasks
            // queue
            if (!tasks.isEmpty()) {
                type = tasks.peek(); // Get the first crop type from the tasks queue
            } else {
                System.out.println("No crops to harvest.");
                return;
            }
        }

        if (inventory.containsKey(type) && inventory.get(type) > 0) {
            int quantity = inventory.get(type);
            inventory.put(type, quantity - 1); // Decrease the quantity of the harvested crop

            CropNode crop = cropDetailsBST.search(type); // Corrected
            if (crop != null) {
                int yield = (int) (crop.salePrice * crop.yieldMultiplier);
                money += yield;
                System.out.println("Harvested " + type + " and sold for " + yield);
            }
        } else {
            System.out.println("No " + type + " in inventory to harvest.");
        }
    }

}

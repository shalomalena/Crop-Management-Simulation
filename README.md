# Crop Management Simulation

This project is a crop management simulation game where players can buy, sell, and manage crops through various farming tasks such as watering, fertilizing, and harvesting. The game is developed in Java and demonstrates concepts like data structures (Binary Search Tree), resource management, and task scheduling.

## Features

### Crop Management:
- Players can purchase different crops, plant them, and manage their growth.
- Crops can be watered, fertilized, and harvested at appropriate stages to maximize yield and profit.

### Inventory System:
- Players have a limited amount of money to buy crops and resources (water, fertilizer).
- Track how much of each crop is in inventory, how much water and fertilizer is available, and overall resources.

### Task Processing:
- Tasks like planting, watering, fertilizing, and harvesting are tracked in a task queue and processed in order.

### Resource Management:
- Players must manage their water and fertilizer supply to grow their crops effectively.

### Binary Search Tree (BST):
- A BST is used to store and retrieve crop details efficiently based on crop type.

### Crop Details:
- Each crop has different attributes such as growth time, sale price, water needed, fertilizer needed, and yield multiplier, all stored in the BST.

## Project Structure

- **CropDetailsBST.java**: Contains the Binary Search Tree implementation to manage crop details.
- **CropNode.java**: Defines the CropNode class, which represents each crop in the BST.
- **Player.java**: Manages the player's inventory, money, and tasks. Includes methods for buying, selling, watering, fertilizing, and harvesting crops.
- **Main.java**: Contains the main game loop, where players can interact with the simulation through a console-based menu.
- **Resources.java**: Manages the resources (water, fertilizer) available to the player.

## How to Play

- **Buy Crop**: Purchase a crop by entering its name. The crop is added to your inventory if you have enough money.
- **Sell Crop**: Sell harvested crops for profit. Crops must be harvested before they can be sold.
- **Check Money**: View how much money you currently have.
- **View Inventory**: Check the crops and resources (water, fertilizer) in your inventory.
- **Process Task**: Perform tasks like planting, watering, fertilizing, and harvesting crops.
- **Quit**: Exit the game.

## Future Enhancements

- **Graphical User Interface (GUI)**: Implementing a GUI using JavaFX or Swing to replace the console-based interface.
- **Database Integration**: Store player progress and crop data in a database (e.g., MySQL, SQLite).
- **Real-Time Task Scheduling**: Add real-time task processing, where crop growth and tasks like watering occur over time.
- **Multiplayer Mode**: Introduce a networking component where players can trade crops with each other.

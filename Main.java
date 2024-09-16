import java.util.Scanner;  

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        boolean quit = false;

        while (!quit) {
            System.out.println("\nMenu:");
            System.out.println("1. Buy Crop");
            System.out.println("2. Sell Crop");
            System.out.println("3. Check Money");
            System.out.println("4. View Inventory");
            System.out.println("5. Process Task");
            System.out.println("6. Quit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the type of crop to buy: ");
                    String buyType = scanner.nextLine();
                    player.buyCrop(buyType);
                    break;
                case 2:
                    System.out.print("Enter the type of crop to sell: ");
                    String sellType = scanner.nextLine();
                    player.sellCrop(sellType);
                    break;
                case 3:
                    player.displayMoney();
                    break;
                case 4:
                    player.displayInventory();
                    break;
                case 5:
                    System.out.print("Enter a task to process (Format: Action CropType): ");
                    String task = scanner.nextLine();
                    player.processTask(task);
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
        System.out.println("Thank you for playing!");
    }
}

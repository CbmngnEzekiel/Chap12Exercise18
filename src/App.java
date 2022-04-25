import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Inventory inventory = new Inventory();
        Item item;
        Scanner sc = new Scanner(System.in);

        int menuChoice = 0;

        do{
            System.out.println("[1] Display products.");
            System.out.println("[2] Add a product.");
            System.out.println("[3] Discontinue a product.");
            System.out.println("[4] Display product information");
            System.out.println("[0] Exit");
            menuChoice = sc.nextInt();

            switch(menuChoice){
                case 1 ->{
                	if(inventory.getItemList().size() == 0) {
                		System.out.println("No items in the inventory.");
                	}else {
                        inventory.getItemList().forEach((n)->{
                            System.out.printf("Item ID: %d \nItem Name: %s \nItem Stock: %d\n\n", n.getStockNumber(), n.getItemName(), n.getStock());
                        });
                	}
                }
                case 2 ->{
                    sc.nextLine();
                    String itemName = "";
                    int stock = 0;
                    int itemId = 0;

                    System.out.println("Enter item name: ");
                    itemName = sc.nextLine();

                    System.out.println("Enter Initial Stock: ");
                    stock = sc.nextInt();

                    itemId = inventory.getItemList().size() + 1000;

                    item = new Item(itemId, itemName, stock);

                    inventory.addItem(item);
                }
                case 3 ->{
                    int itemId = 0;
                    System.out.println("Enter the ID of the product you wish to delete: ");
                    itemId = sc.nextInt();

                    inventory.discontinueItem(inventory.getItemList().get(itemId - 1000));
                }
                case 4 ->{
                    int itemId = 0;
                    System.out.println("Enter the ID of the product: ");
                    itemId = sc.nextInt();

                    inventory.displayProductInfo(inventory.getItemList().get(itemId - 1000));
                }
                case 0 -> {}
                default ->{
                    System.out.println("Invalid input!");
                }
            }

        }while(menuChoice != 0);
        
        sc.close();
    }
}

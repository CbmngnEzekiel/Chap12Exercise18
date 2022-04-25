import java.io.*;
import java.util.ArrayList;

public class Inventory {
    ArrayList<Item> itemList;
    File inventoryText;

    public Inventory(){
        this.itemList = new ArrayList<>();
        this.inventoryText = new File("inventory.txt");
    }

    public void addItem(Item item){
    	FileOutputStream fileOutput;
    	ObjectOutputStream objectOutput;
    	
    	try {
    		fileOutput = new FileOutputStream(inventoryText);
    		objectOutput = new ObjectOutputStream(fileOutput);
    		
    		objectOutput.writeObject(item);
    		this.itemList.add(item);
        	
            System.out.println("Item added successfully!: ");
            System.out.printf("Item ID: %d\n", item.getStockNumber());
            System.out.printf("Item name: %s\n", item.getItemName());
            System.out.printf("Item quantity: %d\n\n", item.getStock());
    		
            objectOutput.close();
            fileOutput.close();
    	}catch(FileNotFoundException e) {
    		System.out.println("File not found. " + e.getMessage());
    	}catch (IOException e) {
			System.out.println("Problem with input/output. " + e.getMessage());
		}
    }

    public void discontinueItem(Item item){
        System.out.println("Item discontinued.");
        item.setItemName("Discontinued");
        item.setStock(0);
    }

    public void displayProductInfo(Item item){
        System.out.printf("Item ID: %d\n", item.getStockNumber());
        System.out.printf("Item name: %s\n", item.getItemName());
        System.out.printf("Item quantity: %d\n\n", item.getStock());
    }

    public ArrayList<Item> getItemList(){
        return this.itemList;
    }
}

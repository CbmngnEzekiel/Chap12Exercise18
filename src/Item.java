import java.io.Serializable;

public class Item implements Serializable{
    private int stockNumber;
    private String itemName;
    private int stock;

    public Item(int stockNumber, String itemName, int stock){
        this.stockNumber = stockNumber;
        this.itemName = itemName;
        this.stock = stock;
    }

    public void setStockNumber(int stockNumber){
        this.stockNumber = stockNumber;
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public int getStockNumber(){
        return this.stockNumber;
    }

    public String getItemName(){
        return this.itemName;
    }

    public int getStock(){
        return this.stock;
    }
}

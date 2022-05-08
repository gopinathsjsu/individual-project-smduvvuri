import java.util.HashMap;
import java.util.HashSet;

public class Inventory {
    private static Inventory inventoryInstance;

    private Inventory(){

    }

    HashMap<String, String> itemPrice=new HashMap<String, String>();
    HashMap<String, String> itemQuantity=new HashMap<String, String>();
    HashMap<String, String> itemCategory=new HashMap<String, String>();
    HashSet<String> cards=new HashSet<String>();

    public HashMap<String, String> getItemPrice(){
        return itemPrice;
    }

    public HashMap<String, String> getItemQuantity(){
        return itemQuantity;
    }

    public HashMap<String, String> getItemCategory(){
        return itemCategory;
    }

    public HashSet<String> getCardDetails(){
        return cards;
    }

    public static Inventory getInstance(){
        if(inventoryInstance == null){
            inventoryInstance=new Inventory();
        }
        return inventoryInstance;
    }
}

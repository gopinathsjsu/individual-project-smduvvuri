import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ValidateOrder {
    public void validateTransaction(String inputFilePath){
        Inventory inventory = Inventory.getInstance();

        HashMap<String, Integer> cap=new HashMap<>();
        cap.put("Essentials",3);
        cap.put("Luxury",4);
        cap.put("Misc",6);

        Double totalPrice=0.0;
        int lineTracker=0;
        String cardnumber="";

        BufferedReader br=null;
        try {
            File file = new File(inputFilePath);
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = "";
            while((line = br.readLine()) != null) {
                if(lineTracker==0)
                    lineTracker++;
                else{
                    String[] array = line.split(",");
                    String item=array[0];
                    String category=inventory.getItemCategory().get(item);
                    int quantity=Integer.parseInt(array[1]);
                    System.out.println(category);
                    System.out.println(quantity);
                    if(array.length>2) {
                        System.out.println("card exists");
                        cardnumber = array[2];
                        lineTracker++;
                    }
                    if(Integer.parseInt(inventory.getItemQuantity().get(item))> quantity){
                        int currentcap=cap.get(category);
                        if(quantity<=currentcap){
                            totalPrice+=quantity*Double.parseDouble(inventory.getItemPrice().get(item));
                            int inventoryQuantity=Integer.parseInt(inventory.getItemQuantity().get(item));
                            cap.put(category,currentcap-quantity);
                            inventory.getItemQuantity().put(item, Integer.toString(inventoryQuantity-quantity));
                            System.out.println("Total "+totalPrice);
                        }
                        else{
                            System.out.println("Please correct quantities "+item);
                            break;
                        }
                        if(!inventory.getCardDetails().contains(cardnumber))
                            inventory.getCardDetails().add(cardnumber);
                    }
                    else{
                        System.out.println("Insufficient stock of "+item+" in inventory, please change the quantity for it.");
                        break;
                    }

                }
            }
            br.close();
        } catch(IOException io) {
            io.printStackTrace();
        }
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

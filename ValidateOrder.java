import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ValidateOrder {
    public void validateTransaction(String inputFilePath){
        ArrayList<String> itemList=new ArrayList<>();
        ArrayList<String> quantityList=new ArrayList<>();
        boolean flag=false;

        Inventory inventory = Inventory.getInstance();

        WriteOutputToFile writeOutputToFile=new WriteOutputToFile();

        File file1 =new File("output.txt");
        if(file1.exists()){
            file1.delete();
        }

        File file2 =new File("finaloutput.csv");
        if(file2.exists()){
            file2.delete();
        }

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
                    int price= Integer.parseInt(inventory.getItemPrice().get(item));
                    if(array.length>2) {
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
                            //writeOutputToFile.writeToCSVFile(item, quantity, price);
                            itemList.add(item);
                            quantityList.add(Integer.toString(quantity));
                            flag=true;
                        }
                        else{
                            writeOutputToFile.writeToTextFile("Please correct quantities of the following item\n", item);
                            System.out.println("Order could not be processed. Please check output.txt for details.");
                            flag=false;
                            break;
                        }
                        if(!inventory.getCardDetails().contains(cardnumber))
                            inventory.getCardDetails().add(cardnumber);
                    }
                    else{
                        writeOutputToFile.writeToTextFile("Insufficient stock of the following items \n", item);
                        System.out.println("Order could not be processed. Please check output.txt for details.");
                        flag=false;
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

        if(flag){
            System.out.println("Order processed. Please check 'finaloutput.csv' for the final invoice.");

            FileWriter pw2=null;
            try {
                pw2 = new FileWriter("finaloutput.csv", true);
                pw2.write("Item");
                pw2.write(",");
                pw2.write("Quantity");
                pw2.write(",");
                pw2.write("Price\n");


                for(int i=0;i<itemList.size();i++){
                    pw2.write(itemList.get(i));
                    pw2.write(",");
                    pw2.write(quantityList.get(i));
                    pw2.write(",");
                    pw2.write(inventory.getItemPrice().get(itemList.get(i)));
                    pw2.write("\n");
                }
                pw2.write("Total Price");
                pw2.write(" : ");
                pw2.write(String.valueOf(totalPrice));
                pw2.close();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

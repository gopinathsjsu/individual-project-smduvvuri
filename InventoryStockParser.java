import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class InventoryStockParser implements ParseCSVFile{
    private Inventory inventory = Inventory.getInstance();
    @Override
    public void parseFileContents(String filePath) {
        BufferedReader br=null;
        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = "";
            String[] array;
            while((line = br.readLine()) != null) {
                array = line.split(",");
                    inventory.getItemCategory().put(array[0], array[1]);
                    inventory.getItemQuantity().put(array[0], array[2]);
                    inventory.getItemPrice().put(array[0], array[3]);
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
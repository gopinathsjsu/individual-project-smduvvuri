import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class InventoryCardsParser implements ParseCSVFile{
    private Inventory inventory = Inventory.getInstance();
    @Override
    public void parseFileContents(String filePath) {
        BufferedReader br=null;
        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            while((line = br.readLine()) != null) {
                inventory.getCardDetails().add(line);
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


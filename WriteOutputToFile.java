import java.io.*;

public class WriteOutputToFile {

    public void writeToCSVFile(String item, int quantity, int price){


        FileWriter pw=null;
        try {

            pw = new FileWriter("finaloutput.csv", true);
            pw.write(item);
            pw.write(",");
            pw.write(Integer.toString(quantity));
            pw.write(",");
            pw.write(Integer.toString(price));
            pw.write("\n");
            pw.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeToTextFile(String message, String item){
        PrintWriter out = null;
        try {
            out = new PrintWriter("output.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        out.print(message);
        out.print(item);
        out.close();
    }
}

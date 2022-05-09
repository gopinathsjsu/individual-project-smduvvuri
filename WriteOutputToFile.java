import java.io.*;

public class WriteOutputToFile {

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

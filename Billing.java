import java.util.Scanner;

public class Billing {
    public static void main(String[] args){

        loadInventoryData();
        loadCardData();
        processOrderRequest();
    }

    public static void loadInventoryData(){
        ParseCSVFile obj=new InventoryStockParser();
        obj.parseFileContents("/Users/shreemathiduvvuri/IdeaProjects/Project/src/stock.csv");
    }

    public static void loadCardData(){
        ParseCSVFile obj=new InventoryCardsParser();
        obj.parseFileContents("/Users/shreemathiduvvuri/IdeaProjects/Project/src/cards.csv");
    }

    public static void processOrderRequest(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input file path");
        String inputPath = sc.nextLine();
        ValidateOrder validateOrder=new ValidateOrder();
        validateOrder.validateTransaction(inputPath);
    }
}
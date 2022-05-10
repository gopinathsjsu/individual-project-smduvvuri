# Individual Project CMPE 202

## Name: Shreemathi Duvvuri 
## SID: 015273102

### Project Description
Designed and developed a Java application to maintain an inventory of items. The application can process order requests and give the desired output- a .csv file with the final invoice and a .txt file if the order can not be processed.

### Steps to run the application
1. Run 
    `javac *.java` and then `java Billing` in the folder
3. There will be a prompt to enter the input file path
4. Enter the input file path
5. The application will be run and the either a .csv file (in case of successful transactions) or a .txt file (in case of issues while processing the order request). This will be displayed on the console

### Design Patterns

The following design patters are used in the application design:
1. Singleton
Singleton is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.
I have used this design pattern to implement the `Inventory.java` class. A global instance of this class is created to store the stock data and this instance is used throughout the run of the application.

2. Factory
Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.
I have used this design pattern in implementing the `ParseCSVFile` interface. This interface is implemented by `InventoryStockParser.java' and `InventoryCardsParser.java`.

3. Strategy
Strategy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.
I have used this design pattern to implement the `WriteOutputToFile.java` which is called whenever there is an issue and the class method is called for the specific error.

### Class Diagram

![IndividualProject_202](https://user-images.githubusercontent.com/37496654/167512554-f05ab21d-f164-4108-9a56-4f1e348c20fe.jpg)


### Screenshots of sample input order

<img width="1440" alt="Screen Shot 2022-05-09 at 3 31 49 PM" src="https://user-images.githubusercontent.com/37496654/167512645-18419617-fa0c-4d67-babb-724f05025e0f.png">


<img width="1440" alt="Screen Shot 2022-05-09 at 3 32 05 PM" src="https://user-images.githubusercontent.com/37496654/167512654-83549e95-e0db-4330-a8e9-4bc76e0c711f.png">


<img width="1440" alt="Screen Shot 2022-05-09 at 4 07 40 PM" src="https://user-images.githubusercontent.com/37496654/167512876-9aa7e6f8-d048-4f8d-99ee-85c5fd7f5139.png">


<img width="1440" alt="Screen Shot 2022-05-09 at 4 07 50 PM" src="https://user-images.githubusercontent.com/37496654/167512885-4af4a5d3-ccf0-40c4-b6e4-729f0a11850f.png">




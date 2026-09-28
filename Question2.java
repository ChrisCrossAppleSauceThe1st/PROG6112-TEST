import java.util.Scanner;

/*
 * Question 2: Console Sales Application
 * All the classes are in this one file. 
 */

// ---------- THE INTERFACE ----------
// An interface only lists the methods. The class that
// implements it must write the code for them.
interface IConsoles {
    String getConsoleType();   // returns the console type (PS5, XBOX or SWITCH)
    String getStore();         // returns the store name
    int getTotalSales();       // returns the total amount of sales
}

// ---------- THE ABSTRACT CLASS ----------
// It stores the console type, store name and total sales,
// and it implements the IConsoles interface.
// An abstract class cannot be created directly, so we
// make a subclass (ConsoleSales) to use it.
abstract class Consoles implements IConsoles {

    // Variables to store the details
    protected String consoleType;
    protected String store;
    protected int totalSales;

    // Constructor: accepts the console type, store name and total sales
    public Consoles(String consoleType, String store, int totalSales) {
        this.consoleType = consoleType;
        this.store = store;
        this.totalSales = totalSales;
    }

    // Method to get the console type
    @Override
    public String getConsoleType() {
        return consoleType;
    }

    // Method to get the store name
    @Override
    public String getStore() {
        return store;
    }

    // Method to get the total amount of sales
    @Override
    public int getTotalSales() {
        return totalSales;
    }

    // Abstract method: the subclass must write the code for this
    public abstract void printReport();
}

// ---------- THE SUBCLASS ----------
// ConsoleSales extends the abstract Consoles class
// and writes the code for the printReport method.
class ConsoleSales extends Consoles {

    // Constructor: accepts the console type, store name and total sales
    // and passes them to the parent class using super
    public ConsoleSales(String consoleType, String store, int totalSales) {
        super(consoleType, store, totalSales);
    }

    // Prints the console type, store name and total sales for the store
    @Override
    public void printReport() {
        System.out.println();
        System.out.println("CONSOLE SALES REPORT");
        System.out.println("********************");
        System.out.println("CONSOLE TYPE: " + getConsoleType());
        System.out.println("STORE: " + getStore());
        System.out.println("TOTAL SALES: " + getTotalSales());
    }
}

// ---------- THE RUN APPLICATION CLASS ----------
// Asks the user for the console type, store name and total sales,
// creates a ConsoleSales object and prints the report.
public class Question2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Show the menu so the user can pick a console type
        System.out.println("Select the console type");
        System.out.println("1) PS5");
        System.out.println("2) XBOX");
        System.out.println("3) SWITCH");
        int choice = input.nextInt();
        input.nextLine();   // clear the leftover Enter key

        // Turn the menu choice into the console name
        String consoleType;
        if (choice == 1) {
            consoleType = "PS5";
        } else if (choice == 2) {
            consoleType = "XBOX";
        } else if (choice == 3) {
            consoleType = "SWITCH";
        } else {
            System.out.println("Invalid choice. Please run the program again.");
            input.close();
            return;   // stop the program
        }

        // Ask for the store name
        System.out.print("Enter the store: ");
        String store = input.nextLine();

        // Ask for the total sales
        System.out.print("Enter the total sales of " + consoleType
                + " consoles for " + store + ": ");
        int totalSales = input.nextInt();

        // Create the ConsoleSales object and print the report
        ConsoleSales report = new ConsoleSales(consoleType, store, totalSales);
        report.printReport();

        input.close();
    }
}

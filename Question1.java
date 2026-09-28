/*
 * Question 1: Number 1 Electronics - Gaming Console Report
 * This program uses single and two-dimensional arrays to show
 * yearly console sales for 3 cities, the total per city,
 * and the city with the most sales.
 */
public class Question1 {

    public static void main(String[] args) {

        // ---------- DECLARATION OF ARRAYS ----------

        // Single-dimensional array: the names of the cities
        String[] cities = new String[3];

        // Single-dimensional array: the names of the consoles
        String[] consoles = new String[3];

        // Two-dimensional array: rows = cities, columns = consoles
        int[][] sales = new int[3][3];

        // Single-dimensional array: the total sales for each city
        int[] totals = new int[3];

        // ---------- POPULATION OF ARRAYS ----------

        // Fill in the city names
        cities[0] = "CAPE TOWN";
        cities[1] = "PORT ELIZABETH";
        cities[2] = "PRETORIA";

        // Fill in the console names
        consoles[0] = "PS5";
        consoles[1] = "XBOX";
        consoles[2] = "SWITCH";

        // Fill in the sales: sales[city][console]
        // Cape Town
        sales[0][0] = 1000;   // PS5
        sales[0][1] = 2000;   // XBOX
        sales[0][2] = 3000;   // SWITCH
        // Port Elizabeth
        sales[1][0] = 2000;
        sales[1][1] = 3000;
        sales[1][2] = 4000;
        // Pretoria
        sales[2][0] = 1500;
        sales[2][1] = 1100;
        sales[2][2] = 1200;

        // ---------- CALCULATE THE TOTAL FOR EACH CITY ----------

        // The outer loop goes through each city (row)
        for (int row = 0; row < 3; row++) {
            // The inner loop goes through each console (column)
            for (int col = 0; col < 3; col++) {
                // Add this console's sales to the city's total
                totals[row] = totals[row] + sales[row][col];
            }
        }

        // ---------- FIND THE CITY WITH THE MOST SALES ----------

        // Start by assuming the first city has the most sales
        int bestCity = 0;
        for (int i = 1; i < 3; i++) {
            // If this city's total is bigger, it becomes the best city
            if (totals[i] > totals[bestCity]) {
                bestCity = i;
            }
        }

        // ---------- PRINT THE REPORT ----------

        String line = "--------------------------------------------------------";

        System.out.println(line);
        System.out.println("GAMING CONSOLE REPORT");
        System.out.println(line);

        // Print the console names as the column headings
        System.out.printf("%-20s", "");   // empty space above the city names
        for (int col = 0; col < 3; col++) {
            System.out.printf("%-12s", consoles[col]);
        }
        System.out.println();

        // Print each city (row) with its sales for each console (columns)
        for (int row = 0; row < 3; row++) {
            System.out.printf("%-20s", cities[row]);
            for (int col = 0; col < 3; col++) {
                System.out.printf("%-12d", sales[row][col]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(line);
        System.out.println("CONSOLE SALES TOTALS FOR EACH CITY");
        System.out.println(line);

        // Print each city with its total sales
        for (int row = 0; row < 3; row++) {
            System.out.printf("%-20s%d%n", cities[row], totals[row]);
        }

        System.out.println();
        System.out.println(line);
        // Print the city with the most sales
        System.out.println("CITY WITH THE MOST SALES: " + cities[bestCity]);
        System.out.println(line);
    }
}

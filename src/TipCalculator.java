import java.util.Scanner;
import java.text.NumberFormat;

public class TipCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        System.out.println("Welcome to the tip calculator!");
        System.out.println("-------------------------------");
        int amountPeople = Integer.parseInt(askQuestion("How many people feasted on the food? : "));

        int tipPercentage = Integer.parseInt(askQuestion("What is the tip percentage? (0-100) : "));

        double priceEntered = 0;
        double finalBillPrice = 0;
        String foodEntered;
        int i = 0;

        String[] foodOrdered = new String[999];

        while (priceEntered > -1) {
            priceEntered = Double.parseDouble(askQuestion("Enter the cost of the food item purchased in dollars and cents (-1 to end) : "));
            finalBillPrice += priceEntered;

            if (priceEntered == -1) {
                break;
            }

            foodOrdered[i] = askQuestion("Enter the food ordered : ");
            i++;

        }
        finalBillPrice ++;

        System.out.println("-------------------------------");
        System.out.println("Total bill before the tip = " + formatter.format(finalBillPrice));
        System.out.println("Total percentage: " + tipPercentage + "%");

        double totalTip = (finalBillPrice * (tipPercentage / 100.0));
        double finalPrice = totalTip + finalBillPrice;

        System.out.println("Total tip: " + formatter.format(totalTip));
        System.out.println("Total bill with tip: " + formatter.format(totalTip + finalBillPrice));
        System.out.println("Per person before tip :" + formatter.format(finalBillPrice / amountPeople));
        System.out.println("Tip per person: " + formatter.format(totalTip / amountPeople));
        System.out.println("Total cost per person: " + formatter.format(finalPrice / amountPeople));
        System.out.println("-------------------------------");
        System.out.println("Items Ordered:");

        for ( i = 0; i < foodOrdered.length; i++)
            if (foodOrdered[i] != null) {
                System.out.println(foodOrdered[i]);
            }
    }

    public static String askQuestion(String question) {
        System.out.print(question);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}


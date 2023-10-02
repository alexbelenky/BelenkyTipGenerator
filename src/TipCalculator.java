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

        String whatState = askQuestion("What state are you in? (Works for NY, CA, NJ, VT) : ");

        double priceEntered = 0;
        double finalBillPrice = 0;
        String foodEntered;
        int i = 0;

//created an array to save the food ordered in a simpler fashion, the array is 999 long because I'm not sure how much food the user ordered so 999 is a safe guess
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

        double stateTax = 0;
        if (whatState.equals("NY")){ stateTax = 8.82; }
        if (whatState.equals("CA")){ stateTax = 13.3; }
        if (whatState.equals("NJ")){ stateTax = 10.75; }
        if (whatState.equals("VT")){ stateTax = 8.75; }

        System.out.println("-------------------------------");
        System.out.println("Total bill before the tip and state tax= " + formatter.format(finalBillPrice));
        System.out.println("Total percentage: " + tipPercentage + "%");
        System.out.println("State tax: " + stateTax + "%");

        double totalTip = (finalBillPrice * (tipPercentage / 100.0));
        double stateTaxMeal = (finalBillPrice * (stateTax / 100.0));
        double finalPrice = totalTip + finalBillPrice + stateTaxMeal;


        System.out.println("Total tip: " + formatter.format(totalTip));
        System.out.println("Total state tax: " + formatter.format(stateTaxMeal));
        System.out.println("Total bill with tip: " + formatter.format(totalTip + finalBillPrice));
        System.out.println("Total bill with tip and tax: " + formatter.format(totalTip + finalBillPrice + stateTaxMeal));
        System.out.println("Per person before tip :" + formatter.format(finalBillPrice / amountPeople));
        System.out.println("Tip per person: " + formatter.format(totalTip / amountPeople));
        System.out.println("Tax per person: " + formatter.format(stateTaxMeal / amountPeople));
        System.out.println("Total cost per person: " + formatter.format(finalPrice / amountPeople));
        System.out.println("-------------------------------");
        System.out.println("Items Ordered:");

//this code displays the foods that the user inputted during the while loop
        for ( i = 0; i < foodOrdered.length; i++)
            if (foodOrdered[i] != null) {
                System.out.println(foodOrdered[i]);
            }
    }

    // this method makes asking the user a question so much simpler, basically returning what the user responded to the question instantly
    public static String askQuestion(String question) {
        System.out.print(question);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}


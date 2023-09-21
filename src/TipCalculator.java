import java.util.Scanner;
import java.text.NumberFormat;

public class TipCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        System.out.println("Welcome to the tip calculator!");
        System.out.println("-------------------------------");
        System.out.print("How many people feasted on the food? :");
        int amountPeople = scan.nextInt();
        scan.nextLine();

        System.out.print("What is the tip percentage? (0-100) :");
        int tipPercentage = scan.nextInt();
        scan.nextLine();

        double priceEntered = 0;
        double finalBillPrice = 0;

        while (priceEntered > -1) {
            System.out.print("Enter the cost of the food item purchased in dollars and cents (-1 to end) : ");
            priceEntered = scan.nextDouble();

            finalBillPrice += priceEntered;
        }
        finalBillPrice ++;

        System.out.println("-------------------------------");
        System.out.println("Total bill before the tip = " + formatter.format(finalBillPrice));
        System.out.println("Total percantage: " + tipPercentage + "%");

        double totalTip = (finalBillPrice * (tipPercentage / 100.0));

        System.out.println("Total tip: " + formatter.format(totalTip));
        System.out.println("Total bill with tip: " + formatter.format(totalTip + finalBillPrice));



    }
}

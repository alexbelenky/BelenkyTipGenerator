import java.util.Scanner;

public class TipCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the tip calculator!");
        System.out.println("-------------------------------");
        System.out.print("How many people feasted on the food? :");
        int amountPeople = scan.nextInt();
        scan.nextLine();

        System.out.print("What is the tip percentage? (0-100) :");
        int tipPercentage = scan.nextInt();
        scan.nextLine();




    }
}

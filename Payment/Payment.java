package sem2Project.Payment;
import java.util.*;

public class Payment {

    public static void Payment(float price) {
        Scanner sc = new Scanner(System.in);
        String input;
        boolean cardAccepted = false;
        char cardType = ' ';

        do {
            // take input //
            System.out.print("\nEnter Card Number: ");
            input = sc.nextLine();

            // Check for empty input //
            if (input.isEmpty()) {
                System.out.println("Please enter a valid card number.");
                return;
            }

            String originalInput = input;
            int firstSum = 0, secondSum = 0, sum = 0;
            int n = 1;


            for (int i = input.length() - 1; i >= 0; i--) {
                char c = input.charAt(i);
                int remainder = c - '0';

                if (n % 2 == 0) {
                    int doubled = remainder * 2;
                    if (doubled < 10) {
                        firstSum += doubled;
                    } else {
                        firstSum += (doubled % 10) + (doubled / 10);
                    }
                } else {
                    secondSum += remainder;
                }
                n++;
            }

            sum = firstSum + secondSum;


            if (sum % 10 != 0) {
                System.out.println("INVALID Card We only accept American Express, Mastercard or VISA!");
                cardAccepted = false;
                return;
            }

            // lenth of input //
            int length = input.length();

            int startingDigits = Integer.parseInt(input.substring(0, Math.min(2, length)));

            // finding card types
            if ((startingDigits == 34 || startingDigits == 37) && length == 15) {
                System.out.println("AMEX Card Accepted");
                cardAccepted = true;
                cardType = 'A';
            } else if ((startingDigits >= 51 && startingDigits <= 55) && length == 16) {
                System.out.println("MASTERCARD Card Accepted");
                cardAccepted = true;
                cardType = 'M';
            } else if ((startingDigits / 10 == 4) && (length == 13 || length == 16)) {
                System.out.println("VISA Card Accepted");
                cardAccepted = true;
                cardType = 'V';
            } else {
                System.out.println("INVALID Card\nWe only accept American Express, Mastercard or VISA!");
                cardAccepted = false;
            }
        } while (!cardAccepted);
        int percent = 0;
        if (cardType == 'A')                        // American Express //
        {
            percent = 15;
            float discount = (float)percent/100;        // 15% discount //
            price *= discount;
        } else if (cardType == 'M') {               // MasterCard //
            percent = 30;
            float discount = (float)percent/100;         // 30% discount //
            price *= discount;
        } else {                                    // VISA //
            percent = 25;
            float discount = (float)percent/100;         // 25% discount //
            price *= discount;
        }
        System.out.printf("Payment after %d%% discount: %68s %.2f",percent, "Rs", price);
        System.out.println("\n========================================================================================================");
        System.out.println("Enter P to process the payment");
        char choice = sc.next().charAt(0);
        if (choice == 'P' || choice == 'p') {
            System.out.println("Payment Successful\nThanks for having us");
        } else {
            System.out.println("Payment Unsuccessful");
            System.exit(0);
        }
        sc.close();
    }
}
package sem2Project;

import sem2Project.Payment.Payment;
import sem2Project.GetOrder.GetOrder;
import sem2Project.Menu.Menu;
import sem2Project.TableAssignment.TableAssignment;
import sem2Project.UserDetails.*;
import java.util.*;

import sem2Project.CalculatePrice.CalculatePrice;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to our Resturant.....\nSelect an option\n1. Dine In\n2. Take away\n0. Exit");
        int choice1;
        int totalMenuItems;
        int[] order = null;
        float price;
        while (true) {
            System.out.print("Enter your choice: ");
            choice1 = sc.nextInt();
            // check input //
            if (choice1 == 0 || choice1 == 1 || choice1 == 2) {
                break; // exitinggg //
            } else {
                System.out.println("Wrong Input. Enter a valid number \n1. Dine In\n2. Take away\n0. Exit\n");
            }
        }

        // Dine In //
        if (choice1 == 1) {
            int customerNumber = 1 + random.nextInt(49);
            System.out.print("Enter Number of Guest for table assignment: ");
            int numberOfGuests = sc.nextInt();

            if (TableAssignment.getTable(numberOfGuests, customerNumber) == 1) {
                System.exit(1);
            }

            System.out.println("\nSelect options\n1.Show Menu\n0.Exit");
            while (true) {
                System.out.print("Enter your choice: ");
                choice1 = sc.nextInt();
                // check input //
                if (choice1 == 1 || choice1 == 0) {
                    break; // exitinggg //
                } else {
                    System.out.println("Wrong Input. Enter a valid number \n1.Show Menu\n0.Exit\n");
                }
            }
            if (choice1 == 1) {
                totalMenuItems = Menu.displayMenu();        // Display Menu //
                order = GetOrder.GetOrder(totalMenuItems);  // Get order from user //
                price = CalculatePrice.CalculatePrice(order);   // generate the invoice //
                System.out.println("\nDo you want to pay by \n1. Cash\n2. Card\nNote: We have discounts on Cards\n");
                while (true) {
                    System.out.print("Enter your choice: ");
                    choice1 = sc.nextInt();
                    // check input //
                    if (choice1 == 1 || choice1 == 2 ) {
                        break; // exitinggg //
                    } else if (choice1 == 0) {
                        System.exit(1);
                    } else {
                        System.out.println("Wrong Input. Enter a valid number \n1. Dine In\n2. Take away\n0. Exit\n");
                    }
                }
                if (choice1 == 1) {     // payment by cash //
                    System.out.println("Thank You for visiting us!");
                    System.exit(0);
                } else {        // payment by card //
                    Payment.Payment(price);  // card validation and discounts //
                }

            } else if (choice1 == 0) {
                System.exit(0);
            } else {
                System.out.println("Wrong Input...");
            }
            // Take Away //
        } else if (choice1 == 2) {
            System.out.println("\nSelect options\n1.Show Menu\n0.Exit");
            while (true) {
                System.out.print("Enter your choice: ");
                choice1 = sc.nextInt();
                // check input //
                if (choice1 == 1 || choice1 == 0) {
                    break; // exitinggg //
                } else {
                    System.out.println("Wrong Input. Enter a valid number \n1.Show Menu\n0.Exit\n");
                }
            }
            if (choice1 == 1) {
                totalMenuItems = Menu.displayMenu();        // Display Menu //
                order = GetOrder.GetOrder(totalMenuItems);  // Get order from user //
                UserDetails.User user = UserDetails.getUserDetails();       // get user details //
                price = CalculatePrice.CalculatePrice(order, user);   // generate the invoice //
                System.out.println("\nDo you want to pay by \n1. Cash\n2. Card\nNote: We have discounts on Cards");
                choice1 = sc.nextInt();
                if (choice1 == 1) {     // payment by cash //
                    System.out.println("Thank You for visiting us!");
                    System.exit(0);
                } else {        // payment by card //
                    Payment.Payment(price);  // card validation and discounts //
                }
            } else if (choice1 == 0) {
                System.exit(0);
            } else {
                System.out.println("Wrong Input...");
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
        sc.close();
    }
}

package sem2Project.GetOrder;
import java.util.*;

public class GetOrder {

    public static int[] GetOrder(int totalMenuItems) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items you want to order: \nEnter 0 to terminate..\n");
        int temp[] = new int[100];
        int n = 0;
        int number;
        while (true) {
            number = sc.nextInt();
            if (number == 0) {
                break;
            }
            if (n < 98 && number <= totalMenuItems) {
                temp[n] = number;
                n++;
            }
        }

        int order[] = new int[n];

        // copying array //
        for (int i = 0; i < n; i++) {
            order[i] = temp[i];
        }
        return order;
    }
}

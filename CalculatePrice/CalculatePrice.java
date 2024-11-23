package sem2Project.CalculatePrice;
import sem2Project.UserDetails.*;
import sem2Project.Menu.Menu;

public class CalculatePrice {
    public static float CalculatePrice(int[] order) {
        float price = 0;
        int waitingTime = 0;
        sem2Project.Menu.Roll[] rolls = Menu.getRolls();
        sem2Project.Menu.FastFood[] fastFood = Menu.getFastFood();
        sem2Project.Menu.BBQ[] bbq = Menu.getBbq();
        sem2Project.Menu.Dessert[] dessert = Menu.getDessert();
        sem2Project.Menu.Traditional[] traditional = Menu.getTraditional();
        sem2Project.Menu.Beverage[] beverage = Menu.getBeverage();

        int rollCount = rolls.length;
        int fastFoodCount = fastFood.length;
        int bbqCount = bbq.length;
        int dessertCount = dessert.length;
        int traditionalCount = traditional.length;
        int beverageCount = beverage.length;


        int temp = 0;
        int index = 1;
        // setting indexes of Rolls & Fast Food //
        temp = Math.max(rolls.length, fastFood.length);
        for (int i = 0; i < temp; i++) {
            // Rolls //
            if (i < rolls.length) {
                rolls[i].setIndex(index++);
            }

            // Fast Food //
            if (i < fastFood.length) {
                fastFood[i].setIndex(index++);
            }
        }

        // setting indexes of BBQ & Desserts //
        temp = Math.max(bbq.length, dessert.length);
        for (int i = 0; i < temp; i++) {
            // Rolls //
            if (i < bbq.length) {
                bbq[i].setIndex(index++);
            }

            // Fast Food //
            if (i < dessert.length) {
                dessert[i].setIndex(index++);
            }
        }

        // setting indexes of Traditional Dishes & Beverages //
        temp = Math.max(traditional.length, beverage.length);
        for (int i = 0; i < temp; i++) {
            // Rolls //
            if (i < traditional.length) {
                traditional[i].setIndex(index++);
            }

            // Fast Food //
            if (i < beverage.length) {
                beverage[i].setIndex(index++);
            }
        }

        int rollMaxIndex = rolls[rollCount - 1].getIndex();
        int fastFoodMaxIndex = fastFood[fastFoodCount - 1].getIndex();
        int bbqMaxIndex = bbq[bbqCount - 1].getIndex();
        int dessertMaxIndex = dessert[dessertCount - 1].getIndex();
        int traditionalMaxIndex = traditional[traditionalCount - 1].getIndex();
        int beverageMaxIndex = beverage[beverageCount - 1].getIndex();

        int orderCount = order.length;
        // calculating price & waitingTime //
        for (int i = 0; i < order.length; i++) {
            boolean itemFound = false;

            // Check for Rolls (odd indexes)
            if (order[i] >= 1 && order[i] <= rollMaxIndex && order[i] % 2 != 0) {
                for (int j = 0; j < rollCount; j++) {
                    if (order[i] == rolls[j].getIndex()) {
                        System.out.printf("%2d. %-30s %60s %.2f\n", i + 1, rolls[j].getName(), "Rs", rolls[j].getPrice());
                        price += rolls[j].getPrice();
                        waitingTime += rolls[j].getTime();
                        itemFound = true;
                        break;
                    }
                }
            }

            // Check for Fast Food (even indexes)
            if (!itemFound && order[i] > 1 && order[i] <= fastFoodMaxIndex && order[i] % 2 == 0) {
                for (int j = 0; j < fastFoodCount; j++) {
                    if (order[i] == fastFood[j].getIndex()) {
                        System.out.printf("%2d. %-30s %60s %.2f\n", i + 1, fastFood[j].getName(), "Rs", fastFood[j].getPrice());
                        price += fastFood[j].getPrice();
                        waitingTime += fastFood[j].getTime();
                        itemFound = true;
                        break;
                    }
                }
            }

            // Check for BBQ (odd indexes)
            if (!itemFound && order[i] > fastFoodMaxIndex && order[i] <= bbqMaxIndex && order[i] % 2 != 0) {
                for (int j = 0; j < bbqCount; j++) {
                    if (order[i] == bbq[j].getIndex()) {
                        System.out.printf("%2d. %-30s %60s %.2f\n", i + 1, bbq[j].getName(), "Rs", bbq[j].getPrice());
                        price += bbq[j].getPrice();
                        waitingTime += bbq[j].getTime();
                        itemFound = true;
                        break;
                    }
                }
            }

            // Check for Desserts (even indexes)
            if (!itemFound && order[i] > fastFoodMaxIndex && order[i] <= dessertMaxIndex && order[i] % 2 == 0) {
                for (int j = 0; j < dessertCount; j++) {
                    if (order[i] == dessert[j].getIndex()) {
                        System.out.printf("%2d. %-30s %60s %.2f\n", i + 1, dessert[j].getName(), "Rs", dessert[j].getPrice());
                        price += dessert[j].getPrice();
                        waitingTime += dessert[j].getTime();
                        itemFound = true;
                        break;
                    }
                }
            }

            // Check for Traditional (odd indexes)
            if (!itemFound && order[i] > dessertMaxIndex && order[i] <= traditionalMaxIndex && order[i] % 2 != 0) {
                for (int j = 0; j < traditionalCount; j++) {
                    if (order[i] == traditional[j].getIndex()) {
                        System.out.printf("%2d. %-30s %60s %.2f\n", i + 1, traditional[j].getName(), "Rs", traditional[j].getPrice());
                        price += traditional[j].getPrice();
                        waitingTime += traditional[j].getTime();
                        itemFound = true;
                        break;
                    }
                }
            }

            // Check for Beverages (even indexes)
            if (!itemFound && order[i] > dessertMaxIndex && order[i] <= beverageMaxIndex && order[i] % 2 == 0) {
                for (int j = 0; j < beverageCount; j++) {
                    if (order[i] == beverage[j].getIndex()) {
                        System.out.printf("%2d. %-30s %60s %.2f\n", i + 1, beverage[j].getName(), "Rs", beverage[j].getPrice());
                        price += beverage[j].getPrice();
                        waitingTime += beverage[j].getTime();
                        break;
                    }
                }
            }
        }
        System.out.println("\n========================================================================================================");
        System.out.printf("\n Total: %87s %.2f", "Rs", price);
        System.out.printf("\n Waiting Time:  %79d minutes \n", waitingTime);
        System.out.println("\n========================================================================================================");
        return price;
    }

    public static float CalculatePrice(int[] order, UserDetails.User user) {
        float price = 0;
        int waitingTime = 0;
        sem2Project.Menu.Roll[] rolls = Menu.getRolls();
        sem2Project.Menu.FastFood[] fastFood = Menu.getFastFood();
        sem2Project.Menu.BBQ[] bbq = Menu.getBbq();
        sem2Project.Menu.Dessert[] dessert = Menu.getDessert();
        sem2Project.Menu.Traditional[] traditional = Menu.getTraditional();
        sem2Project.Menu.Beverage[] beverage = Menu.getBeverage();

        int rollCount = rolls.length;
        int fastFoodCount = fastFood.length;
        int bbqCount = bbq.length;
        int dessertCount = dessert.length;
        int traditionalCount = traditional.length;
        int beverageCount = beverage.length;


        int temp = 0;
        int index = 1;
        // setting indexes of Rolls & Fast Food //
        temp = Math.max(rolls.length, fastFood.length);
        for (int i = 0; i < temp; i++) {
            // Rolls //
            if (i < rolls.length) {
                rolls[i].setIndex(index++);
            }

            // Fast Food //
            if (i < fastFood.length) {
                fastFood[i].setIndex(index++);
            }
        }

        // setting indexes of BBQ & Desserts //
        temp = Math.max(bbq.length, dessert.length);
        for (int i = 0; i < temp; i++) {
            // Rolls //
            if (i < bbq.length) {
                bbq[i].setIndex(index++);
            }

            // Fast Food //
            if (i < dessert.length) {
                dessert[i].setIndex(index++);
            }
        }

        // setting indexes of Traditional Dishes & Beverages //
        temp = Math.max(traditional.length, beverage.length);
        for (int i = 0; i < temp; i++) {
            // Rolls //
            if (i < traditional.length) {
                traditional[i].setIndex(index++);
            }

            // Fast Food //
            if (i < beverage.length) {
                beverage[i].setIndex(index++);
            }
        }

        int rollMaxIndex = rolls[rollCount - 1].getIndex();
        int fastFoodMaxIndex = fastFood[fastFoodCount - 1].getIndex();
        int bbqMaxIndex = bbq[bbqCount - 1].getIndex();
        int dessertMaxIndex = dessert[dessertCount - 1].getIndex();
        int traditionalMaxIndex = traditional[traditionalCount - 1].getIndex();
        int beverageMaxIndex = beverage[beverageCount - 1].getIndex();

        String name = user.getName();
        System.out.printf("\nName: %s\n", name);
        String address = user.getAddress();
        System.out.printf("Address: %s\n", address);
        String phone = user.getPhone();
        System.out.printf("Phone Number: %s\n", phone);
        System.out.println("========================================================================================================");

        int orderCount = order.length;
        // calculating price & waitingTime //
        for (int i = 0; i < order.length; i++) {
            boolean itemFound = false;

            // Check for Rolls (odd indexes)
            if (order[i] >= 1 && order[i] <= rollMaxIndex && order[i] % 2 != 0) {
                for (int j = 0; j < rollCount; j++) {
                    if (order[i] == rolls[j].getIndex()) {
                        System.out.printf("%2d. %-30s %60s %.2f\n", i + 1, rolls[j].getName(), "Rs", rolls[j].getPrice());
                        price += rolls[j].getPrice();
                        waitingTime += rolls[j].getTime();
                        itemFound = true;
                        break;
                    }
                }
            }

            // Check for Fast Food (even indexes)
            if (!itemFound && order[i] > 1 && order[i] <= fastFoodMaxIndex && order[i] % 2 == 0) {
                for (int j = 0; j < fastFoodCount; j++) {
                    if (order[i] == fastFood[j].getIndex()) {
                        System.out.printf("%2d. %-30s %60s %.2f\n", i + 1, fastFood[j].getName(), "Rs", fastFood[j].getPrice());
                        price += fastFood[j].getPrice();
                        waitingTime += fastFood[j].getTime();
                        itemFound = true;
                        break;
                    }
                }
            }

            // Check for BBQ (odd indexes)
            if (!itemFound && order[i] > fastFoodMaxIndex && order[i] <= bbqMaxIndex && order[i] % 2 != 0) {
                for (int j = 0; j < bbqCount; j++) {
                    if (order[i] == bbq[j].getIndex()) {
                        System.out.printf("%2d. %-30s %60s %.2f\n", i + 1, bbq[j].getName(), "Rs", bbq[j].getPrice());
                        price += bbq[j].getPrice();
                        waitingTime += bbq[j].getTime();
                        itemFound = true;
                        break;
                    }
                }
            }

            // Check for Desserts (even indexes)
            if (!itemFound && order[i] > fastFoodMaxIndex && order[i] <= dessertMaxIndex && order[i] % 2 == 0) {
                for (int j = 0; j < dessertCount; j++) {
                    if (order[i] == dessert[j].getIndex()) {
                        System.out.printf("%2d. %-30s %60s %.2f\n", i + 1, dessert[j].getName(), "Rs", dessert[j].getPrice());
                        price += dessert[j].getPrice();
                        waitingTime += dessert[j].getTime();
                        itemFound = true;
                        break;
                    }
                }
            }

            // Check for Traditional (odd indexes)
            if (!itemFound && order[i] > dessertMaxIndex && order[i] <= traditionalMaxIndex && order[i] % 2 != 0) {
                for (int j = 0; j < traditionalCount; j++) {
                    if (order[i] == traditional[j].getIndex()) {
                        System.out.printf("%2d. %-30s %60s %.2f\n", i + 1, traditional[j].getName(), "Rs", traditional[j].getPrice());
                        price += traditional[j].getPrice();
                        waitingTime += traditional[j].getTime();
                        itemFound = true;
                        break;
                    }
                }
            }

            // Check for Beverages (even indexes)
            if (!itemFound && order[i] > dessertMaxIndex && order[i] <= beverageMaxIndex && order[i] % 2 == 0) {
                for (int j = 0; j < beverageCount; j++) {
                    if (order[i] == beverage[j].getIndex()) {
                        System.out.printf("%2d. %-30s %60s %.2f\n", i + 1, beverage[j].getName(), "Rs", beverage[j].getPrice());
                        price += beverage[j].getPrice();
                        waitingTime += beverage[j].getTime();
                        break;
                    }
                }
            }
        }
        System.out.println("\n========================================================================================================");
        System.out.printf("\n Total: %87s %.2f", "Rs", price);
        System.out.printf("\n Waiting Time:  %79d minutes \n", waitingTime);
        System.out.println("\n========================================================================================================");
        return price;
    }
}

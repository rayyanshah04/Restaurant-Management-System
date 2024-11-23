package sem2Project.Menu;

public class Menu {
    
    private static Roll[] rolls = {
        new Roll("Chicken Roll", 400.00),
        new Roll("Beef Roll", 450.00),
        new Roll("Shami Kebab Roll", 350.00),
        new Roll("Seekh Kebab Roll", 300.00),
        new Roll("Paneer Roll", 250.00),
        new Roll("Veg Roll", 200)
    };

    private static FastFood fastFood[] = {
        new FastFood("Burger", 600.00),
        new FastFood("Pizza", 700.00),
        new FastFood("French Fries", 350.00),
        new FastFood("Chicken Nuggets", 450.00),
        new FastFood("Hot Wings", 500.00),
        new FastFood("Fish and Chips", 600.00)
    };

    private static BBQ bbq[] = {
        new BBQ("Chicken Tikka", 800.00),
        new BBQ("Reshmi Kebab", 1000.00),
        new BBQ("Mutton Chop", 1200.00),
        new BBQ("Chicken Seekh Kebab", 900.00),
        new BBQ("Grilled Fish", 950.00),
        new BBQ("BBQ Wings", 850.00)
    };

    private static Dessert dessert[] = {
        new Dessert("Gulab Jamun", 250.00),
        new Dessert("Kheer", 300.00),
        new Dessert("Carrot Halwa", 200.00),
        new Dessert("Baklava", 350.00),
        new Dessert("Rasgulla", 250.00),
        new Dessert("Chocolate Cake", 300.00)
    };

    private static Traditional traditional[] = {
        new Traditional("Biryani", 1200.00),
        new Traditional("Karahi Chicken", 1500.00),
        new Traditional("Shawarma", 1300.00),
        new Traditional("Haleem", 1400.00),
        new Traditional("Kabsa", 1300.00),
        new Traditional("Palak Gosht", 1400.00)
    };

    private static Beverage beverage[] = {
        new Beverage("Pepsi", 150.00),
        new Beverage("Coca Cola", 150.00),
        new Beverage("Pakola", 120.00),
        new Beverage("Fanta", 120.00),
        new Beverage("Mineral Water", 100.00),
        new Beverage("Sting", 150.00)
    };
    
    public static Roll[] getRolls() {
        return rolls;
    }

    public static FastFood[] getFastFood() {
        return fastFood;
    }

    public static BBQ[] getBbq() {
        return bbq;
    }

    public static Dessert[] getDessert() {
        return dessert;
    }

    public static Traditional[] getTraditional() {
        return traditional;
    }

    public static Beverage[] getBeverage() {
        return beverage;
    }

    public static int displayMenu() {

        int totalMenuItems = rolls.length + fastFood.length + bbq.length + dessert.length + traditional.length + beverage.length;

        // printing menu //
        int index = 1;
        // Displaying Rolls & Fast Food //
        System.out.println("\n=================================================================================================\n");
        System.out.printf("%-57s", "Rolls:");
        System.out.println("Fast Food:");
        int temp = Math.max(rolls.length, fastFood.length);
        for (int i = 0; i < temp; i++) {
            // Rolls //
            if (i >= rolls.length) {
                System.out.printf("%58s", " ");
            } else {
                System.out.printf("%2d. %-25s Rs %-25.2f", index++, rolls[i].name, rolls[i].price);
            }

            // Fast Food //
            if (i >= fastFood.length) {
                System.out.printf("%50s", " ");
            } else {
                System.out.printf("%2d. %-25s Rs %.2f", index++, fastFood[i].name, fastFood[i].price);
            }
            System.out.println("");
        }
        System.out.println("");

        // Displaying BBQ & Desserts //
        System.out.printf("%-57s", "BBQ:");
        System.out.println("Desserts:");
        temp = Math.max(bbq.length, dessert.length);
        for (int i = 0; i < temp; i++) {
            // BBQ //
            if (i >= bbq.length) {
                System.out.printf("%58s", " ");
            } else {
                System.out.printf("%2d. %-25s Rs %-25.2f", index++, bbq[i].name, bbq[i].price);
            }

            // Desserts //
            if (i >= dessert.length) {
                System.out.printf("%50s", " ");
            } else {
                System.out.printf("%2d. %-25s Rs %.2f", index++, dessert[i].name, dessert[i].price);
            }
            System.out.println("");
        }
        System.out.println("");

        // Displaying Traditional Dishes & Beverages //
        System.out.printf("%-57s", "Traditional:");
        System.out.println("Beverages:");
        temp = Math.max(traditional.length, beverage.length);
        for (int i = 0; i < temp; i++) {
            // Traditional //
            if (i >= traditional.length) {
                System.out.printf("%58s", " ");
            } else {
                System.out.printf("%2d. %-25s Rs %-25.2f", index++, traditional[i].name, traditional[i].price);
            }

            // Beverages //
            if (i >= beverage.length) {
                System.out.printf("%50s", " ");
            } else {
                System.out.printf("%2d. %-25s Rs %.2f", index++, beverage[i].name, beverage[i].price);
            }
            System.out.println("");
        }
        System.out.println("");
        return totalMenuItems;
    }

    
}

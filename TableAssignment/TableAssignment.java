package sem2Project.TableAssignment;

class Table {

    int numberOfGuests;
    String customerName;

    public Table(String customerName, int numberOfGuests) {
        this.customerName = customerName;
        this.numberOfGuests = numberOfGuests;
    }
}

class SmallTable extends Table {

    public SmallTable(String customerName) {
        super(customerName, 2);
        System.out.println("We have reserved a Small Table for you!");
    }
}


class MediumTable extends Table {

    public MediumTable(String customerName) {
        super(customerName, 4);
        System.out.println("We have reserved a Medium Table for you!");
    }

}

class LargeTable extends Table {

    public LargeTable(String customerName) {
        super(customerName, 6);
        System.out.println("We have reserved a Large Table for you!");
    }
}

class XLargeTable extends Table {

    public XLargeTable(String customerName) {
        super(customerName, 10);
        System.out.println("We have reserved an Extra Large Table for you!");
    }
}

public class TableAssignment {

    public static int getTable(int numberOfGuests, int customerNumber) {
        Table assignedTable;
        String customerName = String.format("Customer%d", customerNumber);
        if (numberOfGuests <= 2 && numberOfGuests > 0) {
            assignedTable = new SmallTable(customerName);
        } else if (numberOfGuests <= 4 && numberOfGuests > 2) {
            assignedTable = new MediumTable(customerName);
        } else if (numberOfGuests <= 6 && numberOfGuests > 4) {
            assignedTable = new LargeTable(customerName);
        } else if (numberOfGuests <= 10 && numberOfGuests > 6) {
            assignedTable = new XLargeTable(customerName);
        } else if (numberOfGuests > 10) {
            System.out.println("Sorry! No space for more than 10 guests");
            return 1;
        } else {
            System.out.println("Wrong Input!");
            return 1;
        }
        return 0;
    }
}

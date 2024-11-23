package sem2Project.Menu;

public class Item {

    protected String name;
    protected double price;
    protected String category;
    protected int time;
    protected int index;

    public Item(String name, double price, String category, int time) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.time = time;
        this.index = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getTime() {
        return time;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

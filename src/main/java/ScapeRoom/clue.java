package ScapeRoom;

public class clue {

    private final int id;
    private int addId = 0;
    private String name;
    private double price;
    private double time;
    private String theme;

    public clue(String name, double price, double time, String theme) {
        this.id =+ addId;
        this.name = name;
        this.price = price;
        this.time = time;
        this.theme = theme;
    }

    public int getId() {
        return this.id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getPrice() {
        double iva = (price * 10)/100;
        double finalPrice = price + iva;
        return finalPrice;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "Clue: \n" +
                "\nID: " + id +
                "\nName: " + name +
                "\nPrice: " + getPrice() +
                "\nTime: " + time +
                "\nTheme: " + theme;
    }
}

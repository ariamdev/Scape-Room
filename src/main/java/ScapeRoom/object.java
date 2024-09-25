package ScapeRoom;

public class object {

    private final int id;
    private int addId = 0;
    private String name;
    private String description;
    private String material;
    private double price;

    public object(String name, String description, String material, double price) {
        this.id =+ addId;
        this.name = name;
        this.description = description;
        this.material = material;
        this.price = price;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPrice() {
        double iva = (price * 21)/100;
        double finalPrice = price + iva;
        return finalPrice;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Object :\n" +
                "\nID: " + id +
                "\nName: " + name +
                "\nDescription: " + description +
                "\nMaterial: " + material +
                "\nPrice: " + getPrice() +
                '}';
    }
}

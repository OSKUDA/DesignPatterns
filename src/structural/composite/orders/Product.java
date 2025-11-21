package structural.composite.orders;

public abstract class Product implements Order{

    private String id;

    private String model;

    private double price;

    private double weight;

    public Product(String id, String model, double price, double weight) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getTotalWeight() {
        return this.weight;
    }

    @Override
    public double getTotalPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", price='" + price + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}

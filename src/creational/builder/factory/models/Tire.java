package creational.builder.factory.models;

public class Tire {

    private String brand;

    private String model;

    private String size;

    private double width;

    private int diameter;

    public Tire(String brand, String model, String size, double width, int diameter) {
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.width = width;
        this.diameter = diameter;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "Tire{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", size='" + size + '\'' +
                ", width=" + width +
                ", diameter=" + diameter +
                '}';
    }
}

package creational.builder.factory.models;

public class GPS {

    private String brand;

    private String model;

    private double screenSize;

    private int storageCapacity;

    private boolean hasBluetooth;

    public GPS(String brand, String model, double screenSize, int storageCapacity, boolean hasBluetooth) {
        this.brand = brand;
        this.model = model;
        this.screenSize = screenSize;
        this.storageCapacity = storageCapacity;
        this.hasBluetooth = hasBluetooth;
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

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public boolean isHasBluetooth() {
        return hasBluetooth;
    }

    public void setHasBluetooth(boolean hasBluetooth) {
        this.hasBluetooth = hasBluetooth;
    }

    @Override
    public String toString() {
        return "GPS{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", screenSize=" + screenSize +
                ", storageCapacity=" + storageCapacity +
                ", hasBluetooth=" + hasBluetooth +
                '}';
    }
}

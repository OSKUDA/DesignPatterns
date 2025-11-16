package creational.builder.factory.models;

public class Engine {

    private String brand;

    private String model;

    private String type;

    private int horsePower;

    private double capacity;

    private int cylinders;

    private boolean started;

    private final double fuelConsumptionPerKm;

    public Engine(String brand, String model, String type, int horsePower, double capacity, int cylinders, boolean started, double fuelConsumptionPerKm) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.horsePower = horsePower;
        this.capacity = capacity;
        this.cylinders = cylinders;
        this.started = started;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    public boolean isStarted() {
        return started;
    }

    public void on() {
        this.started = true;
    }

    public void off() {
        this.started = false;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public double getFuelConsumptionPerKm() {
        return fuelConsumptionPerKm;
    }

    public long getMaxDistance(double fuelLevel) {
        if (fuelLevel <= 0) return 0;
        return (long) (fuelLevel / this.fuelConsumptionPerKm);
    }

    @Override
    public String toString() {
        return "Engine{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", horsePower=" + horsePower +
                ", capacity=" + capacity +
                ", cylinders=" + cylinders +
                ", started=" + started +
                ", fuelConsumptionPerKm=" + fuelConsumptionPerKm +
                '}';
    }

}

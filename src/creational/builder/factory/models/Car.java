package creational.builder.factory.models;

import creational.builder.factory.enums.CarType;

import java.util.List;

public class Car {

    private String brand;

    private String model;

    private String color;

    private String fuelType;

    private String transmission;

    private int doors;

    private int seats;

    private double price;

    private Engine engine;

    private GPS gps;

    private List<Tire> tires;

    private double fuelLevel;

    private CarType carType;

    private long odometer;

    public Car(String brand, String model, String color, String fuelType, String transmission, int doors, int seats, double price, Engine engine, GPS gps, List<Tire> tires, double fuelLevel, CarType carType, long odometer) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.doors = doors;
        this.seats = seats;
        this.price = price;
        this.engine = engine;
        this.gps = gps;
        this.tires = tires;
        this.fuelLevel = fuelLevel;
        this.carType = carType;
        this.odometer = odometer;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void addFuel(double fuelLevel) {
        this.fuelLevel += fuelLevel;
    }

    public void consumeFuel(double consumeFuel) {
        if (this.getFuelLevel() < consumeFuel) {
            throw new IllegalStateException("Cannot consume more fuel than fuel level");
        }
        this.fuelLevel -= consumeFuel;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public GPS getGps() {
        return gps;
    }

    public void setGps(GPS gps) {
        this.gps = gps;
    }

    public List<Tire> getTires() {
        return tires;
    }

    public void setTires(List<Tire> tires) {
        this.tires = tires;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public long getOdometer() {
        return this.odometer;
    }

    public void drive(long mileage) {
        if (!this.engine.isStarted()) {
            System.out.println("Engine is off. Cannot drive.");
            return;
        }

        long possibleDistance = this.engine.getMaxDistance(this.fuelLevel);

        long distanceDriven = Math.min(mileage, possibleDistance);

        this.odometer += mileage;

        double fuelUsed = distanceDriven * this.engine.getFuelConsumptionPerKm();
        consumeFuel(fuelUsed);
        System.out.println("Drove " + distanceDriven + " km and used " + fuelUsed + " l fuel");

        if ((long) this.fuelLevel <= 0) {
            this.engine.off();
            System.out.println("Engine turned off as fuel is empty");
        }
    }

    public void startEngine() {
        if (this.fuelLevel > 0) {
            this.engine.on();
            System.out.println("Engine turned on");
        } else {
            System.out.println("No fuel! Engine didn't turn on");
        }
    }

    public void stopEngine() {
        if (!this.engine.isStarted()) {
            System.out.println("Engine is already turned off");
            return;
        }
        this.engine.off();
        System.out.println("Engine turned off");
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", transmission='" + transmission + '\'' +
                ", doors=" + doors +
                ", seats=" + seats +
                ", price=" + price +
                ", engine=" + engine +
                ", gps=" + gps +
                ", tires=" + tires +
                ", fuelLevel=" + fuelLevel +
                ", carType=" + carType +
                '}';
    }
}

package creational.builder.factory.builder;

import creational.builder.factory.enums.CarType;
import creational.builder.factory.models.Car;
import creational.builder.factory.models.Engine;
import creational.builder.factory.models.GPS;
import creational.builder.factory.models.Tire;

import java.util.List;

public class CarBuilder implements BaseBuilder {

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

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setDoors(int doors) {
        this.doors = doors;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setGps(GPS gps) {
        this.gps = gps;
    }

    @Override
    public void setTires(List<Tire> tires) {
        this.tires = tires;
    }

    @Override
    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    @Override
    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Car getResult(){
        return new Car(brand, model, color, fuelType, transmission, doors, seats, price, engine, gps, tires, fuelLevel, carType);
    }

}

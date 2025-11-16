package creational.builder.factory.builder;

import creational.builder.factory.enums.CarType;
import creational.builder.factory.models.Engine;
import creational.builder.factory.models.GPS;
import creational.builder.factory.models.Tire;

import java.util.List;

public interface BaseBuilder {

    void setBrand(String brand);

    void setModel(String model);

    void setColor(String color);

    void setFuelType(String fuelType);

    void setTransmission(String transmission);

    void setDoors(int doors);

    void setSeats(int seats);

    void setPrice(double price);

    void setEngine(Engine engine);

    void setGps(GPS gps);

    void setTires(List<Tire> tires);

    void setFuelLevel(double fuelLevel);

    void setCarType(CarType carType);

}

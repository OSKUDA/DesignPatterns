package creational.builder.factory.director;

import creational.builder.factory.builder.BaseBuilder;
import creational.builder.factory.enums.CarType;
import creational.builder.factory.models.Engine;
import creational.builder.factory.models.GPS;
import creational.builder.factory.models.Tire;

import java.util.List;
import java.util.UUID;

public class Director {

    public void buildHatchBack(BaseBuilder builder) {
        builder.setBrand("oskar");
        builder.setModel(UUID.randomUUID().toString());
        builder.setColor("yellow");
        builder.setDoors(4);
        builder.setEngine(new Engine(
                "rolls-royce", UUID.randomUUID().toString(), "turbo", 80, 1200, 4, false, 0.05
        ));
        builder.setOdometer(0L);
        builder.setCarType(CarType.HATCHBACK);
        builder.setFuelLevel(5.00);
        builder.setFuelType("petrol");
        builder.setGps(new GPS(
                "garmin", UUID.randomUUID().toString(), 6.5, 64, true
        ));
        builder.setPrice(800000.00);
        builder.setSeats(4);
        builder.setTransmission("5");
        builder.setTires(List.of(
                new Tire("mrf", "2025-11-16", "22", 195, 20),
                new Tire("mrf", "2025-11-16", "22", 195, 20),
                new Tire("mrf", "2025-11-16", "22", 195, 20),
                new Tire("mrf", "2025-11-16", "22", 195, 20)
        ));
    }

    public void buildSUV(BaseBuilder builder) {
        builder.setBrand("oskar");
        builder.setModel(UUID.randomUUID().toString());
        builder.setColor("red");
        builder.setDoors(4);
        builder.setEngine(new Engine(
                "ford", UUID.randomUUID().toString(), "turbo", 120, 2400, 4, false, 0.08
        ));
        builder.setOdometer(0L);
        builder.setCarType(CarType.SUV);
        builder.setFuelLevel(13.00);
        builder.setFuelType("petrol");
        builder.setGps(new GPS(
                "garmin", UUID.randomUUID().toString(), 11.2, 64, true
        ));
        builder.setPrice(1900000.00);
        builder.setSeats(4);
        builder.setTransmission("6");
        builder.setTires(List.of(
                new Tire("mrf", "2025-11-16", "24", 195, 24),
                new Tire("mrf", "2025-11-16", "24", 195, 24),
                new Tire("mrf", "2025-10-01", "24", 195, 24),
                new Tire("mrf", "2025-10-01", "24", 195, 24)
        ));
    }


}

package creational.builder.factory.builder;

import creational.builder.factory.enums.CarType;
import creational.builder.factory.models.Engine;
import creational.builder.factory.models.GPS;
import creational.builder.factory.models.Manual;
import creational.builder.factory.models.Tire;

import java.util.*;

public class ManualBuilder implements BaseBuilder {

    private int pages;

    private final List<String> carSection;

    private String doorSection;

    private final List<String> tireSection;

    private final List<String> engineSection;

    private final List<String> gpsSection;

    private String tripComputerSection;

    public ManualBuilder() {
        this.carSection = new ArrayList<>();
        this.tireSection = new ArrayList<>();
        this.engineSection = new ArrayList<>();
        this.gpsSection = new ArrayList<>();
    }

    @Override
    public void setBrand(String brand) {
        this.carSection.add("BRAND : " + brand + ", ");
    }

    @Override
    public void setModel(String model) {
        this.carSection.add("MODEL : " + model + ", ");
    }

    @Override
    public void setColor(String color) {
        this.carSection.add("COLOR : " + color + ", ");
    }

    @Override
    public void setFuelType(String fuelType) {
        this.carSection.add("FUEL TYPE : " + fuelType + ", ");
    }

    @Override
    public void setTransmission(String transmission) {
        this.engineSection.add("TRANSMISSION : " + transmission + ", ");
    }

    @Override
    public void setDoors(int doors) {
        this.doorSection = "DOOR : " + doors;
    }

    @Override
    public void setSeats(int seats) {
        this.carSection.add("SEATS : " + seats + ", ");
    }

    @Override
    public void setPrice(double price) {
        // do nothing, price is not required in manual
    }

    @Override
    public void setEngine(Engine engine) {
        this.engineSection.add("ENGINE BRAND : " + engine.getBrand() + ", ");
        this.engineSection.add("ENGINE MODEL : " + engine.getModel() + ", ");
        this.engineSection.add("ENGINE TYPE : " + engine.getType() + ", ");
        this.engineSection.add("ENGINE HORSE POWER : " + engine.getHorsePower() + ", ");
        this.engineSection.add("ENGINE CAPACITY : " + engine.getCapacity() + ", ");
        this.engineSection.add("ENGINE CYLINDER : " + engine.getCylinders() + ", ");
        this.engineSection.add("ENGINE MILEAGE PER KM : " + engine.getFuelConsumptionPerKm() + ", ");
    }

    @Override
    public void setGps(GPS gps) {
        this.gpsSection.add("GPS BRAND : " + gps.getBrand() + ", ");
        this.gpsSection.add("GPS MODEL : " + gps.getModel() + ", ");
        this.gpsSection.add("GPS SCREEN SIZE : " + gps.getScreenSize() + ", ");
        this.gpsSection.add("GPS STORAGE CAPACITY : " + gps.getStorageCapacity() + ", ");
        this.gpsSection.add("GPS BLUETOOTH : " + gps.isHasBluetooth() + ", ");
    }

    @Override
    public void setTires(List<Tire> tires) {
        Set<Tire> uniqueTires = new HashSet<>(tires);
        uniqueTires.forEach(
                tire -> {
                    String details = String.format(
                            "TIRE [BRAND=%s, MODEL=%s, SIZE=%s, WIDTH=%.1f, DIAMETER=%d]",
                            tire.getBrand(),
                            tire.getModel(),
                            tire.getSize(),
                            tire.getWidth(),
                            tire.getDiameter()
                    );
                    this.tireSection.add(details);
                }
        );
    }

    @Override
    public void setFuelLevel(double fuelLevel) {
        // do nothing, fuel level is not required in manual
    }

    @Override
    public void setCarType(CarType carType) {
        this.carSection.add("CAR TYPE : " + carType.name() + ", ");
    }

    @Override
    public void setOdometer(long odometer) {
        // do nothing, odometer is not required in manual
    }

    public Manual getResult() {
        return new Manual(pages, carSection, doorSection, tireSection, engineSection, gpsSection, tripComputerSection);
    }

}

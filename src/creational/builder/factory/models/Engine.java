package creational.builder.factory.models;

public class Engine {

    private String brand;

    private String model;

    private String type;

    private int horsePower;

    private double capacity;

    private int cylinders;

    private boolean started;

    private long odometer;

    private final double fuelConsumptionPerKm;

    private final Car car;

    public Engine(String brand, String model, String type, int horsePower, double capacity, int cylinders, boolean started, long odometer, double fuelConsumptionPerKm, Car car) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.horsePower = horsePower;
        this.capacity = capacity;
        this.cylinders = cylinders;
        this.started = started;
        this.odometer = odometer;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        this.car = car;
    }

    public boolean isStarted() {
        return started;
    }

    public long getOdometer() {
        return odometer;
    }

    public void drive(long mileage) {
        if (this.started) {
            long actualMileage = burnFuel(mileage);
            this.odometer += actualMileage;
            System.out.println("Car drove for " + actualMileage + " km");

            // if fuel is empty after drive, shut the engine
            if (this.car.getFuelLevel() <= 0) {
                off();
                System.out.println("Engine turned off as fuel is empty");
            }
        } else {
            System.out.println("Engine is off. Cannot drive.");
        }
    }

    public void on() {
        // check fuel
        if (this.car.getFuelLevel() <= 0) {
            System.out.println("Car is out of fuel. Cannot start");
            return;
        }
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
                ", odometer=" + odometer +
                ", fuelConsumptionPerKm=" + fuelConsumptionPerKm +
                '}';
    }

    private long burnFuel(long mileage) {
        double range = this.fuelConsumptionPerKm * this.car.getFuelLevel();
        long actualMileage = (long) range - mileage;
        if (actualMileage > 0) {
            double fuelConsumption = actualMileage / this.fuelConsumptionPerKm;
            this.car.consumeFuel(fuelConsumption);
            return mileage;
        } else if (actualMileage < 0) {
            double fuelConsumption = range / this.fuelConsumptionPerKm;
            this.car.consumeFuel(fuelConsumption);
            return (long) range;
        } else {
            System.out.println("Fuel is empty");
            return 0;
        }
    }
}

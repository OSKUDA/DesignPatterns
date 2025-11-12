package creational.builder.factory.models;

public class TripComputer {

    private Car car;

    public TripComputer(Car car) {
        this.car = car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void showFuelLevel() {
        System.out.println("Fuel level : " + car.getFuelLevel());
    }
}

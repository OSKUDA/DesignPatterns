package creational.builder.factory.client;

import creational.builder.factory.builder.CarBuilder;
import creational.builder.factory.builder.ManualBuilder;
import creational.builder.factory.director.Director;
import creational.builder.factory.models.Car;
import creational.builder.factory.models.Manual;

public class Client {

    public static void main(String[] args) {
        Director director = new Director();
        clientCarSuv(director);
        clientCarSuvManual(director);
    }

    private static void clientCarSuvManual(Director director) {
        ManualBuilder manualBuilder = new ManualBuilder();

        director.buildSUV(manualBuilder);
        Manual manual = manualBuilder.getResult();

        manual.print();
    }

    public static void clientCarSuv(Director director) {
        CarBuilder carBuilder = new CarBuilder();

        director.buildSUV(carBuilder);
        Car car = carBuilder.getResult();

        car.startEngine();
        car.drive(10);
        System.out.println("Client checks fuel : " + car.getFuelLevel() + " l");

        car.drive(120);
        System.out.println("Client checks fuel : " + car.getFuelLevel() + " l");

        car.stopEngine();

        car.startEngine();
        System.out.println("Client checks odometer : " + car.getOdometer() + " km");

        car.drive(450);
        System.out.println("Client checks fuel : " + car.getFuelLevel() + " l");

        car.addFuel(50);
        System.out.println("Client checks fuel : " + car.getFuelLevel() + " l");

        car.startEngine();
        car.drive(400);

        car.stopEngine();
    }
}

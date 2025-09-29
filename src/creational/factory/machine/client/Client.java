package creational.factory.machine.client;

import creational.factory.machine.Machine;
import creational.factory.machine.factory.TimeMachineCreator;
import creational.factory.machine.factory.WashingMachineCreator;
import creational.factory.machine.model.Customer;

public class Client {

    public static void main(String[] args) {
        Customer oskar = new Customer(1L, "Oskar", "Shrestha", "oskar.shrestha@live.com");
        Machine machine = new WashingMachineCreator(oskar).createMachine();
        System.out.println("My machine's name is : " + machine.getName());
        machine.doWork();

        Machine machine1 = new WashingMachineCreator(oskar).createMachine();
        System.out.println("My machine's name is : " + machine1.getName());
        machine1.doWork();

        Machine timeMachine = TimeMachineCreator.getInstance(oskar).createMachine();
        System.out.println("My machine's name is : " + timeMachine.getName());
        timeMachine.doWork();

        Customer pinky = new Customer(2L, "Pinky", "Lavender", "pinky.lavender@live.com");
        Machine timeMachinePinky = TimeMachineCreator.getInstance(pinky).createMachine();
        System.out.println("My machine's name is : " + timeMachinePinky.getName());
        timeMachinePinky.doWork();
    }
}

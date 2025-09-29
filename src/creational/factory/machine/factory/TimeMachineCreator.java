package creational.factory.machine.factory;

import creational.factory.machine.Machine;
import creational.factory.machine.TimeMachine;
import creational.factory.machine.model.Customer;

import java.util.UUID;

public class TimeMachineCreator extends MachineCreator {

    private final Customer customer;

    private TimeMachine timeMachine;

    private static TimeMachineCreator timeMachineCreator;

    private TimeMachineCreator(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("ERROR : Customer is null");
        }
        this.customer = customer;
    }

    public static TimeMachineCreator getInstance(Customer customer) {
        if (timeMachineCreator == null) {
            synchronized (TimeMachineCreator.class) {
                timeMachineCreator = new TimeMachineCreator(customer);
            }
        }
        return timeMachineCreator;
    }

    @Override
    public Machine createMachine() {
        if (timeMachine == null) {
            synchronized (Machine.class) {
              timeMachine = new TimeMachine(this.customer.firstName() + "_" + UUID.randomUUID());
            }
        }
        return timeMachine;
    }
}

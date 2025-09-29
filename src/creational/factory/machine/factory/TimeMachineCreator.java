package creational.factory.machine.factory;

import creational.factory.machine.Machine;
import creational.factory.machine.TimeMachine;
import creational.factory.machine.model.Customer;

import java.util.UUID;

public class TimeMachineCreator extends MachineCreator {

    private TimeMachine timeMachine;

    private static TimeMachineCreator timeMachineCreator;

    private TimeMachineCreator() {
    }

    public static TimeMachineCreator getInstance() {
        if (timeMachineCreator == null) {
            synchronized (TimeMachineCreator.class) {
                timeMachineCreator = new TimeMachineCreator();
            }
        }
        return timeMachineCreator;
    }

    @Override
    public Machine createMachine(Customer customer) {
        if (timeMachine == null) {
            synchronized (TimeMachine.class) {
              timeMachine = new TimeMachine(customer.firstName() + "_" + UUID.randomUUID());
            }
        }
        return timeMachine;
    }
}

package creational.factory.machine.factory;

import creational.factory.machine.Machine;
import creational.factory.machine.TimeMachine;
import creational.factory.machine.model.Customer;

import java.util.Objects;
import java.util.UUID;

public final class TimeMachineCreator implements MachineCreator {

    @Override
    public Machine createMachine(Customer customer) {
        Objects.requireNonNull(customer, "customer");
        return TimeMachine.getInstance(customer.firstName() + "_" + UUID.randomUUID());
    }
}

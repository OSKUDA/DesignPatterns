package creational.factory.machine.factory;

import creational.factory.machine.Machine;
import creational.factory.machine.Microwave;
import creational.factory.machine.model.Customer;

import java.util.Objects;
import java.util.UUID;

public final class MicrowaveMachineCreator extends MachineCreator {

    @Override
    public Machine createMachine(Customer customer) {
        Objects.requireNonNull(customer, "customer");
        return new Microwave( customer.firstName() + "_" + UUID.randomUUID());
    }
}

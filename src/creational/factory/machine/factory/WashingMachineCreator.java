package creational.factory.machine.factory;

import creational.factory.machine.Machine;
import creational.factory.machine.WashingMachine;
import creational.factory.machine.model.Customer;

import java.util.Objects;
import java.util.UUID;

public class WashingMachineCreator extends MachineCreator{

    @Override
    public Machine createMachine(Customer customer) {
        Objects.requireNonNull(customer, "customer");
        return new WashingMachine(customer.firstName() + "_" + UUID.randomUUID());
    }
}

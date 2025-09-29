package creational.factory.machine.factory;

import creational.factory.machine.Machine;
import creational.factory.machine.WashingMachine;
import creational.factory.machine.model.Customer;

import java.util.UUID;

public class WashingMachineCreator extends MachineCreator{

    private final Customer customer;

    public WashingMachineCreator(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("ERROR : Customer is null");
        }
        this.customer = customer;
    }

    @Override
    public Machine createMachine() {
        return new WashingMachine(this.customer.firstName() + "_" + UUID.randomUUID());
    }
}

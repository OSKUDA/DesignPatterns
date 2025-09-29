package creational.factory.machine.factory;

import creational.factory.machine.Machine;
import creational.factory.machine.Microwave;
import creational.factory.machine.model.Customer;

import java.util.UUID;

public class MicrowaveMachineCreator extends MachineCreator {

    private final Customer customer;

    public MicrowaveMachineCreator(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("ERROR : Customer is null");
        }
        this.customer = customer;
    }

    @Override
    public Machine createMachine() {
        return new Microwave( this.customer.firstName() + "_" + UUID.randomUUID());
    }
}

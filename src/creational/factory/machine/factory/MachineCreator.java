package creational.factory.machine.factory;

import creational.factory.machine.Machine;
import creational.factory.machine.model.Customer;

public abstract class MachineCreator {

    public abstract Machine createMachine(Customer customer);

}

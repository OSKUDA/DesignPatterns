package creational.factory.machine.factory;

import creational.factory.machine.Machine;
import creational.factory.machine.model.Customer;

public interface MachineCreator {

    Machine createMachine(Customer customer);

}

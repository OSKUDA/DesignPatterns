package creational.factory.machine;

public class WashingMachine implements Machine {

    private final String name;

    public WashingMachine(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void doWork() {
        System.out.println(getName() + " is washing 🧽");
    }
}

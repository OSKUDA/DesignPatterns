package creational.factory.machine;

public class Microwave implements Machine {

    private final String name;

    public Microwave(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void doWork() {
        System.out.println(getName() + " is microwaving 📡");
    }
}

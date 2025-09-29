package creational.factory.machine;

public class TimeMachine implements Machine {

    private final String name;

    public TimeMachine(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void doWork() {
        System.out.println(this.name + " is going back in time ⏳");
    }
}

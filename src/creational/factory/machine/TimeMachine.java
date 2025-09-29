package creational.factory.machine;

public final class TimeMachine implements Machine {

    private final String name;

    private static TimeMachine instance;

    private TimeMachine(String name) {
        this.name = name;
    }

    public static TimeMachine getInstance(String name) {
        if (instance == null) {
            instance = new TimeMachine(name);
        }
        return instance;
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

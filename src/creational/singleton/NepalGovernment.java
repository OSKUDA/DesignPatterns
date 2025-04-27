package creational.singleton;

public final class NepalGovernment {

    private static NepalGovernment instance;

    private final String primeMinister;

    private NepalGovernment(String primeMinister) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
        this.primeMinister = primeMinister;
    }

    public static NepalGovernment getInstance(String value) {
        if (instance == null) {
            instance = new NepalGovernment(value);
        }
        return instance;
    }

    public String getPrimeMinister() {
        return this.primeMinister;
    }

    public static void resetInstance() {
        instance = null;
    }

}
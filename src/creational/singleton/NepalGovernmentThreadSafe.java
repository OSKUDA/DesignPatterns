package creational.singleton;

public class NepalGovernmentThreadSafe {

    private static volatile NepalGovernmentThreadSafe instance;

    private final String primeMinister;

    private NepalGovernmentThreadSafe(String primeMinister) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
        this.primeMinister = primeMinister;
    }

    public static NepalGovernmentThreadSafe getInstance(String primeMinister) {
        if (instance == null) {
            synchronized (NepalGovernmentThreadSafe.class) {
                if (instance == null) {
                    instance = new NepalGovernmentThreadSafe(primeMinister);
                }
            }
        }
        return instance;
    }

    public String getPrimeMinister() {
        return this.primeMinister;
    }

    public static void resetInstance() {
        synchronized (NepalGovernmentThreadSafe.class) {
            instance = null;
        }
    }

}

package creational.singleton;

public class SingletonPattern {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("SingletonPattern");

        System.out.println("1) single thread test. PM should be KP-OLI");
        NepalGovernment nepalGovernment1 = NepalGovernment.getInstance("KP-OLI");
        NepalGovernment nepalGovernment2 = NepalGovernment.getInstance("DEUBA");
        System.out.println("[1] NepalGovernment PM : " + nepalGovernment1.getPrimeMinister());
        System.out.println("[2] NepalGovernment PM : " + nepalGovernment2.getPrimeMinister());

        // reset instance
        NepalGovernment.resetInstance();

        System.out.println("2) multi thread test. Thread1 and Thread2");
        Thread thread1 = new Thread(() -> {
            NepalGovernment nepalGovernment = NepalGovernment.getInstance("KP-OLI");
            System.out.println("[Thread-1] PM: " + nepalGovernment.getPrimeMinister());
        });

        Thread thread2 = new Thread(() -> {
            NepalGovernment nepalGovernment = NepalGovernment.getInstance("DEUBA");
            System.out.println("[Thread-2] PM: " + nepalGovernment.getPrimeMinister());
        });
        thread1.start();
        thread2.start();

        System.out.println("3) multi thread test after synchronize keyword. Thread3 and Thread4");
        Thread thread3 = new Thread(() -> {
            NepalGovernmentThreadSafe nepalGovernmentThreadSafe = NepalGovernmentThreadSafe.getInstance("KP-OLI");
            System.out.println("[Thread-3] PM: " + nepalGovernmentThreadSafe.getPrimeMinister());
        });
        Thread thread4 = new Thread(() -> {
            NepalGovernmentThreadSafe nepalGovernmentThreadSafe = NepalGovernmentThreadSafe.getInstance("DEUBA");
            System.out.println("[Thread-4] PM: " + nepalGovernmentThreadSafe.getPrimeMinister());
        });

        thread3.start();
        thread4.start();

    }

}
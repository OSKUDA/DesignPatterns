package creational.builder.factory.models;

import java.util.List;

public class Manual {

    private int pages;

    private List<String> carSection;

    private String doorSection;

    private List<String> tireSection;

    private List<String> engineSection;

    private List<String> gpsSection;

    private String tripComputerSection;

    public Manual(int pages, List<String> carSection, String doorSection, List<String> tireSection, List<String> engineSection, List<String> gpsSection, String tripComputerSection) {
        this.pages = pages;
        this.carSection = carSection;
        this.doorSection = doorSection;
        this.tireSection = tireSection;
        this.engineSection = engineSection;
        this.gpsSection = gpsSection;
        this.tripComputerSection = tripComputerSection;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getDoorSection() {
        return doorSection;
    }

    public void setDoorSection(String doorSection) {
        this.doorSection = doorSection;
    }

    public List<String> getTireSection() {
        return tireSection;
    }

    public void setTireSection(List<String> tireSection) {
        this.tireSection = tireSection;
    }

    public List<String> getEngineSection() {
        return engineSection;
    }

    public void setEngineSection(List<String> engineSection) {
        this.engineSection = engineSection;
    }

    public List<String> getGpsSection() {
        return gpsSection;
    }

    public void setGpsSection(List<String> gpsSection) {
        this.gpsSection = gpsSection;
    }

    public String getTripComputerSection() {
        return tripComputerSection;
    }

    public void setTripComputerSection(String tripComputerSection) {
        this.tripComputerSection = tripComputerSection;
    }

    public List<String> getCarSection() {
        return carSection;
    }

    public void setCarSection(List<String> carSection) {
        this.carSection = carSection;
    }

    public void print() {
        System.out.println("========== CAR MANUAL ==========");

        System.out.println("Pages: " + pages);
        System.out.println();

        // --- CAR SECTION ---
        System.out.println("---- Car Section ----");
        if (carSection != null && !carSection.isEmpty()) {
            carSection.forEach(System.out::println);
        } else {
            System.out.println("No car information available.");
        }
        System.out.println();

        // --- DOOR SECTION ---
        System.out.println("---- Door Section ----");
        if (doorSection != null && !doorSection.isEmpty()) {
            System.out.println(doorSection);
        } else {
            System.out.println("No door information available.");
        }
        System.out.println();

        // --- TIRE SECTION ---
        System.out.println("---- Tire Section ----");
        if (tireSection != null && !tireSection.isEmpty()) {
            tireSection.forEach(System.out::println);
        } else {
            System.out.println("No tire information available.");
        }
        System.out.println();

        // --- ENGINE SECTION ---
        System.out.println("---- Engine Section ----");
        if (engineSection != null && !engineSection.isEmpty()) {
            engineSection.forEach(System.out::println);
        } else {
            System.out.println("No engine information available.");
        }
        System.out.println();

        // --- GPS SECTION ---
        System.out.println("---- GPS Section ----");
        if (gpsSection != null && !gpsSection.isEmpty()) {
            gpsSection.forEach(System.out::println);
        } else {
            System.out.println("No GPS information available.");
        }
        System.out.println();

        // --- TRIP COMPUTER SECTION ---
        System.out.println("---- Trip Computer Section ----");
        if (tripComputerSection != null && !tripComputerSection.isEmpty()) {
            System.out.println(tripComputerSection);
        } else {
            System.out.println("No trip computer information available.");
        }

        System.out.println("===============================");
    }

    @Override
    public String toString() {
        return "Manual{" +
                "pages=" + pages +
                ", carSection='" + carSection + '\'' +
                ", doorSection='" + doorSection + '\'' +
                ", tireSection='" + tireSection + '\'' +
                ", engineSection='" + engineSection + '\'' +
                ", gpsSection='" + gpsSection + '\'' +
                ", tripComputerSection='" + tripComputerSection + '\'' +
                '}';
    }
}

package structural.composite.orders;

public class MobileStand extends Product {

    public MobileStand(String id, String model, double price, double weight) {
        super(id, model, price, weight);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " -> " + super.toString();
    }
}

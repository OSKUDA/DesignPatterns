package structural.composite.orders;

public class Hammer extends Product {

    public Hammer(String id, String model, double price, double weight) {
        super(id, model, price, weight);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " -> " + super.toString();
    }

}

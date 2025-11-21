package structural.composite.orders;

import java.util.ArrayList;
import java.util.List;

public class Box implements Order {

    private final List<Order> orders;

    public Box() {
        this.orders = new ArrayList<>();
    }

    public void add(Order order) {
        orders.add(order);
    }

    public void remove(Order order) {
        orders.remove(order);
    }

    @Override
    public double getTotalWeight() {
        return orders.stream()
                .mapToDouble(Order::getTotalWeight)
                .sum();
    }

    @Override
    public double getTotalPrice() {
        return orders.stream()
                .mapToDouble(Order::getTotalPrice)
                .sum();
    }

    @Override
    public String toString() {
        return "Box{" +
                "orders=" + orders +
                '}';
    }
}

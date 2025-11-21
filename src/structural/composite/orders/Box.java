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

    public boolean remove(Order order) {
        if (orders.remove(order)) {
            return true;
        }
        for (Order o : orders) {
            if (o instanceof Box box && box.remove(order)) {
                return true;
            }
        }
        return false;
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

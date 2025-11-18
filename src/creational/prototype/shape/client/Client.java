package creational.prototype.shape.client;

import creational.prototype.shape.Circle;
import creational.prototype.shape.Rectangle;
import creational.prototype.shape.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Client {

    public static void main(String[] args) {

        List<Shape> shoppingCart = new ArrayList<>();

        Rectangle wood = new Rectangle(1, 2, "Brown", 12, 42);

        System.out.println("Client selects wood of size : " + wood.toString());

        System.out.println("Client wants to select another one as well but of length 14");

        Rectangle wood1 = (Rectangle) wood.clone();
        wood1.setLength(14);

        System.out.println("Client selects second wood of size : " + wood1.toString());

        shoppingCart.add(wood);
        shoppingCart.add(wood1);
        System.out.println("Wood added to shopping cart");

        Circle circle = new Circle(14, 12, "Green", 25);
        System.out.println("Client selects circle of size : " + circle);

        System.out.println("Client wants to select another circle of same color with radius 10");
        Circle circle1 = (Circle) circle.clone();
        circle1.setRadius(10);

        System.out.println("Client selects second circle of size : " + circle1.toString());

        System.out.println("Client wants one more circle but of red color");
        Circle circle2 = (Circle) circle1.clone();
        circle2.setColor("Red");

        shoppingCart.add(circle);
        shoppingCart.add(circle1);
        shoppingCart.add(circle2);
        System.out.println("Circle added to shopping cart");

        System.out.println("Client checks their shopping cart");
        shoppingCart.forEach(
                shape -> {
                    System.out.println(shape.getClass().getSimpleName() + " : " + shape.toString());
                }
        );

        System.out.println("Client wants to know the area so he can determine the space needed to carry it home");
        double totalArea = 0;
        for (Shape shape : shoppingCart) {
            double area = shape.area();
            System.out.println(shape.getClass().getSimpleName() + " area : " + area);
            totalArea += area;
        }
        System.out.println("Total area : " + totalArea);

        System.out.println("Client decides to double their shopping cart as there is more space in the trunk");

        shoppingCart.addAll(
                shoppingCart.stream()
                        .map(Shape::clone)
                        .toList()
        );

        System.out.println("Print final shoppingCart");
        shoppingCart.forEach(
                shape -> {
                    System.out.println(shape.getClass().getSimpleName() + " : " + shape.toString());
                }
        );
    }
}

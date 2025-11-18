package creational.prototype.shape;

public class Circle extends Shape {

    private double radius;

    public Circle(int x, int y, String color, double radius) {
        super(x, y, color);
        this.radius = radius;
    }

    public Circle(Circle source) {
        super(source);
        this.radius = source.radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public double area() {
        return Math.PI * (radius * radius);
    }

    @Override
    public String toString() {
        return super.toString() + "-" +
                "Circle{" +
                "radius=" + radius +
                '}';
    }
}

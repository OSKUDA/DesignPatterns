package creational.prototype.shape;

public class Rectangle extends Shape {

    private double length;

    private double width;

    public Rectangle(int x, int y, String color, double length, double width) {
        super(x, y, color);
        this.length = length;
        this.width = width;
    }

    public Rectangle(Rectangle source) {
        super(source);
        this.length = source.length;
        this.width = source.width;
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public double area() {
        return this.length * this.width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return super.toString() + "-" +
                "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }

}

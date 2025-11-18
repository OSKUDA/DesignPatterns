package structural.adapter.pegs;

public class SquarePeg {

    private final double length;

    public SquarePeg(double length) {
        this.length = length;
    }

    public double getLength() {
        return this.length;
    }

    @Override
    public String toString() {
        return "SquarePeg{" +
                "length=" + length +
                '}';
    }
}

package structural.adapter.pegs;

public class RoundPeg {

    private final double radius;

    public RoundPeg(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    public String toString() {
        return "RoundPeg{" +
                "radius=" + radius +
                '}';
    }
}

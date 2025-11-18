package structural.adapter.pegs;

public class RoundHole {

    private final double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public boolean fits(RoundPeg peg) {
        return this.radius >= peg.getRadius();
    }

    @Override
    public String toString() {
        return "RoundHole{" +
                "radius=" + radius +
                '}';
    }
}

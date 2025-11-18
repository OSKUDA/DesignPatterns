package structural.adapter.pegs;

public class SquarePegAdapter extends RoundPeg {

    private final SquarePeg squarePeg;

    public SquarePegAdapter(SquarePeg squarePeg) {
        super(0);
        this.squarePeg = squarePeg;
    }

    @Override
    public double getRadius() {
        return this.squarePeg.getLength() * Math.sqrt(2) / 2;
    }
}

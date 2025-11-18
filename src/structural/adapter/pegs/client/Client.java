package structural.adapter.pegs.client;

import structural.adapter.pegs.RoundHole;
import structural.adapter.pegs.RoundPeg;
import structural.adapter.pegs.SquarePeg;
import structural.adapter.pegs.SquarePegAdapter;

public class Client {

    public static void main(String[] args) {
        RoundHole roundHole = new RoundHole(32.2);
        System.out.println("RoundHole created : " + roundHole.toString());
        RoundPeg roundPeg = new RoundPeg(31.0);
        System.out.println("RoundPeg created : " + roundPeg.toString());
        SquarePeg squarePeg = new SquarePeg(13.5);
        System.out.println("SquarePeg created : " + squarePeg.toString());

        System.out.println("Client : Inserts RoundPeg to RoundHole");
        System.out.println("Fits : " + roundHole.fits(roundPeg));

        System.out.println("Client : Inserts SquarePeg to RoundHole");
        SquarePegAdapter squarePegAdapter = new SquarePegAdapter(squarePeg);
        System.out.println("Fits : " + roundHole.fits(squarePegAdapter));

        SquarePeg largeSquarePeg = new SquarePeg(89.1);
        SquarePegAdapter squarePegAdapter1 = new SquarePegAdapter(largeSquarePeg);
        System.out.println("Fits : " + roundHole.fits(squarePegAdapter1));

    }
}

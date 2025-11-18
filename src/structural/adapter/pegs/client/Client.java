package structural.adapter.pegs.client;

import structural.adapter.pegs.RoundHole;
import structural.adapter.pegs.RoundPeg;
import structural.adapter.pegs.SquarePeg;
import structural.adapter.pegs.SquarePegAdapter;

/**
 * Demonstrates the use of the Adapter Design Pattern using the classic
 * "round hole and square peg" example.
 *
 * <p>
 * This project illustrates how the Adapter pattern allows incompatible
 * classes to work together by converting the interface of one class
 * (SquarePeg) into an interface expected by another (RoundPeg),
 * without modifying existing code.
 * </p>
 *
 * <h2>Concept Recap</h2>
 * <ul>
 *   <li><b>Adapter Pattern (Structural Pattern)</b> – Enables objects with
 *   incompatible interfaces to collaborate by providing a wrapper that
 *   converts one interface into another.</li>
 *
 *   <li><b>Target</b> – The interface the client works with.
 *       In this project, {@link structural.adapter.pegs.RoundPeg} is the target.</li>
 *
 *   <li><b>Adaptee</b> – The existing class that is incompatible with the target interface.
 *       Here, {@link structural.adapter.pegs.SquarePeg} is the adaptee.</li>
 *
 *   <li><b>Adapter</b> – A class that translates the adaptee's interface into the target interface.
 *       Here, {@link structural.adapter.pegs.SquarePegAdapter} extends {@link structural.adapter.pegs.RoundPeg}
 *       and adapts a square peg so it can fit into a round hole.</li>
 *
 *   <li><b>Client</b> – The class that expects objects compatible with the target interface.
 *       This class (Client) only understands round pegs and round holes.</li>
 * </ul>
 *
 * <h2>Example Flow</h2>
 * <ol>
 *     <li>A {@link structural.adapter.pegs.RoundHole} is created with a specific radius.</li>
 *     <li>A {@link structural.adapter.pegs.RoundPeg} is created and checked if it fits the hole.</li>
 *     <li>A {@link structural.adapter.pegs.SquarePeg} cannot be inserted directly into the hole
 *         because the client expects round pegs.</li>
 *     <li>The {@link structural.adapter.pegs.SquarePegAdapter} converts the square peg into something
 *         that behaves like a round peg by calculating an equivalent radius based on geometry.</li>
 *     <li>The adapter is then used to check whether the square peg can fit the round hole.</li>
 * </ol>
 *
 * <h2>Why Adapter Pattern?</h2>
 * <p>
 * The Adapter pattern is extremely useful when integrating third-party code,
 * legacy systems, or incompatible APIs. Instead of changing working classes,
 * we build a translator (adapter) and keep systems loosely coupled.
 * </p>
 *
 * <h2>Key Takeaways</h2>
 * <ul>
 *   <li>Adapter allows you to reuse existing code without modification.</li>
 *   <li>It promotes loose coupling between components.</li>
 *   <li>Ideal when dealing with incompatible interfaces.</li>
 *   <li>The client remains unaware of the adaptee's internal structure.</li>
 * </ul>
 *
 * <p>
 * This Client class executes the pattern and prints whether round and square
 * pegs fit into a round hole, demonstrating real usage of the Adapter.
 * </p>
 */
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

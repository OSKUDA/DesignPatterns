package behavioral.strategy.calculator;

import behavioral.strategy.calculator.strategies.AddStrategy;
import behavioral.strategy.calculator.strategies.MultiplyStrategy;
import behavioral.strategy.calculator.strategies.SubtractStrategy;

/**
 * ============================================================
 * Strategy Pattern – Notes (Calculator Example)
 * ============================================================
 *
 * Intent:
 * --------
 * The Strategy pattern defines a family of algorithms,
 * encapsulates each one, and makes them interchangeable.
 * The algorithm can vary independently from the client
 * that uses it.
 *
 * In this example:
 * ----------------
 * - Calculator            → Context
 * - Strategy              → Strategy interface
 * - AddStrategy           → Concrete Strategy
 * - SubtractStrategy      → Concrete Strategy
 * - MultiplyStrategy      → Concrete Strategy
 * - Client                → Chooses the strategy at runtime
 *
 * How it works:
 * -------------
 * 1. Client selects a strategy using setStrategy().
 * 2. Calculator delegates execution to the selected strategy.
 * 3. Behavior changes without modifying Calculator code.
 *
 * Key Design Benefits:
 * --------------------
 * - Eliminates conditional logic (if/else or switch)
 * - Follows Open/Closed Principle (new strategies can be added)
 * - Promotes composition over inheritance
 * - Strategies can be swapped at runtime
 *
 * Important Design Notes:
 * -----------------------
 * - Calculator does not know which algorithm it is using.
 * - Each algorithm is encapsulated in its own class.
 * - Strategy selection is controlled by the client.
 *
 * Strategy vs State (Quick Recall):
 * --------------------------------
 * - Strategy: algorithm chosen externally by the client
 * - State: behavior changes internally based on state
 *
 * When to use Strategy pattern:
 * -----------------------------
 * - Multiple interchangeable algorithms exist
 * - Behavior must be selected at runtime
 * - You want to avoid large conditional blocks
 *
 * ============================================================
 */
public class Client {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.setStrategy(new AddStrategy());
        System.out.println("Add (5,6) -> " + calculator.execute(5,6));

        calculator.setStrategy(new SubtractStrategy());
        System.out.println("Subtract (1,4) -> " + calculator.execute(1,4));

        calculator.setStrategy(new MultiplyStrategy());
        System.out.println("Multiply (8,2) -> " + calculator.execute(8,2));


    }
}

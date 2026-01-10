package behavioral.strategy.calculator.strategies;

public class SubtractStrategy implements Strategy {
    @Override
    public int execute(int a, int b) {
        return Math.abs(a - b);
    }
}

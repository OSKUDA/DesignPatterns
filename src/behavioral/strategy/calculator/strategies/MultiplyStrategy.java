package behavioral.strategy.calculator.strategies;

public class MultiplyStrategy implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a * b;
    }
}

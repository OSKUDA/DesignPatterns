package behavioral.strategy.calculator;

import behavioral.strategy.calculator.strategies.Strategy;

public class Calculator {

    private Strategy strategy;

    public int execute(int a, int b) {
        return strategy.execute(a, b);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

}

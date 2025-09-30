package creational.abstractfactory.furniture.product;

public final class RetroChair implements Chair {

    private static final String MODEL_NAME = "RetroChair";

    private final int legCount;

    private final String color;

    public RetroChair(int legCount, String color) {
        this.legCount = legCount;
        this.color = color;
    }

    @Override
    public String getModelName() {
        return MODEL_NAME;
    }

    @Override
    public int getLegCount() {
        return this.legCount;
    }

    @Override
    public String getColor() {
        return this.color;
    }

}

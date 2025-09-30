package creational.abstractfactory.furniture.product;

public final class RetroTable implements Table {

    private static final String MODEL_NAME = "RetroTable";

    private final double height;

    private final String color;

    public RetroTable(double height, String color) {
        this.height = height;
        this.color = color;
    }

    @Override
    public String getModelName() {
        return MODEL_NAME;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public double getHeight() {
        return this.height;
    }
}

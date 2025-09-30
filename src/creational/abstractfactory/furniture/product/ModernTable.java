package creational.abstractfactory.furniture.product;

public final class ModernTable implements Table {

    private static final String MODEL_NAME = "ModernTable";

    private final String color;

    private final double height;

    public ModernTable(double height, String color) {
        this.color = color;
        this.height = height;
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

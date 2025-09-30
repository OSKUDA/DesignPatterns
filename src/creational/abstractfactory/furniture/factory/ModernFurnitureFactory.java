package creational.abstractfactory.furniture.factory;

import creational.abstractfactory.furniture.product.Chair;
import creational.abstractfactory.furniture.product.ModernChair;
import creational.abstractfactory.furniture.product.ModernTable;
import creational.abstractfactory.furniture.product.Table;

public final class ModernFurnitureFactory implements FurnitureFactory {

    @Override
    public Chair createChair(int legCount, String color) {
        return new ModernChair(legCount, color);
    }

    @Override
    public Table createTable(double height, String color) {
        return new ModernTable(height, color);
    }
}

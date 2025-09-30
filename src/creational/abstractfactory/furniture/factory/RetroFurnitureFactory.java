package creational.abstractfactory.furniture.factory;

import creational.abstractfactory.furniture.product.Chair;
import creational.abstractfactory.furniture.product.RetroChair;
import creational.abstractfactory.furniture.product.RetroTable;
import creational.abstractfactory.furniture.product.Table;

public final class RetroFurnitureFactory implements FurnitureFactory {

    @Override
    public Chair createChair(int legCount, String color) {
        return new RetroChair(legCount, color);
    }

    @Override
    public Table createTable(double height, String color) {
        return new RetroTable(height, color);
    }
}

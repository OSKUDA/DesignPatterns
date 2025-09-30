package creational.abstractfactory.furniture.factory;

import creational.abstractfactory.furniture.product.Chair;
import creational.abstractfactory.furniture.product.Table;

public interface FurnitureFactory {

    Chair createChair(int legCount, String color);

    Table createTable(double height, String color);

}

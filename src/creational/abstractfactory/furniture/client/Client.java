package creational.abstractfactory.furniture.client;

import creational.abstractfactory.furniture.factory.FurnitureFactory;
import creational.abstractfactory.furniture.factory.ModernFurnitureFactory;
import creational.abstractfactory.furniture.factory.RetroFurnitureFactory;
import creational.abstractfactory.furniture.product.Chair;
import creational.abstractfactory.furniture.product.Table;

public class Client {

    public static void main(String[] args) {
        furnishRoom(new RetroFurnitureFactory());
        furnishRoom(new ModernFurnitureFactory());
    }

    private static void furnishRoom(FurnitureFactory factory) {
        Chair chair = factory.createChair(4, "Red");
        System.out.println("My " + chair.getModelName() + " chair has " + chair.getLegCount() + " legs and is of color " + chair.getColor());

        Chair chair1 = factory.createChair(6, "Yellow");
        System.out.println("My " + chair1.getModelName() + " chair has " + chair1.getLegCount() + " legs and is of color " + chair1.getColor());

        Table table = factory.createTable(12.00, "White");
        System.out.println("My " + table.getModelName() + " table has " + table.getHeight() + " height and is of color " + table.getColor());

        Table table1 = factory.createTable(24.00, "Black");
        System.out.println("My " + table1.getModelName() + " table has " + table1.getHeight() + " height and is of color " + table1.getColor());
    }
}

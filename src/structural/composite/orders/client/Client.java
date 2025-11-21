package structural.composite.orders.client;

import structural.composite.orders.Box;
import structural.composite.orders.Hammer;
import structural.composite.orders.MobileStand;
import structural.composite.orders.Phone;

import java.util.UUID;

public class Client {

    public static void main(String[] args) {
        Hammer hammer = new Hammer(UUID.randomUUID().toString(), "rugged", 12.5, 1.5);
        Phone phone = new Phone(UUID.randomUUID().toString(), "iPhone", 75.0, 0.25);
        MobileStand mobileStand = new MobileStand(UUID.randomUUID().toString(), "elv", 2.5, 0.1);

        Box parcel = new Box();

        Box smallBox = new Box();
        smallBox.add(mobileStand);

        Box heavyDutyBox = new Box();
        heavyDutyBox.add(hammer);

        Box fragileBox = new Box();
        fragileBox.add(phone);

        Box mediumBox = new Box();
        mediumBox.add(fragileBox);
        mediumBox.add(smallBox);

        parcel.add(mediumBox);
        parcel.add(heavyDutyBox);

        System.out.println("Client checks the products added");
        System.out.println("Order : " + parcel.toString());

        System.out.println("Client wants to know the total weight of the parcel");
        System.out.println("Weight : " + parcel.getTotalWeight());

        System.out.println("Client wants to know the total price of the parcel");
        System.out.println("Price : " + parcel.getTotalPrice());
    }
}

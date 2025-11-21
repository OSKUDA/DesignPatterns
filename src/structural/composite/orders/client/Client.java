package structural.composite.orders.client;

import structural.composite.orders.Box;
import structural.composite.orders.Hammer;
import structural.composite.orders.MobileStand;
import structural.composite.orders.Phone;

import java.util.UUID;

/**
 * ============================================================
 *                  COMPOSITE DESIGN PATTERN
 * ============================================================
 * 1. INTENT
 * ----------
 * The Composite Pattern lets you treat **individual objects** (leaves)
 * and **groups of objects** (composites) uniformly using a common interface.
 * In other words:
 *      - A single Product (e.g., Phone) is treated the same way as
 *        a Box containing many products or even other boxes.
 * This is perfect for representing **hierarchical structures** such as:
 *      - File systems (File / Folder)
 *      - UI components (Button / Panel)
 *      - Product/Packaging systems (Product / Box)
 *      - Corporate structures (Employee / Manager)
 * 2. PARTICIPANTS
 * ----------------
 * (A) Component Interface (Order)
 *      - Defines the common operations used by both leaves and composites.
 *      - Here: getTotalWeight(), getTotalPrice()
 * (B) Leaf (Product subclasses: Hammer, Phone, MobileStand)
 *      - Represents an indivisible item.
 *      - Implements component operations directly.
 *      - Returns weight/price of a single product.
 * (C) Composite (Box)
 *      - Contains multiple Component objects.
 *      - May contain both Products (leaves) and other Boxes (nested composites).
 *      - Implements operations by **delegating to children**.
 *      - Computes total weight/price by summing across children.
 * 3. HOW IT WORKS INTERNALLY
 * ----------------------------
 *  - All elements implement the Order interface.
 *  - A Box maintains a list<List<Order>> allowing:
 *        - unlimited nesting
 *        - recursive aggregation
 *  - Calling getTotalWeight() or getTotalPrice():
 *        - If leaf: return own weight/price
 *        - If composite: iterate over children and sum values
 *  - Removing an element:
 *        - The composite searches recursively and removes it if found.
 * 4. BENEFITS
 * ------------
 *  ✔ Uniformity:
 *        Treat single items and groups of items the same way.
 *  ✔ Extensibility:
 *        Adding new product types or new container types is easy.
 *  ✔ Simplifies client code:
 *        The Client does not need to know whether it’s dealing with a
 *        simple product or a nested box — it just calls the interface.
 *  ✔ Natural representation of hierarchies.
 * 5. WHEN TO USE THE COMPOSITE PATTERN
 * -------------------------------------
 * Use it when you have:
 *      - Recursive structures
 *      - Objects that form part-whole relationships
 *      - The need to treat individual items and groups uniformly
 * Typical scenarios:
 *      - Packaging systems
 *      - GUI frameworks
 *      - XML/JSON tree structures
 *      - Organization trees
 *      - Game object hierarchies
 * 6. EXAMPLE SUMMARY
 * -----------------------------------------
 * Order      -> Component interface
 * Product    -> Leaf
 * Hammer     -> Concrete Leaf
 * Phone      -> Concrete Leaf
 * MobileStand-> Concrete Leaf
 * Box        -> Composite
 * Client     -> Demonstrates creating a product/box structure
 * 7. KEY TAKEAWAYS
 * ------------------
 *  - Think in terms of “tree structures”
 *  - The Component interface is the heart of the pattern
 *  - Composites store children and delegate work
 *  - Leaves perform work directly
 *  - Client code remains simple thanks to polymorphism
 * ============================================================
 */
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

        System.out.println("Client wants to remove MobileStand");
        parcel.remove(smallBox);

        System.out.println("Client checks the products added");
        System.out.println("Order : " + parcel.toString());

        System.out.println("Client wants to know the total weight of the parcel");
        System.out.println("Weight : " + parcel.getTotalWeight());

        System.out.println("Client wants to know the total price of the parcel");
        System.out.println("Price : " + parcel.getTotalPrice());
    }
}

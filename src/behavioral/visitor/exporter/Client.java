package behavioral.visitor.exporter;

import behavioral.visitor.exporter.shapes.*;
import behavioral.visitor.exporter.visitor.XMLExportVisitor;

/**
 * ============================
 * Visitor Pattern – Notes
 * ============================
 *
 * Intent:
 * --------
 * Visitor allows adding new operations to an existing object structure
 * without modifying the classes of the elements it operates on.
 *
 * Key Idea:
 * ---------
 * - The operation logic is moved OUT of the objects
 * - Objects accept a visitor and delegate the operation to it
 * - Uses double dispatch (object + visitor type)
 *
 * Roles in this example:
 * ---------------------
 * Client
 *  - Creates shape objects (Dot, Circle, Rectangle, CompoundShape)
 *  - Creates a Visitor (XMLExportVisitor)
 *  - Initiates the operation by passing shapes to the visitor
 *
 * Shape (Element interface)
 *  - Declares accept(Visitor)
 *
 * Concrete Elements
 *  - Dot, Circle, Rectangle, CompoundShape
 *  - Implement accept() by calling visitor.visitXxx(this)
 *
 * Visitor
 *  - Declares visit methods for each concrete shape
 *
 * Concrete Visitor
 *  - XMLExportVisitor implements export logic for all shapes
 *
 * Why Visitor is used here:
 * -------------------------
 * - We want to add a new operation (XML export)
 * - Without changing existing shape classes
 * - Shapes remain focused on geometry, not export logic
 *
 * Composite + Visitor:
 * --------------------
 * - CompoundShape holds child shapes
 * - Visitor recursively visits child elements
 * - Client stays unaware of traversal details
 *
 * Trade-offs:
 * -----------
 * + Easy to add new operations (JSON export, CSV export, etc.)
 * - Harder to add new element types (must update all visitors)
 *
 * Interview Tip:
 * --------------
 * Use Visitor when:
 * - Object structure is stable
 * - New operations are added frequently
 */
public class Client {
    public static void main(String[] args) {
        Dot dot = new Dot(1, 10, 55);
        Circle circle = new Circle(2, 23, 15, 10);
        Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30);

        CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.add(dot);
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        CompoundShape c = new CompoundShape(5);
        c.add(dot);
        compoundShape.add(c);

        export(circle, compoundShape);
    }

    private static void export(Shape... shapes) {
        XMLExportVisitor exportVisitor = new XMLExportVisitor();
        System.out.println(exportVisitor.export(shapes));
    }
}
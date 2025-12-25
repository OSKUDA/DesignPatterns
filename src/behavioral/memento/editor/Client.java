package behavioral.memento.editor;

import behavioral.memento.editor.editor.Editor;
import behavioral.memento.editor.shapes.Circle;
import behavioral.memento.editor.shapes.CompoundShape;
import behavioral.memento.editor.shapes.Dot;
import behavioral.memento.editor.shapes.Rectangle;

import java.awt.*;

/**
 * ============================================================
 *        MEMENTO PATTERN — CLIENT NOTES (EDITOR DEMO)
 * ============================================================
 *
 * INTENT
 * ------
 * Memento captures and externalizes an object’s internal state
 * so that it can be restored later, **without violating encapsulation**.
 *
 * Common use case: undo / redo.
 *
 *
 * MAPPING TO THIS EXAMPLE
 * -----------------------
 * Originator:
 *   Editor
 *   - owns mutable state (CompoundShape allShapes)
 *   - knows how to create a snapshot (backup)
 *   - knows how to restore a snapshot
 *
 * Memento:
 *   Memento
 *   - stores serialized snapshot of editor state
 *   - does NOT expose internal details
 *
 * Caretaker:
 *   History
 *   - keeps mementos
 *   - manages undo/redo navigation
 *   - never inspects editor state
 *
 *
 * RELATED PATTERNS USED
 * --------------------
 * Command:
 *   - user actions (move, color) are encapsulated as commands
 *   - memento saved BEFORE command execution
 *
 * Composite:
 *   - editor state is a tree of shapes (CompoundShape)
 *   - entire tree is snapshotted and restored
 *
 *
 * CLIENT FLOW
 * -----------
 * 1. Client creates Editor.
 * 2. Client loads initial shapes.
 * 3. User performs commands (move, color).
 * 4. Editor saves a memento before each command.
 * 5. Undo restores previous snapshot.
 * 6. Redo restores snapshot + re-executes command.
 *
 *
 * DESIGN CHOICES
 * --------------
 * - Full state snapshot via serialization:
 *     ✔ simple and safe
 *     ✖ higher memory & CPU cost
 *
 * - Centralized memento at Editor level
 *     ✔ fewer moving parts
 *     ✔ commands remain simple
 *
 *
 * KEY TAKEAWAYS
 * -------------
 * ✔ State history is kept without exposing internals.
 * ✔ Caretaker never depends on Originator’s structure.
 * ✔ Memento works naturally with Command for undo/redo.
 * ✔ Tradeoff: simplicity vs performance.
 *
 * ============================================================
 */
public class Client {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.loadShapes(
                new Circle(10, 10, 10, Color.BLUE),

                new CompoundShape(
                        new Circle(110, 110, 50, Color.RED),
                        new Dot(160, 160, Color.RED)
                ),

                new CompoundShape(
                        new Rectangle(250, 250, 100, 100, Color.GREEN),
                        new Dot(240, 240, Color.GREEN),
                        new Dot(240, 360, Color.GREEN),
                        new Dot(360, 360, Color.GREEN),
                        new Dot(360, 240, Color.GREEN)
                )
        );
    }
}

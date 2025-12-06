package behavioral.mediator.notes;

import behavioral.mediator.notes.components.*;
import behavioral.mediator.notes.mediator.Editor;
import behavioral.mediator.notes.mediator.Mediator;

import javax.swing.*;

/**
 * ============================================================
 *        MEDIATOR PATTERN — CLIENT NOTES (NOTES DEMO)
 * ============================================================
 *
 * INTENT
 * ------
 * Mediator defines an object that **centralizes communication**
 * between components. Components (colleagues) don’t talk to each other
 * directly; they notify the mediator, which coordinates behavior.
 *
 * This reduces coupling and keeps interaction logic in one place.
 *
 *
 * MAPPING TO THIS EXAMPLE
 * -----------------------
 * Mediator interface:
 *   Mediator
 *   - declares operations colleagues can trigger
 *
 * Concrete Mediator:
 *   Editor
 *   - holds references to all UI components
 *   - contains all coordination logic (add, delete, select, save, filter)
 *
 * Colleagues (components):
 *   Title, TextBox, AddButton, DeleteButton, SaveButton, List, Filter
 *   - each component has a mediator reference
 *   - on user action, they call mediator methods
 *   - they never call each other directly
 *
 *
 * CLIENT FLOW
 * -----------
 * 1. Client creates Mediator (Editor).
 * 2. Client registers all components with the mediator.
 *      - mediator injects itself into each component
 *      - mediator stores references for coordination
 * 3. Client calls mediator.createGUI() to build the app.
 *
 *
 * EXAMPLE INTERACTIONS
 * --------------------
 * Add button clicked  -> mediator.addNewNote()
 * Delete clicked      -> mediator.deleteNote()
 * List item selected  -> mediator.getInfoFromList(note)
 * Typing in title/text-> mediator.markNote()
 * Filter typing       -> mediator.setElementsList(filteredModel)
 *
 *
 * KEY TAKEAWAYS
 * -------------
 * ✔ Components stay simple and reusable.
 * ✔ Complex interaction rules live in the mediator only.
 * ✔ Adding new behaviors usually changes mediator, not every component.
 * ✔ Great for GUIs, chat rooms, workflow coordinators.
 *
 * ============================================================
 */
public class Client {

    public static void main(String[] args) {
        Mediator mediator = new Editor();

        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox());
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new List(new DefaultListModel<>()));
        mediator.registerComponent(new Filter());

        mediator.createGUI();
    }
}

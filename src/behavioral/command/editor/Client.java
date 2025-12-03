package behavioral.command.editor;

/**
 * ============================================================
 *           COMMAND PATTERN — CLIENT NOTES (EDITOR DEMO)
 * ============================================================
 *
 * INTENT
 * ------
 * Command turns a request into an object.
 * This lets you:
 *   - parameterize actions
 *   - queue/log actions
 *   - support undo/redo
 *   - decouple sender from receiver
 *
 *
 * MAPPING TO THIS EXAMPLE
 * -----------------------
 * Receiver:
 *   Editor
 *   - holds actual state (textField, clipboard)
 *   - commands modify this state
 *
 * Command (abstract):
 *   Command
 *   - defines execute() and undo()
 *   - stores backup of editor text for undo
 *
 * Concrete Commands:
 *   CopyCommand  -> copies selection to clipboard (no state change)
 *   CutCommand   -> removes selection + updates clipboard (state change)
 *   PasteCommand -> inserts clipboard into text (state change)
 *
 * Invoker:
 *   UI Buttons in Editor (Ctrl+C, Ctrl+X, Ctrl+V, Ctrl+Z)
 *   - create command objects
 *   - call executeCommand(command)
 *
 * History:
 *   CommandHistory
 *   - stores only mutating commands
 *   - supports undo via stack
 *
 *
 * CLIENT FLOW
 * -----------
 * 1. Client creates Editor and initializes GUI.
 * 2. Button clicks create corresponding Command objects.
 * 3. Editor executes the command.
 * 4. If command changed state, it is pushed to history.
 * 5. Undo pops last command and restores backup.
 *
 *
 * KEY TAKEAWAYS
 * -------------
 * ✔ Actions are encapsulated as objects.
 * ✔ Invoker doesn’t know how an action is performed.
 * ✔ Easy to add new operations without changing Editor/UI.
 * ✔ Undo is natural because commands keep their own history/backup.
 *
 * ============================================================
 */
public class Client {

    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.init();
    }
}

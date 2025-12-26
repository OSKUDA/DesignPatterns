package behavioral.observer.app;

import behavioral.observer.app.editor.Editor;
import behavioral.observer.app.listener.EmailNotificationListener;
import behavioral.observer.app.listener.LogOpenListener;

/**
 * ============================================================
 * OBSERVER PATTERN – NOTES & FILE EDITOR EXAMPLE
 * ============================================================
 *
 * Intent:
 * --------
 * Define a one-to-many dependency so that when one object
 * (Subject) changes state, all its dependents (Observers)
 * are notified automatically.
 *
 *
 * This example models an EVENT-DRIVEN FILE EDITOR.
 *
 * ------------------------------------------------------------
 * Pattern Roles in this Example
 * ------------------------------------------------------------
 *
 * Subject (Publisher):
 *   - EventManager
 *   - Maintains a map of eventType -> list of listeners
 *   - Notifies listeners when an event occurs
 *
 * Concrete Subject:
 *   - Editor
 *   - Triggers events ("open", "save") but knows nothing
 *     about concrete listeners
 *
 * Observer:
 *   - EventListener (interface)
 *
 * Concrete Observers:
 *   - LogOpenListener        → reacts to "open" events
 *   - EmailNotificationListener → reacts to "save" events
 *
 * Client:
 *   - Creates the Editor
 *   - Subscribes listeners to specific events
 *   - Executes operations that trigger notifications
 *
 *
 * ------------------------------------------------------------
 * Flow of Execution
 * ------------------------------------------------------------
 *
 * 1. Client creates Editor
 *    - Editor internally creates EventManager
 *    - Supported events: "open", "save"
 *
 * 2. Client subscribes observers:
 *    - LogOpenListener → "open"
 *    - EmailNotificationListener → "save"
 *
 * 3. Client opens a file:
 *    - Editor.openFile(...)
 *    - EventManager.notify("open", file)
 *    - LogOpenListener is triggered
 *
 * 4. Client saves the file:
 *    - Editor.saveFile()
 *    - EventManager.notify("save", file)
 *    - EmailNotificationListener is triggered
 *
 *
 * ------------------------------------------------------------
 * Key Design Benefits Demonstrated
 * ------------------------------------------------------------
 *
 * ✔ Loose coupling
 *   - Editor depends only on EventManager, not listeners
 *
 * ✔ Open/Closed Principle
 *   - New listeners can be added without modifying Editor
 *
 * ✔ Single Responsibility
 *   - Editor handles file logic
 *   - Listeners handle reactions (logging, email, etc.)
 *
 * ✔ Event-driven architecture
 *   - Very similar to GUI listeners, Spring events,
 *     Kafka consumers, and webhooks
 *
 *
 * ------------------------------------------------------------
 * Interview Talking Points
 * ------------------------------------------------------------
 *
 * - Observer decouples event producers from event consumers
 * - Subject doesn’t know concrete observers
 * - Supports dynamic subscribe/unsubscribe
 * - This example demonstrates event-based observer,
 *   a common real-world variation
 *
 * ============================================================
 */
public class Client {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

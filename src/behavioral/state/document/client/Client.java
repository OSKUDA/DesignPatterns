package behavioral.state.document.client;

import behavioral.state.document.Document;

/**
 * ============================================================
 * State Pattern – Notes (Document Workflow Example)
 * ============================================================
 *
 * Intent:
 * --------
 * The State pattern allows an object to alter its behavior
 * when its internal state changes, without using conditional
 * logic (if/else or switch).
 *
 * In this example:
 * ----------------
 * - `Document` is the Context.
 * - `DocumentState` is the State interface.
 * - Concrete states:
 *     - DraftState
 *     - ReviewState
 *     - ReviewedState
 *     - PublishedState
 *
 * Each state encapsulates behavior for:
 * - write(String)
 * - publish()
 *
 * How this example works:
 * -----------------------
 * 1. Document starts in DraftState.
 *    - write() is allowed.
 *    - publish() moves to ReviewState.
 *
 * 2. ReviewState / ReviewedState:
 *    - Controls approval flow.
 *    - publish() advances document lifecycle.
 *
 * 3. PublishedState:
 *    - write() is blocked.
 *    - publish() is idempotent / no-op.
 *
 * Key Design Benefits:
 * --------------------
 * - No conditional logic in Document.
 * - State-specific behavior is isolated.
 * - New states can be added without
 *   modifying existing state logic (OCP).
 * - Encapsulation is preserved:
 *   states interact with Document via
 *   controlled methods, not raw data access.
 *
 * Interview Talking Point:
 * ------------------------
 * "This example shows how behavior changes dynamically
 * based on the current state, with state transitions
 * handled by state objects themselves rather than
 * conditional logic inside the context."
 *
 * When to use State pattern:
 * --------------------------
 * - Object has multiple states with different behaviors.
 * - State transitions are explicit and frequent.
 * - You want to eliminate complex conditionals.
 *
 * ============================================================
 */
public class Client {
    public static void main(String[] args) {
        Document document = new Document();

        document.write("This is my report document");
        document.write("I will write my report here");

        document.render();
        document.write("My report is completed");
        document.publish();
        document.publish();
        document.publish();

        document.write("Update title");

    }
}

package behavioral.observer.newspaper.client;

import behavioral.observer.newspaper.Consumer;
import behavioral.observer.newspaper.Event;
import behavioral.observer.newspaper.NewspaperManager;

/**
 * ============================================================
 * OBSERVER PATTERN – NOTES & EXAMPLE WALKTHROUGH
 * ============================================================
 *
 * Intent:
 * --------
 * Define a one-to-many dependency between objects so that
 * when one object (Subject) changes state, all its dependent
 * objects (Observers) are notified automatically.
 *
 *
 * This example models a NEWSPAPER PUBLISHING SYSTEM.
 *
 * ------------------------------------------------------------
 * Pattern Roles in this Example
 * ------------------------------------------------------------
 *
 * Subject (Publisher):
 *   - Publisher
 *   - Maintains a list of subscribers per Event
 *   - Notifies subscribers when an event occurs
 *
 * Observer:
 *   - Subscriber (interface)
 *   - Consumer (concrete observer)
 *
 * Events:
 *   - NEW_LAUNCH
 *   - PUBLISH_NEWSPAPER
 *
 * Client:
 *   - Wires everything together
 *   - Registers subscribers for specific events
 *   - Triggers events indirectly via NewspaperManager
 *
 *
 * ------------------------------------------------------------
 * Flow of Execution
 * ------------------------------------------------------------
 *
 * 1. Client creates NewspaperManager
 *    - Internally creates a Publisher (Subject)
 *
 * 2. Client creates multiple Consumers (Observers)
 *
 * 3. Consumers subscribe to specific events:
 *      - Some subscribe to NEW_LAUNCH
 *      - Some subscribe to PUBLISH_NEWSPAPER
 *
 * 4. When a newspaper is added:
 *      - Publisher publishes NEW_LAUNCH
 *      - All subscribers of NEW_LAUNCH are notified
 *
 * 5. When daily newspaper is sent:
 *      - Publisher publishes PUBLISH_NEWSPAPER
 *      - Only subscribers of this event are notified
 *
 *
 * ------------------------------------------------------------
 * Key Design Benefits Demonstrated
 * ------------------------------------------------------------
 *
 * ✔ Loose coupling
 *   - Publisher depends only on Subscriber interface
 *
 * ✔ Open/Closed Principle
 *   - New subscribers or events can be added without
 *     modifying existing publisher logic
 *
 * ✔ Event-driven design
 *   - Subscribers react only to events they are interested in
 *
 * ✔ Real-world applicability
 *   - Mirrors notification systems, messaging, listeners,
 *     Spring ApplicationEvents, Kafka consumers, etc.
 *
 *
 * ------------------------------------------------------------
 * Interview Talking Points
 * ------------------------------------------------------------
 *
 * - Observer enables automatic notification of dependent objects
 * - Subject does NOT know concrete observer implementations
 * - Supports dynamic subscribe / unsubscribe
 * - Event-based observer is a common real-world enhancement
 *
 * ============================================================
 */
public class Client {

    public static void main(String[] args) {
        NewspaperManager newspaperManager = new NewspaperManager();

        Consumer consumer1 = new Consumer();
        Consumer consumer2 = new Consumer();
        Consumer consumer3 = new Consumer();
        Consumer consumer4 = new Consumer();
        Consumer consumer5 = new Consumer();

        newspaperManager.addSubscriber(consumer1, Event.NEW_LAUNCH);
        newspaperManager.addSubscriber(consumer2, Event.NEW_LAUNCH);
        newspaperManager.addSubscriber(consumer3, Event.NEW_LAUNCH);
        newspaperManager.addSubscriber(consumer4, Event.NEW_LAUNCH);
        newspaperManager.addSubscriber(consumer5, Event.NEW_LAUNCH);
        newspaperManager.addSubscriber(consumer1, Event.PUBLISH_NEWSPAPER);
        newspaperManager.addSubscriber(consumer3, Event.PUBLISH_NEWSPAPER);


        newspaperManager.addNewspaper(
                "Himalayan",
                "Serving you cold news directly from the Himalays",
                6
        );

        newspaperManager.addNewspaper(
                "Karachi",
                "Serving you sad news directly from the Karachi",
                12
        );

        newspaperManager.sendDailyNewspaper();
        newspaperManager.sendDailyNewspaper();

    }
}

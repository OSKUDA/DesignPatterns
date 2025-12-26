package behavioral.observer.newspaper;

import java.util.ArrayList;
import java.util.HashMap;

public class Publisher {

    private final HashMap<Event, ArrayList<Subscriber>> subscriberList;

    public Publisher() {
        this.subscriberList = new HashMap<>();
    }

    public void subscribe(Subscriber subscriber, Event event) {
        if (subscriberList.containsKey(event)) {
            subscriberList.get(event).add(subscriber);
        } else {
            ArrayList<Subscriber> subscribers = new ArrayList<>();
            subscribers.add(subscriber);
            subscriberList.put(event, subscribers);
        }
    }

    public void publish(Event event, String data) {
        subscriberList
                .getOrDefault(event, new ArrayList<Subscriber>())
                .forEach(
                        subscriber -> subscriber.update(event, data)
                );
    }

    public void listSubscribers() {
        subscriberList.forEach(
                (key, value) -> {
                    System.out.println("Event : " + key);
                    System.out.println("Subscribers : " + value);
                }
        );
    }

    public void unsubscribe(Subscriber subscriber, Event event) {
        ArrayList<Subscriber> subscribers = subscriberList.get(event);
        if (subscribers != null) {
            subscribers.remove(subscriber);
        }
    }
}

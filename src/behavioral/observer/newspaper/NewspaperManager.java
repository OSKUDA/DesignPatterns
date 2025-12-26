package behavioral.observer.newspaper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class NewspaperManager {

    private final ArrayList<Newspaper> newspaperList;

    private final Publisher publisher;

    public NewspaperManager() {
        this.publisher = new Publisher();
        this.newspaperList = new ArrayList<>();
    }

    public void addNewspaper(String name, String content, int pageSize) {
        newspaperList.add(new Newspaper(new Random().nextInt(), name, LocalDate.now(), content, pageSize));
        publisher.publish(Event.NEW_LAUNCH, name);
    }

    public void sendDailyNewspaper() {
        newspaperList.forEach(
                newspaper -> {
                    publisher.publish(Event.PUBLISH_NEWSPAPER, newspaper.name());
                }
        );
    }

    public void addSubscriber(Consumer consumer, Event event) {
        publisher.subscribe(consumer, event);
        System.out.println("Consumer : " + consumer + " added for subscription to event : " + event);
    }

}

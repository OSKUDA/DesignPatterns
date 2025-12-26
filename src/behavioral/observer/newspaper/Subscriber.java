package behavioral.observer.newspaper;

public interface Subscriber {
    void update(Event event, String data);
}

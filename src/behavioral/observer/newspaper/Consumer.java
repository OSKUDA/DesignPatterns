package behavioral.observer.newspaper;

import java.util.Random;

public class Consumer implements Subscriber {

    private final int id;

    public Consumer() {
        this.id = new Random().nextInt(1, Integer.MAX_VALUE);
    }
    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                '}';
    }

    @Override
    public void update(Event event, String data) {
        System.out.println("Consumer id " + this.id + " notified of event " + event + " with data : " + data);
    }
}

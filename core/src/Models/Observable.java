package Models;

import java.util.ArrayList;
import java.util.List;

public class Observable {

    private List<Subscriber> subscribers = new ArrayList<>();

    public void addSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber){
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String eventType, Entity entity){
        for (Subscriber subscriber : subscribers){
            subscriber.update(eventType, entity);
        }
    }
}

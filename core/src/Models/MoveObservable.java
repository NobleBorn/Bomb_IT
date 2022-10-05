package Models;

import java.util.ArrayList;
import java.util.List;

public class MoveObservable {

    private List<MoveSubscriber> subscribers = new ArrayList<>();

    public void addSubscriber(MoveSubscriber subscriber){
        subscribers.add(subscriber);
    }

    public void removeSubscriber(MoveSubscriber subscriber){
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(Position oldPosition, Position newPosition){ //Generics could be used
        for (MoveSubscriber subscriber : subscribers){
            subscriber.update(oldPosition, newPosition);
        }
    }
}

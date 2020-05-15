import java.util.ArrayList;
import java.util.List;

public class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void changeState(String msg) {
        notifyAllObservers(msg);
    }

    public void register(Observer observer) {
        observers.add(observer);
    }

    private void notifyAllObservers(String msg) {
        for (Observer observer : observers) {
            observer.update(msg);
        }
    }
}


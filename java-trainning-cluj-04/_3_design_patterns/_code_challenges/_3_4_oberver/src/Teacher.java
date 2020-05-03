import java.util.ArrayList;
import java.util.List;

public class Teacher implements ObservedSubject {
    private List<Observer> observerList = new ArrayList<>();

    public void teach(String subjects) {
        notifyObservers(subjects);
    }

    @Override
    public void register(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : this.observerList) {
            observer.update(message);
        }
    }
}

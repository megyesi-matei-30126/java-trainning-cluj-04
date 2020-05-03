public interface ObservedSubject {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers(String message);
}

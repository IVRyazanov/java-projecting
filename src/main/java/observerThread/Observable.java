package observerThread;

/**
 * Created by Ivan.Ryazanov on 11.04.2016.
 */
public interface Observable {
    void registerObserver(Thread observer);
    void removeObserver(Observer observer);
    void notifyObserver(Observer observer);
}

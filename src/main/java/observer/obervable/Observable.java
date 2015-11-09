package observer.obervable;

import observer.observers.Observer;

/**
 * Created by Ivan.Ryazanov on 09.11.2015.
 */
public interface Observable {
    void addObserver(Observer obj);
    void removeObserver(Observer obj);
    void notifyObservers();
}

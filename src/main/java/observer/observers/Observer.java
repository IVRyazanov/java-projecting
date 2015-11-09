package observer.observers;

import observer.obervable.Observable;

/**
 * Created by Ivan.Ryazanov on 09.11.2015.
 */
public interface Observer {
    void update(int pressure, int temperature);
}

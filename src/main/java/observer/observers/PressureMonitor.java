package observer.observers;

import observer.obervable.Observable;

/**
 * Created by Ivan.Ryazanov on 09.11.2015.
 */
public class PressureMonitor implements Observer {
    Observable observable;
    public PressureMonitor(Observable obs){
        observable = obs;
        observable.addObserver(this);
    }

    @Override
    public void update(int pressure, int temperature) {
        System.out.println("Pressure monitor " + pressure);
    }
}

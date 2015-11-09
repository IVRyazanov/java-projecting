package observer.observers;

import observer.obervable.Observable;
import observer.obervable.WeatherData;

/**
 * Created by Ivan.Ryazanov on 09.11.2015.
 */
public class TemperatureMonitor implements Observer {
    Observable observable;
    public TemperatureMonitor(WeatherData weatherData) {
        this.observable = weatherData;
        observable.addObserver(this);
    }

    @Override
    public void update(int pressure, int temperature) {
        System.out.println("TemperatureMonitor" + temperature);
    }
}

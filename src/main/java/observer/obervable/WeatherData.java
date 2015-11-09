package observer.obervable;

import observer.observers.Observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ivan.Ryazanov on 09.11.2015.
 */
public class WeatherData implements Observable {
    int pressure;
    int temperature;

    List<Observer> observerList = new ArrayList<Observer>();
    @Override
    public void addObserver(Observer obj) {
        observerList.add(obj);
    }

    @Override
    public void removeObserver(Observer obj) {
        Iterator<Observer> iter = observerList.iterator();
        if(observerList.contains(obj)){
            while (iter.hasNext()) {
                Observer next = iter.next();
                if(iter==obj) iter.remove();
            }
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(pressure, temperature);
        }
    }

    public void setWeather(int pressure, int temperature){
        this.pressure = pressure;
        this.temperature = temperature;
        notifyObservers();
    }

    public int getPressure() {
        return pressure;
    }

    public int getTemperature() {
        return temperature;
    }
}

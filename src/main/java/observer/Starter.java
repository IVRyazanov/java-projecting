package observer;

import observer.obervable.WeatherData;
import observer.observers.PressureMonitor;
import observer.observers.TemperatureMonitor;

/**
 * Created by Ivan.Ryazanov on 09.11.2015.
 */
public class Starter {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        PressureMonitor pressureMonitor = new PressureMonitor(weatherData);
        TemperatureMonitor temperatureMonitor = new TemperatureMonitor(weatherData);

        weatherData.setWeather(120, 25);
        weatherData.setWeather(140, 35);
    }
}

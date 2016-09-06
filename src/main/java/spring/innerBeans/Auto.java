package spring.innerBeans;

import java.util.List;

/**
 * Created by SBT-Ryazanov-IV on 06.09.2016.
 */
public class Auto {
    @Override
    public String toString() {
        return "Auto{" +
                "name='" + name + '\'' +
                ", engine=" + engine +
                ", wheels=" + wheels +
                '}';
    }

    String name;
    Engine engine;
    List<Wheel> wheels;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }
}

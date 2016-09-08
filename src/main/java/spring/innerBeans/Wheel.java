package spring.innerBeans;

/**
 * Created by SBT-Ryazanov-IV on 06.09.2016.
 */
public class Wheel {
    String name;
    final private int id = counter++;
    static private int counter;
    int diameter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", diameter=" + diameter +
                ", counter=" + counter +
                '}';
    }
}

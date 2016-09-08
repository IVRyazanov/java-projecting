package spring.innerBeans;

/**
 * Created by SBT-Ryazanov-IV on 06.09.2016.
 */
public class Engine {
    final private int id = counter++;
    static int counter;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", counter='" + counter + '\'' +
                '}';
    }
}

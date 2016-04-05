package closure;

/**
 * Created by Иван on 05.04.2016.
 */
public class Callee1 implements Incrementable {
    private int i;
    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

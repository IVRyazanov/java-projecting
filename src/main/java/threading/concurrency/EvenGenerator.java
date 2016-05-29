package threading.concurrency;

/**
 * Created by Иван on 29.05.2016.
 */
public class EvenGenerator extends IntGenerator {
    private int currentValue = 0;
    @Override
    public synchronized int next() {
        ++currentValue;
        Thread.yield();
        ++currentValue;
        return currentValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}

package threading.philosopher;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Иван on 06.06.2016.
 */
public class Philosopher implements Runnable {
    private int koef;
    private Random random = new Random();
    private static int counter = 0;
    private int id = counter++;
    Flatware leftInstrument;
    Flatware rightInstrument;

    public Philosopher(Flatware leftInstrument, Flatware rightInstrument, int timeKoef){
        this.leftInstrument = leftInstrument;
        this.rightInstrument = rightInstrument;
        koef = timeKoef;
    }


    public void run() {

    }

    public void waiting() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(100) * koef);
    }

    public void takeFlatWare(Flatware instrument) throws InterruptedException {
        if(instrument.isUse()){
            wait();
        }
        instrument.setUse(true);
    }

    public void eat() throws InterruptedException {
        System.out.println(this + " eating...");
        waiting();
        System.out.println(this + " finish to eat...");
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                ", id=" + id +
                ", leftInstrument=" + leftInstrument +
                ", rightInstrument=" + rightInstrument +
                '}';
    }
}

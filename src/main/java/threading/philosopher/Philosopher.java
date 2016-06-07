package threading.philosopher;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Иван on 06.06.2016.
 */
public class Philosopher implements Runnable {
    private int koef;
    private Random random = new Random();
    private static int counter = 1;
    private int id = counter++;
    Flatware leftInstrument;
    Flatware rightInstrument;

    public Philosopher(Flatware leftInstrument, Flatware rightInstrument, int timeKoef){
        this.leftInstrument = leftInstrument;
        this.rightInstrument = rightInstrument;
        koef = timeKoef;
    }


    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println(this + "thinking...");
                waiting();
                System.out.println(this + "ready to eat!!!");
                leftInstrument.take();
                rightInstrument.take();
                eat();
                leftInstrument.drop();
                rightInstrument.drop();
            }
            } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waiting() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(100) * koef);
    }

    public synchronized void eat() throws InterruptedException {
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

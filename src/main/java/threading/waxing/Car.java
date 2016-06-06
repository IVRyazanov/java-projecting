package threading.waxing;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ivan.Ryazanov on 06.06.2016.
 */
public class Car {
    private volatile  boolean waxing = false;
    private Random random = new Random();

    public synchronized void setWaxing(boolean waxing) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
        this.waxing = waxing;
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        if(waxing == true)
            wait();
    }

    public synchronized void waitForPolish() throws InterruptedException{
        if(waxing == false)
            wait();
    }

    static class Wax implements Runnable{
        private Car car;
        Wax(Car carObj){
            car = carObj;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    car.waitForWaxing();
                    System.out.println("waxing");
                    car.setWaxing(true);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Polish implements Runnable{
        Car car;

        Polish(Car car){
            this.car = car;
        }

        @Override
        public void run() {
            try {
                while (true){
                    car.waitForPolish();
                    System.out.println("polishing");
                    car.setWaxing(false);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Polish(car));
        executorService.execute(new Wax(car));
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}

package threading.devideBy2;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Иван on 29.05.2016.
 */
public class Checker implements Runnable {
    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    private static int counter = 1;
    private int id = counter++;

    public void run() {
        int value = Generator.next();
        while (value % 2 != 0) {
            updateMap();
            try {
                System.out.println(this + " " + value + " dont access, lets take new value");
                value = Generator.next();
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        updateMap();
        System.out.println(this + " find needed value");
    }

    private void updateMap(){
        Integer currentTry = map.get(id);
        if (currentTry == null) {
            map.put(id, 1);
        } else {
            map.put(id, ++currentTry);
        }
    }


    @Override
    public String toString() {
        return "thread id = " + Thread.currentThread() + " " + id;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(new Checker());
        }
        exec.shutdown();
        while (!exec.awaitTermination(24L, TimeUnit.HOURS)) {
            System.out.println("Not yet. Still waiting for termination");
        }
        System.out.println(Checker.map);

    }
}

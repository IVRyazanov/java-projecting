package threading.addedLibrary.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Ivan.Ryazanov on 08.06.2016.
 */
public class WaitTask implements Runnable {
    CountDownLatch latch;

    public WaitTask(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("complete task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        int countDown = 70;
        CountDownLatch latch = new CountDownLatch(countDown);
        ExecutorService ex = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            ex.execute(new WaitTask(latch));
        }
        for (int i = 0; i < countDown; i++) {
            ex.execute(new TaskPart(latch));
        }

    }
}

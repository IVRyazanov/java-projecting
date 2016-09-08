package threading.addedLibrary.countDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ivan.Ryazanov on 08.06.2016.
 */
public class TaskPart implements Runnable{
    CountDownLatch latch;
    public TaskPart(CountDownLatch latch){
        this.latch = latch;
    }
    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(10000));
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

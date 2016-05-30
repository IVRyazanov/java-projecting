package threading.concurrency.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Иван on 29.05.2016.
 */
public class AttempLocking {
    private ReentrantLock lock = new ReentrantLock();
    public void untimed(){
        boolean captured = lock.tryLock();
        try{
            System.out.println("tryLock(): " + captured);
        } finally {
            if(captured) lock.unlock();
        }
    }

    public void timed(){
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            throw  new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);

        } finally {
            if(captured) lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final AttempLocking a1 = new AttempLocking();
        a1.untimed();
        a1.timed();
        new Thread(){
            {setDaemon(true);}

            @Override
            public void run() {
                a1.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        TimeUnit.SECONDS.sleep(1);
        Thread.yield();
        a1.untimed();
        a1.timed();
    }
}

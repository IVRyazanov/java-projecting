package threading.addedLibrary.delayed;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Ivan.Ryazanov on 09.06.2016.
 */
public class DelayTask implements Runnable, Delayed {
    private long delta;
    private long trigger;
    protected static ArrayList<DelayTask> delayTasks = new ArrayList<DelayTask>();
    private static int counter = 0;
    private final int id = counter++;

    public DelayTask(long deltaMilliseconds) {
        this.delta = deltaMilliseconds;
        delayTasks.trimToSize();
        trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delta, TimeUnit.MILLISECONDS);
        delayTasks.add(this);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayTask that = (DelayTask) o;
        if (this.trigger > that.trigger) return 1;
        if (this.trigger < that.trigger) return -1;
        return 0;
    }

    @Override
    public void run() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "DelayTask{" +
                "delta=" + delta +
                ", trigger=" + trigger +
                ", id=" + id +
                '}';
    }

    public static class EndSentinel extends DelayTask {
        private ExecutorService executorService;

        public EndSentinel(long deltaMilliseconds, ExecutorService e) {
            super(deltaMilliseconds);
            executorService = e;
        }

        public void run() {
            for (DelayTask delayTask : delayTasks) {
                delayTask.printSummary();
            }
            System.out.println("shutDown tasks");
            executorService.shutdownNow();
        }
    }

    private void printSummary() {
        System.out.println(id + " delta = " + delta);
    }

    static class DelayedTaskConsumer implements Runnable {
        private DelayQueue<DelayTask> q;

        public DelayedTaskConsumer(DelayQueue<DelayTask> q) {
            this.q = q;
        }

        @Override
        public void run() {
            while (!Thread.interrupted()){
                try {
                    q.take().run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("DelayedTaskConsumer завершается");
        }

    }

    public static void main(String[] args) {
        Random random = new Random(47);
        ExecutorService executorService = Executors.newCachedThreadPool();
        DelayQueue<DelayTask> queue = new DelayQueue<DelayTask>();
        for (int i = 0; i < 10; i++) {
            queue.put(new DelayTask(random.nextInt(5000)));
        }
        queue.add(new DelayTask.EndSentinel(5000, executorService));
        executorService.execute(new DelayedTaskConsumer(queue));

    }
}

package threading.addedLibrary.cyclicBarrier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Ivan.Ryazanov on 08.06.2016.
 */
public class Horse implements Runnable {
    private CyclicBarrier barrier;
    private static int counter = 1;
    private final int id = counter++;
    List<Integer> list = new ArrayList<Integer>();
    private int aggSpeed;


    @Override
    public String toString() {
        return "Horse{" +
                "barrier=" + barrier +
                ", id=" + id +
                ", position=" + position +
                ", random=" + random +
                '}';
    }

    public int getPosition() {
        return position;
    }

    private int position = 0;
    private Random  random = new Random();


    public Horse(CyclicBarrier barrier){
        this.barrier = barrier;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            try {
                move();
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }

    }

    public List<Integer> getPositionList() {
        return list;
    }

    public void move(){
        position += random.nextInt(2);
        list.add(position);
    }

    public static void main(String[] args) {
        final int finish = 100;
        final int countHorse = 10;
        final List<Horse> horses = new ArrayList<Horse>();
        final ExecutorService executorService = Executors.newCachedThreadPool();
        CyclicBarrier barrier = new CyclicBarrier(countHorse, new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < finish; i++) {
                    System.out.print("=");
                }
                System.out.println();
                for (Horse horse : horses) {
                    horse.printPosition();
                    if (horse.getPosition() >= finish) {
                        System.out.println(" winner is " + horse);
                        executorService.shutdownNow();
                    }
                }
            }
        });
        for (int i = 0; i < countHorse; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            executorService.execute(horse);
        }
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            for (Horse horse : horses) {
                System.out.println(horse +  " " + horse.getAggSpeed());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printPosition() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("№").append(" ").append(id);
        int maxDigitCounter = counter/10;
        int currentDigitCounter = id / 10;
        for (int i = 0; i < (maxDigitCounter + 1 - currentDigitCounter); i++) {
            stringBuilder.append(" ");
        }
        for (int i = 0; i < getPosition(); i++) {
            stringBuilder.append("*");
        }
        System.out.println(stringBuilder.toString());
    }

    public int getAggSpeed() {
        Integer avg = 0;
        for (Integer speed : list) {
            avg += speed;
        }
        avg = avg / list.size();
        return avg;
    }
}

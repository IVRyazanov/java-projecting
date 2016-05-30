package threading.concurrency.criticSection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Иван on 30.05.2016.
 */

class Pair {
    private int x, y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Pair(){
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX(){ x++; }
    public void incrementY(){ y++; }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public class PairValuesNotEqualException extends RuntimeException{
        public PairValuesNotEqualException() {
            super(Pair.this + " not eqauls");
        }
    }

    public void checkState(){
        if(x != y){
            throw new PairValuesNotEqualException();
        }
    }
}


public class CriticalSection {
    static void testApproaches(PairManager pman1, PairManager pman2){
        ExecutorService exec = Executors.newCachedThreadPool();
        PairManipulator pm1 = new PairManipulator(pman1);
        PairManipulator pm2 = new PairManipulator(pman2);
        PairChecker pcheck1 = new PairChecker(pman1);
        PairChecker pcheck2 = new PairChecker(pman2);

        exec.execute(pm1);
        exec.execute(pm2);
        exec.execute(pcheck1);
        exec.execute(pcheck2);

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("pm = " + pm1 + "\npm2 =" + pm2);
        System.exit(0);
    }

    public static void main(String args[]){
        PairManager pman1 = new PairManager1();
        PairManager pman2 = new PairManager2();

        testApproaches(pman1, pman2);
    }
}

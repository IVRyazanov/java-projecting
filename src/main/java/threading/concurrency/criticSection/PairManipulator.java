package threading.concurrency.criticSection;

/**
 * Created by Иван on 30.05.2016.
 */
public class PairManipulator implements Runnable{
    private PairManager pm;
    public PairManipulator(PairManager pm){
        this.pm = pm;
    }

    public void run() {
        while (true){
            pm.increment();
        }
    }

    @Override
    public String toString() {
        return "PairManipulator{" +
                "Pair=" + pm.getPair() + " checkCounter = " + pm.checkCounter.get() +
                '}' + pm.getStorage()
                ;
    }
}

class PairChecker implements Runnable{
    private PairManager pm;
    public PairChecker(PairManager pm){
        this.pm = pm;
    }

    public void run() {
        while (true){
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}

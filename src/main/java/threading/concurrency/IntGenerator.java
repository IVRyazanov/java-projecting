package threading.concurrency;

/**
 * Created by Иван on 29.05.2016.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel() {
        canceled = true;
    }
    public boolean isCanceled(){
        return canceled;
    }
}

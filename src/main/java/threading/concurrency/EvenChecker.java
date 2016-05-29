package threading.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Иван on 29.05.2016.
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;
    public EvenChecker(IntGenerator intGenerator, int ident){
        this.generator = intGenerator;
        id = ident;
    }

    public void run() {
        int val = 0;
        while (!generator.isCanceled()){
            val = generator.next();
            if(val % 2 != 0){
                System.out.println(val + " не четно");
                generator.cancel();
            } else
                System.out.println(val + " четно");
        }

    }

    public static void test(IntGenerator intGenerator, int count){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            executorService.execute(new EvenChecker(intGenerator, i));
        }
        executorService.shutdown();

    }

    public static void test(IntGenerator intGenerator){
        test(intGenerator, 10);
    }


}

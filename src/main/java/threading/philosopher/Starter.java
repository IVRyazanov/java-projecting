package threading.philosopher;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Иван on 06.06.2016.
 */
public class Starter {

    /**
     * Параметры
     * 1- количество философов
     * 2 - множитель задержки
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        int philosopherCount = 0;
        int pause = 1;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        List<String> paramList = new ArrayList<String>();
        System.out.println("Введите количество философов, а затем множитель паузы");
        while (paramList.size() < 2 && !(line = bufferedReader.readLine()).equalsIgnoreCase("exit") ){
            paramList.add(line);
        }
        philosopherCount = Integer.parseInt(paramList.get(0));
        pause = Integer.parseInt(paramList.get(1));
        System.out.println("count of philosophers = " + philosopherCount);
        System.out.println("pause value = " + pause);

        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Flatware> flatwareList = createRandomList(philosopherCount);
        for (int i = 0; i < philosopherCount; i++) {
            if(i != (philosopherCount-1))
                executorService.execute(new Philosopher(flatwareList.get(i), flatwareList.get(i+1), pause));
            else
                executorService.execute(new Philosopher(flatwareList.get(0), flatwareList.get(i), pause));
        }
    }

    static List<Flatware> createRandomList(int philosopherCount){
        List<Flatware> flatwareList = new ArrayList<Flatware>();
        boolean fork = true;
        for (int i = 0; i < philosopherCount; i++) {
            Flatware flatware = (fork) ? new Spoon() : new Fork();
            flatwareList.add(flatware);
            fork = !fork;
        }
        System.out.println("flatware list = " + flatwareList);
        return flatwareList;

    }
}

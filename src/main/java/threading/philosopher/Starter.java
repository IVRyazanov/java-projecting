package threading.philosopher;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
        while (paramList.size() < 2 && !(line = bufferedReader.readLine()).equalsIgnoreCase("exit") ){
            paramList.add(line);
        }
        System.out.println(paramList);
        philosopherCount = Integer.parseInt(paramList.get(0));
        pause = Integer.parseInt(paramList.get(1));
        System.out.println("count of philosophers = " + philosopherCount);
        System.out.println("pause value = " + pause);
    }
}

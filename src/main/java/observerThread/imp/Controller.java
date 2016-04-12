package observerThread.imp;


import observerThread.MboObject;
import observerThread.Observable;
import observerThread.Observer;

import java.util.*;

/**
 * Created by Ivan.Ryazanov on 11.04.2016.
 */
public class Controller implements Observable {
    private final int THREAD_COUNT = 10;
    private LinkedHashMap<MboObject, Boolean> mboMap = new LinkedHashMap<MboObject, Boolean>();
    private Iterator<Map.Entry<MboObject, Boolean>> entry;
    private List<Observer> observerList = new ArrayList<Observer>(THREAD_COUNT);

    public Controller() {
        generateMap();
        entry = mboMap.entrySet().iterator();
    }



    public Iterator<Map.Entry<MboObject, Boolean>> getEntry() {
        return entry;
    }

    public List<Observer> getList() {
        return observerList;
    }

    private void generateMap() {
        List<MboObject> mboList = Reader.getMboList();
        for (MboObject mbo : mboList) {
            mboMap.put(mbo, false);
        }
    }

    public class ThreadPusher implements Runnable {
        Iterator<Map.Entry<MboObject, Boolean>> entry = getEntry();
        @Override
        public void run() {
            int i = 0;
            while (THREAD_COUNT > i++){
                System.out.println(Thread.currentThread().getId() + " создает поток");
                if(entry.hasNext()){
                    Worker workerObj = new Worker(Controller.this, entry.next().getKey());
                    Thread workerThread = new Thread(workerObj);
                    registerObserver(workerObj);
                    workerThread.start();
                }
            }
        }
    }


    public static void main(String[] args) {
        Controller controller = new Controller();
//        System.out.println(controller.getEntry().next().getKey().getMboNum());
//        System.out.println(controller.mboMap.get(new MboObject("147229034", "76")));
        ThreadPusher threadPusher = controller.new ThreadPusher();
        Thread thread = new Thread(threadPusher);
        thread.start();

    }


    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver(Observer observer) {
        if(entry.hasNext()){
            observer.update(entry.next().getKey());
            ((Runnable)observer).run();
        }
    }
}

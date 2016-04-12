package observerThread.imp;


import observerThread.MboObject;
import observerThread.Observable;
import observerThread.Observer;
import org.apache.log4j.Logger;

import java.util.*;


/**
 * Created by Ivan.Ryazanov on 11.04.2016.
 */
public class Controller implements Observable {
    final static Logger log = Logger.getLogger(Controller.class);
    private final int THREAD_COUNT = 10;
    private LinkedHashMap<MboObject, Boolean> mboMap = new LinkedHashMap<MboObject, Boolean>();
    private Iterator<Map.Entry<MboObject, Boolean>> entry;
    private List<Thread> observerList = new ArrayList<Thread>(THREAD_COUNT);

    public Controller() {
        generateMap();
        entry = mboMap.entrySet().iterator();
    }

    public void readMap(){
        for (Map.Entry<MboObject, Boolean> entry : mboMap.entrySet()) {
            // если текущая итерация контейнера кратна кол-ву записей для нити, то создаем и передаем туда лист MboObject
            log.info(entry.getKey());
            }
        }



    public Iterator<Map.Entry<MboObject, Boolean>> getEntry() {
        return entry;
    }

    public List<Thread> getList() {
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
        private int mboMapSize = mboMap.size();
        private int mboCountForThread = mboMapSize / (THREAD_COUNT - 1);

        @Override
        public void run() {
            int i = 0;
            List<MboObject> objectListForThread = new ArrayList<MboObject>();
            for (Map.Entry<MboObject, Boolean> entry : mboMap.entrySet()) {
                // если текущая итерация контейнера кратна кол-ву записей для нити, то создаем и передаем туда лист MboObject
                objectListForThread.add(entry.getKey());
                if (i++ % mboCountForThread == 0) {
                    createThread(objectListForThread);
                }
            }
            // записываем остаток
            createThread(objectListForThread);
            for (Thread thread : getList()) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void createThread(List<MboObject> objectListForThread) {
        Worker workerObj = new Worker(Controller.this, new ArrayList<MboObject>(objectListForThread));
        Thread workerThread = new Thread(workerObj);
        registerObserver(workerThread);
        workerThread.start();
        objectListForThread.clear();
    }


    public static void main(String[] args) throws InterruptedException {
        long start = new Date().getTime();
        log.debug("Начало =" + start);
        Controller controller = new Controller();
//        System.out.println(controller.getEntry().next().getKey().getMboNum());
//        System.out.println(controller.mboMap.get(new MboObject("147229034", "76")));
        ThreadPusher threadPusher = controller.new ThreadPusher();
        Thread thread = new Thread(threadPusher);
        thread.start();
        thread.join();
        log.debug(Worker.getUpdatedRows());
        long end = new Date().getTime();
        log.debug("Окончание =" + start);
        log.debug("Время выполнения =" + (end - start));


    }


    @Override
    public void registerObserver(Thread observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver(Observer observer) {
//        if(entry.hasNext()){
//            observer.update(entry.next().getKey());
//            ((Runnable)observer).run();
//        }
    }
}

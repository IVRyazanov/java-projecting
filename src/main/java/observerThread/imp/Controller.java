package observerThread.imp;


import observerThread.MboObject;
import observerThread.Observable;
import observerThread.Observer;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.*;


/**
 * Created by Ivan.Ryazanov on 11.04.2016.
 */
public class Controller implements Observable {
    final static Logger log = Logger.getLogger(Controller.class);
    FileWorker fileWorker;
    Class<? extends Worker> typeOfWorker;
    final static SessionController sessionController = new SessionController();


    public SessionController getSessionController() {
        return sessionController;
    }

    public void setTypeOfWorker(Class<? extends Worker> typeOfWorker) {
        this.typeOfWorker = typeOfWorker;
    }


    private int threadCount = 5;

    public void setThreadCount(int threadCount) {
        int uiCount = sessionController.getUiCount();
        int rowCount = fileWorker.getMboCount();
        threadCount = (threadCount > uiCount) ? uiCount : threadCount;
        threadCount = (rowCount > threadCount) ? threadCount : rowCount/5;
        this.threadCount = threadCount;
    }

    public void setFileWorker(FileWorker fileWorker) {
        this.fileWorker = fileWorker;
    }

    private LinkedHashMap<MboObject, Boolean> mboMap = new LinkedHashMap<MboObject, Boolean>();
    private Iterator<Map.Entry<MboObject, Boolean>> entry;
    private List<Thread> observerList = new ArrayList<Thread>(threadCount);

    public Controller() throws Exception {
        fileWorker = new FileWorker();
        generateMap();
        entry = mboMap.entrySet().iterator();
    }

    public static void setPathToUpdate(String pathToUpdate) {
        FileWorker.setPathToUpdate(pathToUpdate);
    }

    public static void setPathToError(String pathToError) {
        FileWorker.setPathToError(pathToError);
    }

    public void readMap(){
        for (Map.Entry<MboObject, Boolean> entry : mboMap.entrySet()) {
            // если текущая итерация контейнера кратна кол-ву записей для нити, то создаем и передаем туда лист MboObject
            log.info(entry.getKey());
            }
        }

    public int getUpdatedRow(){
        return Worker.getUpdatedRows();
    }


    public Iterator<Map.Entry<MboObject, Boolean>> getEntry() {
        return entry;
    }

    public List<Thread> getList() {
        return observerList;
    }

    private void generateMap() {
        List<MboObject> mboList = FileWorker.getMboList();
        for (MboObject mbo : mboList) {
            mboMap.put(mbo, false);
        }
    }

    public class ThreadPusher implements Runnable {
        Iterator<Map.Entry<MboObject, Boolean>> entry = getEntry();
        private int mboMapSize = mboMap.size();
        private int mboCountForThread = mboMapSize / (threadCount - 1);

        @Override
        public void run() {
            int i = 0;
            List<MboObject> objectListForThread = new ArrayList<MboObject>();
            for (Map.Entry<MboObject, Boolean> entry : mboMap.entrySet()) {
                // если текущая итерация контейнера кратна кол-ву записей для нити, то создаем и передаем туда лист MboObject
                objectListForThread.add(entry.getKey());
                if (i++ % mboCountForThread == 0) {
                    try {
                        createThread(objectListForThread);
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }
            // записываем остаток
            try {
                createThread(objectListForThread);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            for (Thread thread : getList()) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void createThread(List<MboObject> objectListForThread) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Class<? extends FileWorker> workObj = fileWorker.getClass();
//        Worker workerObj = new Worker(Controller.this, new ArrayList<MboObject>(objectListForThread));
        Worker workerObj = (Worker) typeOfWorker.getConstructor(new Class[]{Observable.class, List.class}).newInstance(this, new ArrayList<MboObject>(objectListForThread));
        Thread workerThread = new Thread(workerObj);
        registerObserver(workerThread);
        workerThread.start();
        objectListForThread.clear();
    }



    public static void main(String[] args) throws Exception {
        long start = new Date().getTime();
        log.debug("Начало =" + start);
        Controller.setPathToUpdate("src/main/resources/63-83.dsv");
        Controller.setPathToError("src/main/resources/not_completed.txt");
        Controller controller = new Controller();
//        System.out.println(controller.getEntry().next().getKey().getMboNum());
//        System.out.println(controller.mboMap.get(new MboObject("147229034", "76")));
        controller.setTypeOfWorker(Worker.class);
        controller.setThreadCount(500);
        ThreadPusher threadPusher = controller.new ThreadPusher();
        Thread thread = new Thread(threadPusher);
        thread.start();
        thread.join();
        log.debug(Worker.getUpdatedRows());
        long end = new Date().getTime();
        FileWorker.closeWriter();
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

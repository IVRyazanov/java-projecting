package observerThread.imp;

import observerThread.MboObject;
import observerThread.Observable;
import observerThread.Observer;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Ivan.Ryazanov on 11.04.2016.
 */
public class Worker implements Observer, Runnable {
    protected final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Controller.class);
    protected static int updatedRows = 0;
    protected List<MboObject> listMbos;
    protected Observable controller;
    protected Map.Entry<String, String> session; // ui , ip



    public Worker(Observable observable, List<MboObject> listMbos) {
        this.controller = observable;
        Iterator<Map.Entry<String, String>> sessionControllerIterator = ((Controller)controller).getSessionController().iterator();
        session = sessionControllerIterator.next();
        setListMbos(listMbos);
    }

    public static int getUpdatedRows() {
        return updatedRows;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "controller=" + controller +
                ", listMbos=" + listMbos +
               ", session='" + session + '\'' +
                '}';
    }


    public void setListMbos(List<MboObject> listMbos) {
        this.listMbos = listMbos;
    }

    @Override
    public void update() {
        for (MboObject mboObject : listMbos) {
            log.debug(this + " update " + mboObject);
            updatedRows++;
            if(updatedRows%5 == 0){
                try {
                    FileWorker.writeInFile(mboObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run() {
        update();
    }
}

package observerThread.imp;

import observerThread.MboObject;
import observerThread.Observable;
import observerThread.Observer;

import java.util.List;

/**
 * Created by Ivan.Ryazanov on 11.04.2016.
 */
public class Worker implements Observer, Runnable {
    final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Controller.class);
    private static int updatedRows = 0;
    private List<MboObject> listMbos;
    private Observable controller;

    public Worker(Observable observable, List<MboObject> listMbos) {
        setListMbos(listMbos);
    }

    public static int getUpdatedRows() {
        return updatedRows;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "поток =" + Thread.currentThread().getId() +
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
        }
    }

    @Override
    public void run() {
        log.debug("ПОТОК " + this + " начинает обрабатывать" + listMbos);
        update();
        log.debug("ПОТОК " + this + " обработал" + listMbos);
    }
}

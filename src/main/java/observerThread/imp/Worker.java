package observerThread.imp;

import observerThread.MboObject;
import observerThread.Observable;
import observerThread.Observer;

import java.util.List;

/**
 * Created by Ivan.Ryazanov on 11.04.2016.
 */
public class Worker implements Observer, Runnable {
    private List<MboObject> listMbos;
    private Observable controller;
    public Worker(Observable observable, List<MboObject> listMbos) {
        setListMbos(listMbos);
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
    public void update(List<MboObject> listMbos) {
        setListMbos(listMbos);
    }

    @Override
    public void run() {
        System.out.println("ПОТОК " + this + " начинает обрабатывать" + listMbos);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        controller.notifyObserver(this);
        System.out.println("ПОТОК " + this + " обработал" + listMbos);

    }
}

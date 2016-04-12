package observerThread.imp;

import observerThread.MboObject;
import observerThread.Observable;
import observerThread.Observer;

/**
 * Created by Ivan.Ryazanov on 11.04.2016.
 */
public class Worker implements Observer, Runnable {
    private Observable controller;
    public Worker(Observable observable, MboObject mboObject) {
        this.mboObject = mboObject;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "поток =" + Thread.currentThread().getId() +
                '}';
    }

    private MboObject mboObject;

    public MboObject getMboObject() {
        return mboObject;
    }

    public void setMboObject(MboObject mboObject) {
        this.mboObject = mboObject;
    }

    @Override
    public void update(MboObject mboObject) {
        setMboObject(mboObject);
    }

    @Override
    public void run() {
        System.out.println("ПОТОК " + this + " начинает обрабатывать" + mboObject);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        controller.notifyObserver(this);
        System.out.println("ПОТОК " + this + " обработал" + mboObject);

    }
}

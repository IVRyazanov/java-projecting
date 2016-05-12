package hibernate;

import hibernate.model.Bus;
import hibernate.model.impl.BusDAOImpl;

import java.sql.SQLException;

/**
 * Created by Иван on 12.05.2016.
 */
public class Creator {
    public static void main(String[] args) throws Exception {
        Bus bus = new Bus();
        bus.setNumber("12321");
        BusDAOImpl busDAO = new BusDAOImpl();
        busDAO.addBus(bus);
    }
}

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
        System.out.println(busDAO.getAllBusses());

        busDAO.addBus(new Bus("aa11s"));
        busDAO.addBus(new Bus("aas23123222"));
        busDAO.addBus(new Bus("aa12321321s2233"));
        busDAO.addBus(new Bus("aaa"));
    }
}

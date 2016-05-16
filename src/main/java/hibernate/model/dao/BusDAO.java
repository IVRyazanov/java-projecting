package hibernate.model.dao;

import hibernate.model.Bus;
import hibernate.model.Driver;
import hibernate.model.Route;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Иван on 12.05.2016.
 */
public interface BusDAO {
    void addBus(Bus bus) throws Exception;
    void updateBus(Long bus_id, Bus bus) throws SQLException;
    Bus getBusById(Long bus_id) throws SQLException;
    Collection<Bus> getAllBusses() throws SQLException;
    void deleteBus(Bus bus) throws SQLException;
    Collection<Bus> getBussesByDriver(Driver driver) throws SQLException;
    Collection<Bus> getBussesByRoute(Route route) throws SQLException;
}

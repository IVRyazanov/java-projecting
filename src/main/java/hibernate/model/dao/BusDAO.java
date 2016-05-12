package hibernate.model.dao;

import hibernate.model.Bus;
import hibernate.model.Driver;
import hibernate.model.Route;
import org.hibernate.mapping.Collection;

import java.sql.SQLException;

/**
 * Created by Иван on 12.05.2016.
 */
public interface BusDAO {
    void addBus(Bus bus) throws Exception;
    void updateBus(Long bus_id, Bus bus) throws SQLException;
    Bus getBusById(Long bus_id) throws SQLException;
    Collection getAllBusses() throws SQLException;
    void deleteBus(Bus bus) throws SQLException;
    Collection getBussesByDriver(Driver driver) throws SQLException;
    Collection getBussesByRoute(Route route) throws SQLException;
}

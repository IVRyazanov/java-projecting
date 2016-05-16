package hibernate.model.impl;

import hibernate.HibernateUtil;
import hibernate.model.Bus;
import hibernate.model.Driver;
import hibernate.model.Route;
import hibernate.model.dao.BusDAO;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Иван on 12.05.2016.
 */
public class BusDAOImpl implements BusDAO {

    @Override
    public void addBus(Bus bus) throws Exception {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(bus);
            session.getTransaction().commit();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
            throw e;
        }
    }

    @Override
    public void updateBus(Long bus_id, Bus bus) throws SQLException {

    }

    @Override
    public Bus getBusById(Long bus_id) throws SQLException {
        return null;
    }

    public Collection<Bus> getAllBusses() throws SQLException {
        Session session = null;
        List<Bus> busses = new ArrayList<Bus>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            busses = session.createCriteria(Bus.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return busses;
    }

    @Override
    public void deleteBus(Bus bus) throws SQLException {

    }

    @Override
    public Collection getBussesByDriver(Driver driver) throws SQLException {
        return null;
    }

    @Override
    public Collection getBussesByRoute(Route route) throws SQLException {
        return null;
    }
}

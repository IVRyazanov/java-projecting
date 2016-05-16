package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Иван on 12.05.2016.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = createFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static SessionFactory createFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable throwable) {
            System.err.println("Unable to create session");
            throw new ExceptionInInitializerError(throwable);
        }
    }


}


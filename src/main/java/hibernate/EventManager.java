package hibernate;

import hibernate.domain.Event;
import hibernate.domain.Person;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

/**
 * Created by Ivan.Ryazanov on 16.05.2016.
 */
public class EventManager {
    public static void main(String[] args) {
        EventManager mgr = new EventManager();
        
        if(args[0].equalsIgnoreCase("store")){
            mgr.createAndStoreEvent("My Event", new Date());
        }
        if(args[1].equalsIgnoreCase("list")){
            List<Event> events = mgr.listEvents();
            for(int i = 0; i < events.size(); i++){
                Event theEvent = events.get(i);
                System.out.println(
                        "Event: " + theEvent.getTitle() + " Time: " + theEvent.getDate()
                );
            }
        }
        HibernateUtil.getSessionFactory().close();
    }

    private List<Event> listEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Event> result = session.createQuery("from Event").list();
        session.getTransaction().commit();
        return result;
    }

    private void createAndStoreEvent(String title, Date theDate) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        session.save(theEvent);
        session.getTransaction().commit();
    }

    private void addPersonToEvent(Long personid, Long eventid){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Person aPerson = session.load(Person.class, personid);
        Event anEvent = session.load(Event.class, eventid);
        aPerson.getEvents().add(anEvent);
        session.getTransaction().commit();
    }

}

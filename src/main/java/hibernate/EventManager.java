package hibernate;

import hibernate.domain.Event;
import hibernate.domain.Person;
import org.hibernate.Session;

import java.util.*;

/**
 * Created by Ivan.Ryazanov on 16.05.2016.
 */
public class EventManager {
    public static void main(String[] args) {
        EventManager mgr = new EventManager();
        List<String> stringList = Arrays.asList(args);
        System.out.println("app parameters = "  + stringList);
        if(stringList.contains("addEvent")){
            mgr.createAndStoreEvent("My Event", new Date());
        }
        if(stringList.contains("listEvent")){
            List<Event> events = mgr.listEvents();
            for(int i = 0; i < events.size(); i++){
                Event theEvent = events.get(i);
                System.out.println(
                        "Event: " + theEvent.getTitle() + " Time: " + theEvent.getDate()
                );
            }
        }
        if(stringList.contains("listPerson")){
            List<Person> persons = mgr.listPerson();
            for(Person person : persons){
                System.out.println(person);
            }
        }
        if(stringList.contains("addPersonToEvent")){
            Long eventId = mgr.createAndStoreEvent("New event", new Date());
            Long personId = mgr.createAndStorePerson("Ivan", "Ivanov", 20);
            mgr.addPersonToEvent(personId, eventId);
        }
        HibernateUtil.getSessionFactory().close();
    }

    private List<Person> listPerson() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Person> result = session.createQuery("from Person").list();
        session.getTransaction().commit();
        return result;
    }

    private List<Event> listEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Event> result = session.createQuery("from Event").list();
        session.getTransaction().commit();
        return result;
    }

    private Long createAndStoreEvent(String title, Date theDate) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        session.save(theEvent);
        session.getTransaction().commit();
        return theEvent.getId();
    }

    private Long createAndStorePerson(String firstname, String lastname, int age){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Person person = new Person();
        person.setAge(age);
        person.setFirstname(firstname);
        person.setLastname(lastname);
        session.save(person);
        session.getTransaction().commit();
        addEmailToPerson(person.getId(), "lolipop@mail.ru");
        return person.getId();
    }

    private void addPersonToEvent(Long personid, Long eventid){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Person aPerson = session.load(Person.class, personid);
        Event anEvent = session.load(Event.class, eventid);
        aPerson.getEvents().add(anEvent);
        session.getTransaction().commit();
    }

    private String addEmailToPerson(Long personId, String email){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Person person = session.load(Person.class, personId);
        person.getEmail().add(email);
        session.getTransaction().commit();
        for(String element : person.getEmail()){
            return element;
        }
        return null;
    }

}

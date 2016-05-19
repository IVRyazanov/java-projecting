package hibernate;

import hibernate.domain.Event;
import hibernate.domain.Person;
import org.hibernate.Session;

import java.util.*;

/**
 * Created by Ivan.Ryazanov on 16.05.2016.
 */
public class EventManager {
    /*
     параметры запуска:
      "addEvent" "listEvent" "listPerson" "addEventToPerson" "addPersonToEvent"
      */
    public static void main(String[] args) {
        EventManager mgr = new EventManager();
        List<String> stringList = Arrays.asList(args);
        System.out.println("app parameters = "  + stringList);
//        if(stringList.contains("addEvent")){
//            mgr.createAndStoreEvent("My Event", new Date());
//        }
        if(stringList.contains("addEventToPerson")){
            Long eventId = mgr.createAndStoreEvent("New event", new Date());
            Long personId = mgr.createAndStorePerson("Ivan", "Ivanov", 20);
            mgr.addEventToPerson(personId, eventId);
        }
        if(stringList.contains("addPersonToEvent")){
            Long eventId = mgr.createAndStoreEvent("Новое событие, ожидающее привязки пользвателя", new Date());
            Long personId = mgr.createAndStorePerson("Привяз", "Привязыч", 99);
            mgr.addPersonToEvent(eventId, personId);
            mgr.personEventList();
        }
        if(stringList.contains("listPerson")){
            mgr.listPerson();
        }
        if(stringList.contains("listEvent")){
            mgr.listEvents();

        }
        HibernateUtil.getSessionFactory().close();
    }

    private void personEventList() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Person> result = session.createQuery("from Person").list();
        System.out.println("PERSON_EVENT--------");
        for(Person person: result){
            System.out.println(person + " have  this events: " );
            for(Event event :  person.getEvents())
            {
                System.out.print(event);
            }
        }
        System.out.println("PERSON_EVENT--------");
        session.getTransaction().commit();

    }

    private List<Person> listPerson() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Person> result = session.createQuery("from Person").list();
        System.out.println("СПИСОК СОТРУДНИКОВ-----------");
        for (Person person : result){
            System.out.println(person);
        }
        System.out.println("СПИСОК СОТРУДНИКОВ-----------");
        session.getTransaction().commit();
        return result;
    }

    private List<Event> listEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Event> result = session.createQuery("from Event").list();
        for(Event event : result)
            System.out.println(event);
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

    private void addEventToPerson(Long personid, Long eventid){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Person aPerson = session.load(Person.class, personid);
        Event anEvent = session.load(Event.class, eventid);
        aPerson.getEvents().add(anEvent);
        anEvent.getParticipants().add(aPerson);
        session.getTransaction().commit();
    }

    private void addPersonToEvent(Long eventid, Long personid){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Event event = session.load(Event.class, eventid);
        Person person = session.load(Person.class, personid);
        event.getParticipants().add(person);
        person.getEvents().add(event);
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

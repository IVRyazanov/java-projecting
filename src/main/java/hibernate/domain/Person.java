package hibernate.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ivan.Ryazanov on 17.05.2016.
 */
public class Person {
    private Long id;
    private int age;
    private String firstname;
    private String lastname;
    private Set<Event> events = new HashSet<Event>();
    private Set<String> email = new HashSet<String>();

    public Set<String> getEmail() {
        return email;
    }

    public void setEmail(Set<String> email) {
        this.email = email;
    }

    public Set<Event> getEvents() {
        return events;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", events=" + events +
                '}';
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }


    public Person(){}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}

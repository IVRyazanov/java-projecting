package hibernate.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ivan.Ryazanov on 16.05.2016.
 */
public class Event {
    private Long id;
    private String title;
    private Date date;
    private Set<Person> participants = new HashSet<Person>();

    @Override
    public String toString() {
        return "Event{" +
                "date=" + date +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", participants="  + printParticipants() +
                '}';
    }

    private String printParticipants() {
        String str = "";
        for(Person person : participants){
            str += (person.getFirstname() + " " + person.getLastname());
        }
        return str;
    }

    public Event() {
    }

    public Set<Person> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Person> participants) {
        this.participants = participants;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
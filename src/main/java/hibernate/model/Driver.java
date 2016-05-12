package hibernate.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Иван on 11.05.2016.
 */
@Entity
@Table(name = "Driver")
public class Driver {
    @Id
    @Column(name="driver_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;
    private Craft craft;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="age")
    private int age;
    private Set<Bus> busses = new HashSet<Bus>();

    public Driver() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Craft getCraft() {
        return craft;
    }

    public void setCraft(Craft craft) {
        this.craft = craft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set getBusses() {
        return busses;
    }

    public void setBusses(Set busses) {
        this.busses = busses;
    }
}

package hibernate.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Иван on 11.05.2016.
 */
@Entity
@Table(name = "Routes")
public class Route {
    @Id
    @Column(name="route_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="number")
    private int number;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Routes")
    private Set<Bus> busses = new HashSet<Bus>();

    public Route() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBusses(Set busses) {
        this.busses = busses;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public Set getBusses() {
        return busses;
    }
}

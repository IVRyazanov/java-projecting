package hibernate.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Иван on 11.05.2016.
 */
@Entity
@Table(name = "Busses")
public class Bus {
    @Id
    @Column(name="bus_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;
    @Column(name="number")
    private String number;
    private Set<Driver> drivers = new HashSet<Driver>();
    @Column(name="route_id")
    private Long route_id;

    public Bus() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set getDrivers() {
        return drivers;
    }

    public void setDrivers(Set drivers) {
        this.drivers = drivers;
    }

    public Long getRoute_id() {
        return route_id;
    }

    public void setRoute_id(Long route_id) {
        this.route_id = route_id;
    }
}

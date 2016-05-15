package hibernate.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Иван on 11.05.2016.
 */
@Entity(name = "Busses")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "bus_id_generator")
    @SequenceGenerator(name = "bus_id_generator", sequenceName = "bus_id")
    @Column(name = "bus_id")
    private Long id;
    private String number;
    private Long route_id;

    public Bus() {
    }

    public Bus(String number) {
        this.number = number;
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


    public Long getRoute_id() {
        return route_id;
    }

    public void setRoute_id(Long route_id) {
        this.route_id = route_id;
    }
}

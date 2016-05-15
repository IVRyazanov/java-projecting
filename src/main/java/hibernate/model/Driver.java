package hibernate.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Иван on 11.05.2016.
 */
@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;
    private String name;
    private String surname;
    private int age;

    public Driver() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


}

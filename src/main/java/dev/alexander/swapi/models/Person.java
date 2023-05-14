package dev.alexander.swapi.models;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;


@Entity
@Data
public class Person {

    @Id
    @GeneratedValue
    private int personId;

    private String name;
    private int height;
    private int mass;
    private String gender;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "person_planet",
               joinColumns = @JoinColumn(name = "person_id"),
               inverseJoinColumns = @JoinColumn(name = "planet_id"))
    private Set<Planet> homeworld = new HashSet<>();



    public void addToPlanet(Planet planet) {
        homeworld.add(planet);
    }
}

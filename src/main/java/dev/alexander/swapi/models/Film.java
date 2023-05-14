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
public class Film {
    
    @Id
    @GeneratedValue
    private int filmId;
    private String name;
    private String release_date;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_planet",
               joinColumns = @JoinColumn(name = "film_id"),
               inverseJoinColumns = @JoinColumn(name = "film_id"))
    private Set<Planet> ffilm = new HashSet<>();
 

    public void addFilmToPlanet(Planet planet) {
        ffilm.add(planet);
    }

}

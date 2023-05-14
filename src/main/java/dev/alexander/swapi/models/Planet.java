package dev.alexander.swapi.models;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Planet {
    
    @Id
    @GeneratedValue
    private int planetId;

    private String name;
    private int rotation_period;
    private int orbital_period;



    @ManyToMany(mappedBy = "homeworld")
    private Set<Person> person = new HashSet<>();
  
  
    @ManyToMany(mappedBy = "ffilm")
    private Set<Film> film = new HashSet<>();
}

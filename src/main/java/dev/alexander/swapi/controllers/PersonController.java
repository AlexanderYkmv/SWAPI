package dev.alexander.swapi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.alexander.swapi.models.Person;
import dev.alexander.swapi.models.Planet;
import dev.alexander.swapi.repository.PersonRepo;
import dev.alexander.swapi.repository.PlanetRepo;

@RestController
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private PlanetRepo planetRepo;

    @PostMapping("")
    public Person postPerson(@RequestBody Person person) {
        return personRepo.save(person);
    }

    @GetMapping("")
    public List<Person> getAllPersons() {
        return (List<Person>) personRepo.findAll();
    }

    @GetMapping("/{personId}")
    public Person getPersonById(@PathVariable Integer personId) {
        return personRepo.findById(personId).get();
    }

    @DeleteMapping("{personId}")
    public void deletePersonById(@PathVariable Integer personId) {
        personRepo.deleteById(personId);
    }

    @PutMapping("/{personId}/planet/{planetId}")
    public Person personToPlanet(@PathVariable int personId, @PathVariable int planetId) {
        Person person = personRepo.findById(personId).get();
        Planet planet = planetRepo.findById(planetId).get();
        person.addToPlanet(planet);
        return personRepo.save(person);
    }
}

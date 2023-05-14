package dev.alexander.swapi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.alexander.swapi.models.Planet;
import dev.alexander.swapi.repository.PlanetRepo;

@RestController
@RequestMapping("/planet")
public class PlanetController {
   
    @Autowired
    private PlanetRepo planetRepo;

    @PostMapping("")
    public Planet postPlanet(@RequestBody Planet planet) {
        return planetRepo.save(planet);
    }

    @GetMapping("")
    public List<Planet> getAllPlanets() {
        return (List<Planet>) planetRepo.findAll();
    }

    @GetMapping("/{planetId}")
    public Planet getPlanetById(@PathVariable Integer planetId) {
        return planetRepo.findById(planetId).get();
    }

    @DeleteMapping("{planetId}")
    public void deletePlanetById(@PathVariable Integer planetId) {
        planetRepo.deleteById(planetId);
    }
}



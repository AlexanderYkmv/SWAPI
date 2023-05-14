package dev.alexander.swapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.alexander.swapi.models.Planet;

@Repository
public interface PlanetRepo extends CrudRepository<Planet, Integer> {}

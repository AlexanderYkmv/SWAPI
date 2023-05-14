package dev.alexander.swapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.alexander.swapi.models.Person;

@Repository
public interface PersonRepo extends CrudRepository<Person, Integer> {}
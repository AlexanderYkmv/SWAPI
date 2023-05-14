package dev.alexander.swapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.alexander.swapi.models.Film;

@Repository
public interface FilmRepo extends CrudRepository<Film, Integer> {}

package dev.alexander.swapi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import dev.alexander.swapi.models.Film;
import dev.alexander.swapi.models.Planet;
import dev.alexander.swapi.repository.FilmRepo;
import dev.alexander.swapi.repository.PlanetRepo;

public class FilmController {
    @Autowired
    private FilmRepo filmRepo;

    @Autowired
    private PlanetRepo planetRepo;

    @PostMapping("")
    public Film postFilm(@RequestBody Film film) {
        return filmRepo.save(film);
    }

    @GetMapping("")
    public List<Film> getAllFilms() {
        return (List<Film>) filmRepo.findAll();
    }

    @GetMapping("/{filmId}")
    public Film getFilmById(@PathVariable Integer filmId) {
        return filmRepo.findById(filmId).get();
    }

    @DeleteMapping("{filmId}")
    public void deleteFilmById(@PathVariable Integer filmId) {
        filmRepo.deleteById(filmId);
    }

    @PutMapping("/{filmId}/planet/{planetId}")
    public Film filmToPlanet(@PathVariable int filmId, @PathVariable int planetId) {
        Film film = filmRepo.findById(filmId).get();
        Planet planet = planetRepo.findById(planetId).get();
        film.addFilmToPlanet(planet);
        return filmRepo.save(film);
    }
}

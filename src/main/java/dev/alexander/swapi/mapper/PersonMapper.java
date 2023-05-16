package dev.alexander.swapi.mapper;

import java.util.HashSet;
import java.util.Set;
import org.springframework.web.bind.annotation.Mapping;
import dev.alexander.swapi.dto.PersonResponse;
import dev.alexander.swapi.models.Film;
import dev.alexander.swapi.models.Person;
import dev.alexander.swapi.models.Planet;

@Mapper
public interface PersonMapper {
    
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "films", ignore = true)
    @Mapping(target = "updated", ignore = true)
  
  


    
    public  PersonResponse responseFromPerson(Person person);

    public static String planetToString(Planet planet){
        if(planet == null) return "unknown";
        return "http://localhost:8080/swapi/planets/" + planet.getId();
    }

    public static Set<String> filmUrlsFromPerson(Set<Film> films){
        Set<String> filmUrls = new HashSet<>();

        for(Film film : films){
            filmUrls.add("http://localhost:8080/swapi/films/" + film.getId());
        }

        return filmUrls;
    }
}
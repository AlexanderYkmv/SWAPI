package dev.alexander.swapi.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import dev.alexander.swapi.models.Film;
import dev.alexander.swapi.models.Person;
import dev.alexander.swapi.repository.FilmRepo;
import dev.alexander.swapi.repository.PersonPagingRepo;
import dev.alexander.swapi.repository.PersonRepo;

@Service
public class PersonService {
  
    @Autowired 
    private PersonRepo repo;
 
    @Autowired 
    private FilmRepo filmRepo;

    @Autowired
    private PersonPagingRepo pagingRepo;


    public Person save(Person person) {
        return repo.save(person);
    }

    public Page<Person> getAll(int currentPage, int pageSize){
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));


    }

    public Person findById(Integer personId){
        Person person = repo.findById(personId).orElseThrow(() -> {
            throw new ObjectNotFoundException("Person Not Found", Person.class.getName(), personId.toString());
        });
        return person;
    }

}
    


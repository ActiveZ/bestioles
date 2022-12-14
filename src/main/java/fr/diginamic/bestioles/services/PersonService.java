package fr.diginamic.bestioles.services;

import fr.diginamic.bestioles.entities.Person;
import fr.diginamic.bestioles.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Integer id) {
        return personRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void createOrUpdate(Person person) {
        personRepository.save(person);
    }

    public void delete(Integer personId) {
        Optional<Person> personToDelete = personRepository.findById(personId);
        personToDelete.ifPresent(person ->personRepository.delete(person));
    }

}

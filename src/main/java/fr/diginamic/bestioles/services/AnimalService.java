package fr.diginamic.bestioles.services;

import fr.diginamic.bestioles.entities.Animal;
import fr.diginamic.bestioles.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public Animal findById(Integer id) {
        Optional<Animal> optAnimal = animalRepository.findById(id);
        return optAnimal.isPresent() ? optAnimal.get() : null;
    }

    public void createOrUpdate(Animal animal) {
        animalRepository.save(animal);
    }

    public void delete (Integer animalId) {
        Optional<Animal> animalToDelete = animalRepository.findById(animalId);
        animalToDelete.ifPresent(animal -> animalRepository.delete(animal));
    }
}

package fr.diginamic.bestioles.repositories;

import fr.diginamic.bestioles.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    Animal findByName(String troll);
}
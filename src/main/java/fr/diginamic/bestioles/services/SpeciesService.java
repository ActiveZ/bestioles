package fr.diginamic.bestioles.services;

import fr.diginamic.bestioles.entities.Species;
import fr.diginamic.bestioles.repositories.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class SpeciesService {
    @Autowired
    private SpeciesRepository speciesRepository;

    public List<Species> findAll() {
        return speciesRepository.findAll();
    }

    public Species findById(Integer id) {
        return speciesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void createOrUpdate(Species species) {
        speciesRepository.save(species);
    }

    public void delete(Integer speciesId) {
        Optional<Species> speciesToDelete = speciesRepository.findById(speciesId);
        speciesToDelete.ifPresent(species -> speciesRepository.delete(species));
    }
}

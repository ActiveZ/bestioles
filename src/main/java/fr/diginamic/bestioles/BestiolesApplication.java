package fr.diginamic.bestioles;

import fr.diginamic.bestioles.repositories.AnimalRepository;
import fr.diginamic.bestioles.repositories.PersonRepository;
import fr.diginamic.bestioles.repositories.SpeciesRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
//@AllArgsConstructor // pas besoin si @Autowired
public class BestiolesApplication implements CommandLineRunner {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private AnimalRepository animalRepository;
	@Autowired
	private SpeciesRepository speciesRepository;

	public static void main(String[] args) {
		SpringApplication.run(BestiolesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		List<Person> personList = personRepository.findAll();
//		personList.forEach(System.out::println);
//
//		List<Animal> animalList = animalRepository.findAll();
//		animalList.forEach(System.out::println);
//
//		List<Species> speciesList = speciesRepository.findAll();
//		speciesList.forEach(System.out::println);
//
//		Animal troll = new Animal();
//		troll.setName("troll");
//		animalRepository.save(troll);
//
//		animalList = animalRepository.findAll();
//		animalList.forEach(System.out::println);
//
//		troll = animalRepository.findByName("troll");
//		System.out.println("troll trouvé = " + troll);
//
//		animalRepository.delete(troll);
//
//		animalList = animalRepository.findAll();
//		animalList.forEach(System.out::println);

	}
}

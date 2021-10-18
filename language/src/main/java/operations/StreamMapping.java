package operations;

import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;

public class StreamMapping {
    private static final Logger LOGGER = LogManager.getLogger(StreamMapping.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        getPersonMappedNames().forEach(LOGGER::info);
        getPersonMappedNames2().forEach(LOGGER::info);
        LOGGER.info("Tall persons count: " + getTallPersonsCount());
    }

    private static List<String> getPersonMappedNames() {
        return PersonRepository.getAllPersons()
                .stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }

    private static List<String> getPersonMappedNames2() {
        return PersonRepository.getAllPersons()
                .stream()
                .collect(mapping(Person::getName, Collectors.toList()));
    }

    private static long getTallPersonsCount() {
        return PersonRepository.getAllPersons()
                .stream()
                .filter(person -> person.getHeight() >= 170)
                .collect(Collectors.counting());
    }
}

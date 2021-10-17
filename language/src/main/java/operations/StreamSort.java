package operations;

import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class StreamSort {
    private static final Logger logger = LogManager.getLogger(StreamSort.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        logger.info("Sort by Name:");
        PersonRepository.getAllPersons().stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(logger::info);

        logger.info("Sort by Height:");
        PersonRepository.getAllPersons().stream()
                .sorted(Comparator.comparing(Person::getHeight))
                .forEach(logger::info);

        logger.info("Reverse Sort by Name:");
        PersonRepository.getAllPersons().stream()
                .sorted(Comparator.comparing(Person::getName).reversed())
                .forEach(logger::info);
    }
}

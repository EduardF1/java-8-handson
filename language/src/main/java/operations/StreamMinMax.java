package operations;

import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamMinMax {
    private static final Logger logger = LogManager.getLogger(StreamMinMax.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        logger.info("Tallest Person: " + getTallestPerson());
        logger.info("Shortest Person: " + getShortestPerson());
        logger.info("Tall persons group: " + getTallestPersons());
    }

    private static Optional<Person> getTallestPerson() {
        return PersonRepository.getAllPersons()
                .stream()
                .max(Comparator.comparing(Person::getHeight));
    }

    private static Optional<Person> getShortestPerson() {
        return PersonRepository.getAllPersons()
                .stream()
                .min(Comparator.comparing(Person::getHeight));
    }

    private static List<Person> getTallestPersons() {
        List<Person> tallestPersons = new ArrayList<>();
        Optional<Person> tallestPerson = getTallestPerson();
        Person person = tallestPerson.isPresent() ? tallestPerson.get() : null;
        if (null != person) {
            tallestPersons = PersonRepository.getAllPersons()
                    .stream()
                    .filter(per -> per.getHeight() == person.getHeight())
                    .collect(Collectors.toList());
        }

        return tallestPersons;
    }
}

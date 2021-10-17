package operations;

import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Optional;
import java.util.function.Predicate;

public class StreamFindAnyFirst {
    private static final Logger logger = LogManager.getLogger(StreamFindAnyFirst.class);

    static Predicate<Person> isPersonTall = person -> person.getHeight() >= 170;
    static Predicate<Person> isPersonMale = person -> person.getGender().equals("Female");

    public static void main(String[] args) {
        BasicConfigurator.configure();

        logger.info("Find any result : " + getFirstTallPersons().orElse(null));
        logger.info("Find First result : " + getFirstWoman().orElse(null));
    }

    private static Optional<Person> getFirstTallPersons() {
        return PersonRepository.getAllPersons()
                .stream()
                .filter(isPersonTall)
                .findAny();
    }

    private static Optional<Person> getFirstWoman(){
        return PersonRepository.getAllPersons()
                .stream()
                .filter(isPersonMale)
                .findAny();
    }
}

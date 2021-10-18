package function.predicate;

import function.dto.Person;
import function.repository.PersonRepository;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonPredicate {
    private static final Logger LOGGER = LogManager.getLogger(PersonPredicate.class);

    private static final Predicate<Person> isHeightGreaterThan140 = person -> person.getHeight() >= 140;
    private static final Predicate<Person> isGenderMale = person -> person.getGender().equals("Male");

    public static void main(String[] args) {
        BasicConfigurator.configure();

        PersonRepository.getAllPersons()
                .stream()
                .filter(isHeightGreaterThan140.and(isGenderMale))
                .collect(Collectors.toList())
                .forEach(person -> LOGGER.info(person.toString()));
    }
}

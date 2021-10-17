package function.predicate;

import function.dto.Person;
import function.repository.PersonRepository;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonPredicate {
    private static final Logger logger = LogManager.getLogger(PersonPredicate.class);

    static Predicate<Person> isHeightGreaterThan140 = person -> person.getHeight() >= 140;
    static Predicate<Person> isGenderMale = person -> person.getGender().equals("Male");

    public static void main(String[] args) {
        BasicConfigurator.configure();

        PersonRepository.getAllPersons()
                .stream()
                .filter(isHeightGreaterThan140.and(isGenderMale))
                .collect(Collectors.toList())
                .forEach(person -> logger.info(person.toString()));
    }
}

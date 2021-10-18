package streams;

import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleStream {
    private static final Logger LOGGER = LogManager.getLogger(SimpleStream.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        Stream<Integer> streamOne = Stream.of(1, 2, 3, 4, 5, 6);
        streamOne.forEach(LOGGER::info);

        Predicate<Person> predicateOne = (person -> person.getHeight() >= 170);
        Predicate<Person> predicateTwo = (person -> person.getGender().equals("Male"));


        Map<String, List<String>> personMap = PersonRepository
                .getAllPersons()            // iterate all persons
                .stream()                   // stream of persons
                .filter(predicateOne)       //  filter based on predicate (test)
                .filter(predicateTwo)
                .collect(Collectors.toMap(Person::getName, Person::getHobbies));
        LOGGER.info("Person Map :" + personMap);

        List<String> personHobbies = PersonRepository
                .getAllPersons()                // List of Persons
                .stream()                       // Stream of Persons
                .map(Person :: getHobbies)      // Stream<List<String>>
                .flatMap(List::stream)          // Stream<String>
                .distinct()                     // Filter against duplicates
                .collect(Collectors.toList());  // Collection to be returned

        LOGGER.info(personHobbies);
    }
}

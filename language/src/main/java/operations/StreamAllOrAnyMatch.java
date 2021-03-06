package operations;

import function.dto.Person;
import function.repository.PersonRepository;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamAllOrAnyMatch {
    private static final Logger LOGGER = LogManager.getLogger(StreamAllOrAnyMatch.class);
    private static final List<String> fruits = Arrays.asList("Avocado", "Banana", "Mango", "Pineapple");

    private static final Predicate<String> isElementNameLengthGreaterThan2 = fruit -> fruit.length() > 2;
    private static final Predicate<Person> isPersonTall = person -> person.getHeight() >= 170;
    private static final Predicate<Person> isPersonMale = person -> person.getGender().equals("Male");

    public static void main(String[] args) {
        BasicConfigurator.configure();

        LOGGER.info(areAllElementsMatching(isElementNameLengthGreaterThan2));
        LOGGER.info(isAnyElementMatching(isElementNameLengthGreaterThan2));

        LOGGER.info("All persons are tall: " + PersonRepository.getAllPersons()
                .stream()
                .allMatch(isPersonTall));

        LOGGER.info("All persons are tall: " + PersonRepository.getAllPersons()
                .stream()
                .anyMatch(isPersonTall.and(isPersonMale)));
    }

    private static boolean areAllElementsMatching(Predicate<String> predicate){
        return fruits.stream().allMatch(predicate);
    }

    private static boolean isAnyElementMatching(Predicate<String> predicate){
        return fruits.stream().anyMatch(predicate);
    }
}

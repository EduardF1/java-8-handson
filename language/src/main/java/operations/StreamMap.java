package operations;

import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMap {
    private static final Logger LOGGER = LogManager.getLogger(StreamMap.class);
    private static final List<String> fruits = Arrays.asList("Apple", "Orange", "Banana", "Pineapple");

    private static List<String> toUpperTransform(List<Person> persons) {
        return persons.stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    private static Set<String> toUpperTransformSet(List<Person> persons) {
        return persons.stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        BasicConfigurator.configure();

        List<Integer> fruitLengths = fruits.stream()
                .map(String::length)
                .collect(Collectors.toList());

        LOGGER.info(fruitLengths);

        fruits.stream()
                .map(String::length)
                .collect(Collectors.toList())
                .forEach(LOGGER::info);

        LOGGER.info(toUpperTransform(PersonRepository.getAllPersons()));
        LOGGER.info(toUpperTransformSet(PersonRepository.getAllPersons()));
    }
}

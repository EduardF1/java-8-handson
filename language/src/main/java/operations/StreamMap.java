package operations;

import function.dto.Person;
import function.repository.PersonRepository;
import method_reference.SimpleMethodReference;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {
    private static final Logger logger = LogManager.getLogger(StreamMap.class);
    private static final List<String> fruits = Arrays.asList("Apple", "Orange", "Banana", "Pineapple");

    static List<String> toUpperTransform(List<Person> persons) {
        return persons.stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        BasicConfigurator.configure();

        List<Integer> fruitLengths = fruits.stream()
                .map(String::length)
                .collect(Collectors.toList());

        logger.info(fruitLengths);

        fruits.stream()
                .map(String::length)
                .collect(Collectors.toList())
                .forEach(logger::info);

        logger.info(toUpperTransform(PersonRepository.getAllPersons()));
    }
}

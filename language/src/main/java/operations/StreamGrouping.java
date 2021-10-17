package operations;

import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamGrouping {
    private static final Logger logger = LogManager.getLogger(StreamGrouping.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        groupByGender();
        groupByHeight();
    }

    private static void groupByGender() {
        Map<String, List<Person>> genderGroup = PersonRepository
                .getAllPersons()
                .stream()
                .collect(Collectors.groupingBy(Person::getGender));

        // genderGroup.entrySet().forEach(person -> logger.info("Key: " + person.getKey() + "/ Value" + person.getValue()));
        Stream.of(genderGroup).forEach(logger::info);
    }

    private static void groupByHeight() {
        Map<String, List<Person>> heightGroup = PersonRepository
                .getAllPersons()
                .stream()
                .collect(Collectors.groupingBy(person -> person.getHeight() >= 170 ? "Tall" : "Short"));
        Stream.of(heightGroup).forEach(logger::info);
    }
}

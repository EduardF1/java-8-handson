package operations;

import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
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
        twoLevelGrouping();
        twoLevelGroupingCount();
        threeLevelGrouping();
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

    private static void twoLevelGrouping() {
        Map<String, Map<String, List<Person>>> genderAndHeightGroup = PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.groupingBy(person -> person.getHeight() >= 170 ? "Tall" : "Short")));
        Stream.of(genderAndHeightGroup).forEach(logger::info);
    }

    private static void twoLevelGroupingCount() {
        Map<String, Integer> nameAndKidsGroup = PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.summingInt(Person::getKids)));
        Stream.of(nameAndKidsGroup).forEach(logger::info);
    }

    private static void threeLevelGrouping() {
        Map<String, List<Person>> namesGroup = PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.groupingBy(Person::getName, HashMap::new, Collectors.toList()));
        Stream.of(namesGroup).forEach(logger::info);
    }
}

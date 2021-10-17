package operations;

import function.dto.Person;
import function.repository.PersonRepository;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMap {
    private static final Logger logger = LogManager.getLogger(StreamFlatMap.class);

    static List<String> getAllHobbies(List<Person> persons) {
        return persons.stream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    static List<String> getDistinctHobbies(List<Person> persons) {
        return persons.stream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    static long getCountOfHobbies(List<Person> persons){
        return persons.stream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .distinct()
                .count();
    }


    public static void main(String[] args) {
        BasicConfigurator.configure();

        List<Integer> oddNumber = Arrays.asList(1, 3, 5, 7);
        List<Integer> evenNumber = Arrays.asList(2, 4, 6, 8);

        List<List<Integer>> listOfList = Arrays.asList(oddNumber, evenNumber);
        logger.info("Before Flattening :" + listOfList);

        List<Integer> flattenedList = listOfList.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        logger.info("After Flattening :" + flattenedList);

        logger.info("Hobbies with duplicates: " + getAllHobbies(PersonRepository.getAllPersons()));
        logger.info("Hobbies without duplicates: " + getDistinctHobbies(PersonRepository.getAllPersons()));
        logger.info("Hobbies count: " + getCountOfHobbies(PersonRepository.getAllPersons()));
    }
}

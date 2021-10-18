package function.bi_function;

import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class SimpleBiFunction {
    private static Predicate<Person> isHeightGreaterThan140 = person -> person.getHeight() >= 170;
    private static Predicate<Person> isGenderMale = person -> person.getGender().equals("Male");
    private static BiFunction<String, String, String> biFunctionOne = (a,b) -> (a + " " + b);
    private static BiFunction<List<Person>, Predicate<Person>, Map<String, Double>> biFunctionTwo = (listOfPersons, predicate) -> {
        Map<String, Double> map = new HashMap<>();
        listOfPersons.forEach(person -> {
            if(isHeightGreaterThan140.and(predicate).test(person))
                map.put(person.getName(), person.getSalary());
        });
        return map;
    };
    private static final Logger LOGGER = LogManager.getLogger(SimpleBiFunction.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        LOGGER.info("Result: " + biFunctionOne.apply("java", "features"));

        Map<String, Double> map = biFunctionTwo.apply(PersonRepository.getAllPersons(), isGenderMale);
        LOGGER.info(map);
    }
}

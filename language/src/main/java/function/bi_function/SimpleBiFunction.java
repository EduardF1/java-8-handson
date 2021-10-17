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
    static Predicate<Person> isHeightGreaterThan140 = person -> person.getHeight() >= 170;
    static Predicate<Person> isGenderMale = person -> person.getGender().equals("Male");
    static BiFunction<String, String, String> biFunctionOne = (a,b) -> (a + " " + b);
    static BiFunction<List<Person>, Predicate<Person>, Map<String, Double>> biFunctionTwo = (listOfPersons, predicate) -> {
        Map<String, Double> map = new HashMap<>();
        listOfPersons.forEach(person -> {
            if(isHeightGreaterThan140.and(predicate).test(person))
                map.put(person.getName(), person.getSalary());
        });
        return map;
    };

    private static final Logger logger = LogManager.getLogger(SimpleBiFunction.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        logger.info("Result: " + biFunctionOne.apply("java", "features"));

        Map<String, Double> map = biFunctionTwo.apply(PersonRepository.getAllPersons(), isGenderMale);
        logger.info(map);
    }
}

package function.function_interface;

import function.dto.Person;
import function.repository.PersonRepository;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class PersonFunction {
    private static final Logger logger = LogManager.getLogger(PersonFunction.class);

    static Function<String, Integer> functionOne = name -> name.length();
    static Predicate<Person> isHeightGreaterThan140 = person -> person.getHeight() >= 170;
    static Predicate<Person> isGenderMale = person -> person.getGender().equals("Male");

    static Function<List<Person>, Map<String, Double>> functionTwo = personList -> {
        Map<String, Double> map = new HashMap<>();
        personList.forEach(person -> {
            if(isHeightGreaterThan140.and(isGenderMale).test(person)){
                map.put(person.getName(), person.getSalary());
            }
        });
        return map;
    };

    public static void main(String[] args) {
        BasicConfigurator.configure();

        logger.info(functionOne.apply("java features"));
        logger.info(functionTwo.apply(PersonRepository.getAllPersons()));
    }
}

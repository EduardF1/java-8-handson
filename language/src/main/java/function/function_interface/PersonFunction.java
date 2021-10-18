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
    private static final Logger LOGGER = LogManager.getLogger(PersonFunction.class);

    private static final Function<String, Integer> functionOne = name -> name.length();
    private static final Predicate<Person> isHeightGreaterThan140 = person -> person.getHeight() >= 170;
    private static final Predicate<Person> isGenderMale = person -> person.getGender().equals("Male");

    private static Function<List<Person>, Map<String, Double>> functionTwo = personList -> {
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

        LOGGER.info(functionOne.apply("java features"));
        LOGGER.info(functionTwo.apply(PersonRepository.getAllPersons()));
    }
}

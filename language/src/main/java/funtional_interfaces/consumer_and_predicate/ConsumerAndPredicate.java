package funtional_interfaces.consumer_and_predicate;

import funtional_interfaces.dto.Person;
import funtional_interfaces.repository.PersonRepository;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerAndPredicate {

    private static final Logger logger = LogManager.getLogger(ConsumerAndPredicate.class);

    static Predicate<Person> isHeightGreaterThan140 = person -> person.getHeight() >= 140;
    static Predicate<Person> isGenderMale = person -> person.getGender().equals("Male");
    static BiPredicate<Integer, String> isHeightGreaterThan140AndIsGenderMale = (height, gender) -> height >= 140 && gender.equals("Male");
    static BiConsumer<String, List<String>> hobbiesConsumer = (name, hobbies) -> logger.info(name + " " + hobbies);
    static Consumer<Person> personConsumer = person -> {
        if (isHeightGreaterThan140.and(isGenderMale).test(person)) hobbiesConsumer.accept(person.getName(), person.getHobbies());
    };
    static Consumer<Person> compositePersonConsumer = person -> {
        if (isHeightGreaterThan140AndIsGenderMale.test(person.getHeight(), person.getGender())) {
            hobbiesConsumer.accept(person.getName(), person.getHobbies());
        }
    };

    public static void main(String[] args) {
        BasicConfigurator.configure();
        PersonRepository.getAllPersons().forEach(personConsumer);
        PersonRepository.getAllPersons().forEach(compositePersonConsumer);
    }
}

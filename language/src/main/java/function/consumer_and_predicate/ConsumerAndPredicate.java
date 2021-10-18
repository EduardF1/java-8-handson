package function.consumer_and_predicate;

import function.dto.Person;
import function.repository.PersonRepository;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerAndPredicate {

    private static final Logger LOGGER = LogManager.getLogger(ConsumerAndPredicate.class);

    private static final Predicate<Person> isHeightGreaterThan140 = person -> person.getHeight() >= 140;
    private static final Predicate<Person> isGenderMale = person -> person.getGender().equals("Male");
    private static final BiPredicate<Integer, String> isHeightGreaterThan140AndIsGenderMale = (height, gender) -> height >= 140 && gender.equals("Male");
    private static final BiConsumer<String, List<String>> hobbiesConsumer = (name, hobbies) -> LOGGER.info(name + " " + hobbies);
    private static final Consumer<Person> personConsumer = person -> {
        if (isHeightGreaterThan140.and(isGenderMale).test(person)) hobbiesConsumer.accept(person.getName(), person.getHobbies());
    };
    private static final Consumer<Person> compositePersonConsumer = person -> {
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

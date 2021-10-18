package function.bi_consumer;

import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.function.BiConsumer;

import static shared.Constants.TAB;

public class PersonBiConsumer {
    private static final Logger LOGGER = LogManager.getLogger(PersonBiConsumer.class);

    private static List<Person> getAllPersons() {
        return PersonRepository.getAllPersons();
    }

    static void displayPersonNamesAndHobbies() {
        BiConsumer<String, List<String>> personConsumer = (name, hobbies) -> LOGGER.info(TAB + name + TAB + hobbies);
        getAllPersons().forEach(person -> personConsumer.accept(person.getName(), person.getHobbies()));
    }

    static void displayPersonNamesAndSalary() {
        BiConsumer<String, Double> salaryConsumer = (name, salary) -> LOGGER.info(TAB + name + TAB + salary);
        getAllPersons().forEach(person -> salaryConsumer.accept(person.getName(), person.getSalary()));
    }

    public static void main(String[] args) {
        BasicConfigurator.configure();
        displayPersonNamesAndHobbies();
        displayPersonNamesAndSalary();
    }
}

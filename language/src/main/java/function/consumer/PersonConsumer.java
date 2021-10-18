package function.consumer;

import function.dto.Person;
import function.repository.PersonRepository;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.function.Consumer;

public class PersonConsumer {
    private static final Logger LOGGER = LogManager.getLogger(PersonConsumer.class);

    private static final Consumer<Person> consumer = parameter -> LOGGER.info(parameter);
    private static final Consumer<Person> consumer2 = parameter -> LOGGER.info(parameter.getName().toUpperCase());
    private static final Consumer<Person> consumer3 = parameter -> LOGGER.info(parameter.getHobbies());

    private static List<Person> getAllPersons() {
        return PersonRepository.getAllPersons();
    }

    private static void getAllPersonsInformation() {
        getAllPersons().forEach(consumer);
    }

    private static void getNamesAndHobbies() {
        getAllPersons().forEach(consumer.andThen(consumer2));
    }

    private static void getAllMaleAndTallPersonsHobbiesAndCapitalizedNames() {
        getAllPersons().forEach(person -> {
            if (person.getGender().equals("Male") && person.getHeight() >= 140) {
                consumer2.andThen(consumer3).accept(person);
            }
        });
    }

    public static void main(String[] args) {
        BasicConfigurator.configure();

        //  Explicit sequence of consumers
        //  consumer.accept(PersonRepository.getPerson("John"));
        //  consumer2.accept(PersonRepository.getPerson("John"));
        //  consumer3.accept(PersonRepository.getPerson("John"));

        //  Chained sequence of consumers
        //  consumer.andThen(consumer2).andThen(consumer3).accept(PersonRepository.getPerson("John"));

        getAllPersonsInformation();
        getAllMaleAndTallPersonsHobbiesAndCapitalizedNames();
    }
}

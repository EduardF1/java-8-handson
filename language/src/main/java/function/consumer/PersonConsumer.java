package function.consumer;

import function.dto.Person;
import function.repository.PersonRepository;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.function.Consumer;

public class PersonConsumer {
    private static final Logger logger = LogManager.getLogger(PersonConsumer.class);

    static Consumer<Person> consumer = parameter -> logger.info(parameter);
    static Consumer<Person> consumer2 = parameter -> logger.info(parameter.getName().toUpperCase());
    static Consumer<Person> consumer3 = parameter -> logger.info(parameter.getHobbies());

    static List<Person> getAllPersons() {
        return PersonRepository.getAllPersons();
    }

    static void getAllPersonsInformation() {
        getAllPersons().forEach(consumer);
    }

    static void getNamesAndHobbies() {
        getAllPersons().forEach(consumer.andThen(consumer2));
    }

    static void getAllMaleAndTallPersonsHobbiesAndCapitalizedNames() {
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

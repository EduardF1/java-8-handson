package optional;

import function.dto.Person;
import function.repository.PersonRepository;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Optional;

public class OptionalIfElse {
    private static final Logger logger = LogManager.getLogger(OptionalIfElse.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        // orElse();
        // orElseGet();
        orElseThrow();
    }

    private static void orElse() {
        Optional<Person> person = PersonRepository.getPersonOptional();
        //  String name = person.isPresent() ? person.get().getName() : "Data Not Found";
        String name = person.map(Person::getName).orElse("Data Not Found");
        logger.info("OrElse Person name: " + name);
    }

    private static void orElseGet() {
        Optional<Person> person = PersonRepository.getPersonOptional();
        String name = person.map(Person::getName).orElseGet(() -> {
            // some business logic
            return "Data Not Found";
        });
        logger.info("OrElse Person name: " + name);
    }

    private static void orElseThrow() {
        Optional<Person> person = PersonRepository.getPersonOptional();
        String name = person.map(Person::getName).orElseThrow(()-> new RuntimeException("Name Not Found"));
        logger.info("OrElse Person name: " + name);
    }
}

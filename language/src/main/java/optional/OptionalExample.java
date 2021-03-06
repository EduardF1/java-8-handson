package optional;

import function.dto.Person;
import function.repository.PersonRepository;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Optional;

public class OptionalExample {
    private static final Logger LOGGER = LogManager.getLogger(OptionalExample.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        LOGGER.info("Result :" + getName("John Doe"));
        LOGGER.info("Result 2:" + Optional.ofNullable(getName("John")).get());
        LOGGER.info("Result 3:" + Optional.ofNullable(getName(null)).orElse("A null was passed."));

        Optional<String> name = Optional.ofNullable(getName("Sebastian"));
        LOGGER.info(name.isPresent() ? name.get() : "Nothing found.");
        LOGGER.info(name.orElse("Nothing Found."));

        LOGGER.info("Person Name :" + getPersonName(new Person()));
        Optional<String> personName = getPersonName2(PersonRepository.getPersonOptional());
        LOGGER.info("The Optional person name is : " + personName.get());
    }

    private static String getName(String name) {
        return name;
    }

    private static  String getPersonName(Person person){
        return person != null ? person.getName() : "Nothing Found.";
    }

    private static Optional<String> getPersonName2(Optional<Person> person){
        return person.isPresent() ? person.map(Person::getName) : Optional.empty();
    }
}

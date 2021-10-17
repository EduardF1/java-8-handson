package supplier;

import function.dto.Person;
import function.repository.PersonRepository;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.function.Supplier;

public class PersonSupplier {
    private static final Logger logger = LogManager.getLogger(PersonSupplier.class);
    static Supplier<Person> supplier1 = PersonRepository::getPerson;
    static Supplier<List<Person>> supplier2 = PersonRepository::getAllPersons;

    public static void main(String[] args) {
        BasicConfigurator.configure();

        logger.info("Result one:" + supplier2.get());
        logger.info("Result two:" + supplier1.get());
    }
}

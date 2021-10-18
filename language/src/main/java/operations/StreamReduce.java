package operations;

import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduce {
    private static final Logger LOGGER = LogManager.getLogger(StreamReduce.class);
    private static final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        LOGGER.info(getSum());
        LOGGER.info(getCount());

        LOGGER.info("Result of multiplication : " + getMultipliedNumbers());
        LOGGER.info("Result of multiplication : " + getReducedSum());

        LOGGER.info(getCombinedNames());

        Optional<Person> tallestPerson = getTallestPerson();
        LOGGER.info(tallestPerson.orElse(null));
    }

    private static Integer getReducedSum() {
        return numbers.stream().reduce(0, Integer::sum);
    }

    private static Integer getMultipliedNumbers() {
        return numbers.stream().reduce(1, (a, b) -> a * b);
    }

    private static long getCount() {
        return numbers.stream().mapToInt(element -> element).count();
    }

    private static int getSum() {
        return numbers.stream().mapToInt(element -> element).sum();
    }

    private static String getCombinedNames() {
        return PersonRepository.getAllPersons().stream().map(Person::getName).reduce("", String::concat);
    }

    private static Optional<Person> getTallestPerson() {
        return PersonRepository.getAllPersons()
                .stream()
                .reduce((x, y) -> x.getHeight() > y.getHeight() ? x : y);
    }
}

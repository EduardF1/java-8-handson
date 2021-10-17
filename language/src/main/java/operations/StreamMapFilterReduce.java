package operations;

import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.function.Predicate;

public class StreamMapFilterReduce {
    private static final Logger logger = LogManager.getLogger(StreamMapFilterReduce.class);

    static Predicate<Person> isTall = person -> person.getHeight() >= 170;
    static Predicate<Person> isMale = person -> person.getGender().equals("Male");

    public static void main(String[] args) {
        BasicConfigurator.configure();

        int kidsCount = PersonRepository.getAllPersons()
                .stream()
                .filter(isTall.and(isMale))
                .map(Person::getKids)
                .reduce(0, Integer::sum); //    .reduce(0, (x, y) -> x + y);

        logger.info("Number of kids: " + kidsCount);
    }
}

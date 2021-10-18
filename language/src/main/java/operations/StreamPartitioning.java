package operations;

import function.dto.Person;
import function.repository.PersonRepository;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamPartitioning {
    private static final Logger LOGGER = LogManager.getLogger(StreamMapping.class);
    private static Predicate<Person> isPersonTall = person -> person.getHeight() >= 170;

    public static void main(String[] args) {
        BasicConfigurator.configure();

        LOGGER.info(getPersonsPartitionedByHeight());
        LOGGER.info(getPersonsPartitionedWith2Parameters());
        LOGGER.info(getPersonsPartitionedByNameAndHobbies());
    }

    private static Map<Boolean, List<Person>> getPersonsPartitionedByHeight() {
        return PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.partitioningBy(isPersonTall));
    }

    private static Map<Boolean, Set<Person>> getPersonsPartitionedWith2Parameters() {
        return PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.partitioningBy(isPersonTall, Collectors.toSet()));
    }

    private static Map<Boolean, Map<String, List<String>>> getPersonsPartitionedByNameAndHobbies() {
        return PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.partitioningBy(isPersonTall, Collectors.toMap(Person::getName, Person::getHobbies)));
    }
}

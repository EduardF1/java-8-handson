package operations;

import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJoining {
    private static final Logger logger = LogManager.getLogger(StreamJoining.class);
    private static final char[] characters = {'a', 'b', 'c', 'd', 'e'};

    public static void main(String[] args) {
        BasicConfigurator.configure();

        logger.info(getJoinedCharacters());
        logger.info(getJoinedPersonNames());
    }

    private static String getJoinedPersonNames(){
        return PersonRepository.getAllPersons()
                .stream()
                .map(Person::getName)
                .collect(Collectors.joining("-"));
    }

    private static String getJoinedCharacters(){
        return Stream.of(characters)
                .map(array -> new String(array))
                .collect(Collectors.joining("", "[", "]"));
    }
}

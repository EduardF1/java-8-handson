package operations;

import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSumAndAverage {
    private static final Logger LOGGER = LogManager.getLogger(StreamSumAndAverage.class);
    private static final String NUMBER_OF_KIDS = "Number of kids: ";
    private static final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        LOGGER.info(NUMBER_OF_KIDS + getTotalKidsCount());
        LOGGER.info(NUMBER_OF_KIDS + getTotalKidsCount2());
        LOGGER.info("The Average height is: " + getAverageHeight());
        LOGGER.info("The sum is: " + getSum());
    }

    private static int getTotalKidsCount() {
        return PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.summingInt(Person::getKids));
    }

    private static int getTotalKidsCount2() {
        return PersonRepository.getAllPersons()
                .stream()
                .mapToInt(Person::getKids)
                .sum();
    }

    private static double getAverageHeight() {
        return PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.averagingInt(Person::getHeight));
    }

    private static int getSum() {
        return numbers.stream()
                .collect(Collectors.summingInt(Integer::intValue));
    }
}

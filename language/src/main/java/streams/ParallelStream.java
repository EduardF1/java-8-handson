package streams;

import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelStream {
    private static final Logger logger = LogManager.getLogger(ParallelStream.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        logger.info(getHobbiesWithSequence());
        logger.info(getHobbiesParallel());
    }

    private static List<String> getHobbiesWithSequence() {
        long startTime = System.currentTimeMillis();
        List<String> personsHobbies = PersonRepository.getAllPersons()
                .stream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        logger.info("Sequential Duration :" + (endTime - startTime));
        return personsHobbies;
    }

    private static List<String> getHobbiesParallel() {
        long startTime = System.currentTimeMillis();
        List<String> personsHobbies = PersonRepository.getAllPersons()
                .parallelStream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        logger.info("Parallel Duration :" + (endTime - startTime));
        return personsHobbies;
    }
}

package streams_vs_collections;

import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsVsCollections {
    private static final Logger LOGGER = LogManager.getLogger(StreamsVsCollections.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        List<String> names = new ArrayList<>();
        names.add("Mike");
        names.add("Lorry");
        names.add("Nathan");

        for (String name : names) {
            LOGGER.info("Iteration 1 :" + name);
        }

        for (String name : names) {
            LOGGER.info("Iteration 2 :" + name);
        }

        Stream<String> stream = names.stream();
        stream.forEach(name -> LOGGER.info("<<< :" + name));

        List<String> personNames = PersonRepository
                .getAllPersons()
                .stream()
                .peek(LOGGER::info)    // used for debugging purposes, the equivalent of "tap" from RxJS
                .map(Person::getName)
                .peek(LOGGER::info)
                .collect(Collectors.toList());

        LOGGER.info(personNames);
    }
}

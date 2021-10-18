package interfaces;

import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultInterface {
    private static final Logger LOGGER = LogManager.getLogger(DefaultInterface.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        List<String> names = getPersonNames();

        LOGGER.info("Before sort: ");
        names.forEach(LOGGER::info);

        //Collections.sort(names);
        names.sort(Comparator.naturalOrder());
        LOGGER.info("After sort: ");
        names.forEach(LOGGER::info);


    }

    private static List<String> getPersonNames(){
        return PersonRepository.getAllPersons()
                .stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }
}

package operations;

import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilter {
    private static final Logger LOGGER = LogManager.getLogger(StreamFilter.class);
    private static final List<String> names = Arrays.asList("Samuel", "Anders", "Nicki", "Joel", "Xin", "Jan");

    private static final Predicate<Person> checkHeightGreaterThan170 = person -> person.getHeight() >= 170;
    private static final Predicate<Person> checkGenderMale = person -> person.getGender().equals("Male");

    public static void main(String[] args) {
        BasicConfigurator.configure();

        Stream<String> allNames = names.stream();
        Stream<String> filteredList = allNames.filter(name -> name.length() > 3);
        filteredList.forEach(LOGGER::info);

        names.stream().filter(name -> name.length() > 3).collect(Collectors.toList()).forEach(LOGGER::info);

        List<Person> tallMalePersons = PersonRepository.getAllPersons()
                .stream()
                .filter(checkHeightGreaterThan170)
                .filter(checkGenderMale)
                .collect(Collectors.toList());

        tallMalePersons.forEach(LOGGER::info);
    }
}

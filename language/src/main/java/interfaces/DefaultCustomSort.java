package interfaces;

import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.List;

import static shared.Constants.SEPARATOR;

public class DefaultCustomSort {
    private static final Logger LOGGER = LogManager.getLogger(DefaultCustomSort.class);
    private static final Comparator<Person> NAME_COMPARATOR = Comparator.comparing(Person::getName);
    private static final Comparator<Person> HEIGHT_COMPARATOR = Comparator.comparingDouble(Person::getHeight);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        sortByHeight(getPersons());
        LOGGER.info(SEPARATOR);
        sortByName(getPersons());
        LOGGER.info(SEPARATOR);
        sortByHeightAndName(getPersons());
        LOGGER.info(SEPARATOR);
        sortByNameWithNullFirst(getPersons());
    }

    private static void sortByName(List<Person> personList){
        personList.sort(NAME_COMPARATOR);
        personList.forEach(LOGGER::info);
    }

    private static void sortByHeight(List<Person> personList){
        personList.sort(HEIGHT_COMPARATOR);
        personList.forEach(LOGGER::info);
    }

    private static List<Person> getPersons(){
        return PersonRepository.getAllPersons();
    }

    private static void sortByHeightAndName(List<Person> personList){
        personList.sort(NAME_COMPARATOR.thenComparing(HEIGHT_COMPARATOR));
        personList.forEach(LOGGER::info);
    }

    private static void sortByNameWithNullFirst(List<Person> personList){
        Comparator<Person> nullComparator = Comparator.nullsFirst(NAME_COMPARATOR);
        personList.sort(nullComparator);
        personList.forEach(LOGGER::info);
    }

    private static void sortByNameWithNullLast(List<Person> personList){
        Comparator<Person> nullComparator = Comparator.nullsLast(NAME_COMPARATOR);
        personList.sort(nullComparator);
        personList.forEach(LOGGER::info);
    }
}

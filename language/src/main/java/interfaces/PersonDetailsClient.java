package interfaces;

import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class PersonDetailsClient {
    private static final Logger LOGGER = LogManager.getLogger(PersonDetailsClient.class);
    private static final List<Person> persons = PersonRepository.getAllPersons();

    public static void main(String[] args) {
        BasicConfigurator.configure();

        PersonDetails personDetails = new PersonDetailsImpl();
        LOGGER.info("Total salary: " + personDetails.calculateTotalSalary(persons));
        LOGGER.info("Total Kids count: " + personDetails.totalKids(persons));
        PersonDetails.personNames(persons).forEach(LOGGER::info);
    }
}

package optional;

import function.dto.Address;
import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Optional;

public class OptionalMap {
    private static final Logger logger = LogManager.getLogger(OptionalMap.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        displayPersonName();
        displayPersonAddress();
        displayPersonAddress2();
        displayTallPersonAddress();
        displayPersonAddress3();
    }

    private static void displayPersonName(){
        Optional<Person> person = PersonRepository.getPersonOptional();
        person.ifPresent(per -> {
            String name = person.map(Person::getName).orElse("Nothing Found");
            logger.info(name);
        });
    }

    private static void displayPersonAddress(){
        Optional<Person> person = PersonRepository.getPersonOptional();
        person.ifPresent(per -> {
            if(person.isPresent()){
                Optional<Address> address = person.flatMap(Person::getAddress);
                logger.info("Address :" + (address.isPresent() ? address.get().toString() : Optional.empty()));
            }
        });
    }

    private static void displayTallPersonAddress(){
        Optional<Person> person = PersonRepository.getPersonOptional()
                .filter(per -> per.getHeight() >= 170);
        person.ifPresent(per -> logger.info(per.getAddress().get().toString()));
    }

    private static void displayPersonAddress2(){
        Optional<Person> person = PersonRepository.getPersonOptional();
        if(person.isPresent()){
            Optional<Address> address = person.flatMap(Person::getAddress);
            logger.info(address.get().toString());
        }
    }

    private static void displayPersonAddress3(){
        Optional<Person> person = PersonRepository.getPersonOptional()
                .filter(per -> per.getHeight() >= 170);
        person.ifPresent(per -> logger.info(per.getAddress()));
    }
}

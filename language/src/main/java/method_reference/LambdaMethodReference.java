package method_reference;

import function.dto.Person;
import function.repository.PersonRepository;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaMethodReference {
    private static final Logger logger = LogManager.getLogger(LambdaMethodReference.class);

    static Function<String, String> functionOne = name -> name.toUpperCase();
    static Function<String, String> functionTwo = String::toUpperCase;

    static Predicate<Person> predicateOne = person -> person.getHeight() >= 170;
    static Predicate<Person> predicateTwo = LambdaMethodReference::heightCheck;
    static BiPredicate<Person, Integer> predicateThree = LambdaMethodReference::heightCheckWithParameter;

    public static void main(String[] args) {
        BasicConfigurator.configure();

        logger.info("Lambda Expression Result :" + functionOne.apply("java 8"));
        logger.info("Method reference Result :" + functionTwo.apply("java 8"));
        logger.info("Predicate 1 Result :" + predicateOne.test(PersonRepository.getPerson()));
        logger.info("Predicate 2 Result :" + predicateTwo.test(PersonRepository.getPerson()));
        logger.info("Predicate 3 Result :" + predicateThree.test(PersonRepository.getPerson(), 155));
    }

    private static boolean heightCheck(Person person) {
        return person.getHeight() >= 170;
    }

    private static boolean heightCheckWithParameter(Person person, Integer height) {
        return person.getHeight() >= height;
    }
}

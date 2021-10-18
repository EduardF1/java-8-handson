package operations;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class StreamLimit {
    private static final Logger LOGGER = LogManager.getLogger(StreamLimit.class);
    private static final List<String> fruits = Arrays.asList("Avocado", "Banana", "Mango", "Pineapple");
    private static final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        displayFruits(2);
        displaySum(4);
        displayFruitsWithSkip(3);
    }

    private static void displayFruits(int numberOfElements){
        fruits.stream().limit(numberOfElements).forEach(LOGGER::info);
    }

    private static void displaySum(int numberOfElements){
        LOGGER.info(numbers.stream().limit(numberOfElements).reduce(0, Integer::sum));
    }

    private static void displayFruitsWithSkip(int numberOfSkips){
        LOGGER.info(numbers.stream().skip(numberOfSkips).reduce(0, Integer::sum));
    }
}

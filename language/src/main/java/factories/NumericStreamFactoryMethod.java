package factories;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamFactoryMethod {
    private static final Logger LOGGER = LogManager.getLogger(NumericStreamFactoryMethod.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        int sum = IntStream.rangeClosed(1, 50).sum();
        LOGGER.info("The total is: " + sum);

        OptionalInt max = IntStream.rangeClosed(1, 50).max();
        LOGGER.info("The maximum value is: " + max.orElse(0));

        OptionalInt min = IntStream.rangeClosed(1, 50).min();
        LOGGER.info("The minimum value is: " + min.orElse(0));

        OptionalDouble average = LongStream.rangeClosed(1, 50).average();
        LOGGER.info("The average value is: " + average.orElse(0));
    }
}

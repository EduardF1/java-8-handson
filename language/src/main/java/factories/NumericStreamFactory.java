package factories;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static shared.Constants.SEPARATOR;

public class NumericStreamFactory {
    private static final Logger LOGGER = LogManager.getLogger(NumericStreamFactory.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        IntStream intStream1 = IntStream.rangeClosed(1, 6);
        IntStream intStream2 = IntStream.range(1, 6);
        intStream1.forEach(element -> LOGGER.info(element));
        LOGGER.info(SEPARATOR);
        intStream2.forEach(element -> LOGGER.info(element));
        LOGGER.info(SEPARATOR);
        LongStream longStream = LongStream.rangeClosed(1, 50);
        longStream.forEach(element -> LOGGER.info(element));
        LOGGER.info(SEPARATOR);
        DoubleStream doubleStream = LongStream.rangeClosed(1,20).asDoubleStream();
        doubleStream.forEach(element -> LOGGER.info(element));
    }
}

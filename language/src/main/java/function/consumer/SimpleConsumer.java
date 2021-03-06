package function.consumer;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.function.Consumer;

public class SimpleConsumer {
    private static final Logger LOGGER = LogManager.getLogger(SimpleConsumer.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        Consumer<String> consumer1 = input -> LOGGER.info(input.toUpperCase());
        //  consumer1.accept("java8");
        Consumer<String> consumer2 = input -> LOGGER.info(input.toLowerCase());
        //  consumer2.accept("java8");
        consumer1.andThen(consumer2).accept("Java8");
    }
}

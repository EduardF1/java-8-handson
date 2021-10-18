package factories;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StreamFactory {
    private static final Logger LOGGER = LogManager.getLogger(StreamFactory.class);
    private static UnaryOperator<Integer> add = x -> x + 5;

    public static void main(String[] args) {
        BasicConfigurator.configure();

        Stream<Integer> stream = Stream.iterate(0, add).limit(10);
        stream.forEach(LOGGER::info);

        Stream<Double> stream2 = Stream.generate(Math::random).limit(10);
        stream2.forEach(LOGGER::info);

        Stream.generate(new Random()::nextInt).limit(10).forEach(LOGGER::info);

        Stream<String> stream3 = Stream.of("One", "Two", "Three", "Four");
        stream3.forEach(LOGGER::info);
    }
}

package numeric_stream;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamMap {
    private static final Logger logger = LogManager.getLogger(NumericStreamMap.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        logger.info("Map to double: " + mapIntegersToDouble());
        logger.info("Map to long: " + mapIntegersToLong());
        logger.info("Map to object: " + mapToObject());
    }

    private static double mapIntegersToDouble() {
        return IntStream.rangeClosed(1, 10)          //  primitive int elements
                .mapToDouble(x -> x)                //  converting the elements to double
                .sum();                             //  performing sum
    }

    private static long mapIntegersToLong() {
        return IntStream.rangeClosed(1, 10)
                .mapToLong(x -> x)
                .sum();
    }

    private static List<Integer> mapToObject() {
        return IntStream.rangeClosed(1, 10)
                .mapToObj(x -> x)
                .collect(Collectors.toList());
    }
}

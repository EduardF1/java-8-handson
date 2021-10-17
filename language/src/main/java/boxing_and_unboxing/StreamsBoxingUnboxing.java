package boxing_and_unboxing;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsBoxingUnboxing {
    private static final Logger logger = LogManager.getLogger(StreamsBoxingUnboxing.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        logger.info(getNumbers());
        logger.info(calculateSum(getNumbers()));
    }

    // boxing
    private static List<Integer> getNumbers() {
        return IntStream.rangeClosed(1, 40)        // primitive int
                .boxed()                           // converting to wrapper Integer
                .collect(Collectors.toList());     // collect as List
    }

    // unboxing
    private static int calculateSum(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}

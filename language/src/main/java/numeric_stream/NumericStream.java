package numeric_stream;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class NumericStream {
    private static final Logger logger = LogManager.getLogger(NumericStream.class);
    private static final List<Integer> numbers = Arrays.asList(4,5,6,7,8,9,11);
    private static BinaryOperator<Integer> add = Integer::sum;

    public static void main(String[] args) {
        BasicConfigurator.configure();

        logger.info("The total is: " + calculateSum(numbers));

        IntStream intStream = IntStream.rangeClosed(1, 10);
        logger.info("The total (streams) is: " + calculateSumWithStream(intStream));
    }

    private static int calculateSum(List<Integer> numbers){
        return numbers.stream().reduce(0, add);
    }

    private static int calculateSumWithStream(IntStream intStream){
        return intStream.sum();
    }
}

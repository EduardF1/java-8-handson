package function.operators;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryAndBinaryOperators {
    private static final Logger LOGGER = LogManager.getLogger(UnaryAndBinaryOperators.class);

    private static final UnaryOperator<String> unaryOperatorOne = name -> name.toUpperCase();
    private static final UnaryOperator<Integer> unaryOperatorTwo = a -> a + 10;
    private static final Comparator<Integer> comparator = (a, b) -> a.compareTo(b);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        LOGGER.info("Result one:" + unaryOperatorOne.apply("Java8"));
        LOGGER.info("Result two:" + unaryOperatorTwo.apply(21));

        BinaryOperator<Integer> binaryOperatorOne = BinaryOperator.maxBy(comparator);
        BinaryOperator<Integer> binaryOperatorTwo = BinaryOperator.minBy(comparator);

        LOGGER.info("Binary Operator Result 1:" + binaryOperatorOne.apply(12, 13));
        LOGGER.info("Binary Operator Result 2:" + binaryOperatorTwo.apply(12, 13));
    }
}

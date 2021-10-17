package function.operators;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryAndBinaryOperators {
    private static final Logger logger = LogManager.getLogger(UnaryAndBinaryOperators.class);

    static UnaryOperator<String> unaryOperatorOne = name -> name.toUpperCase();
    static UnaryOperator<Integer> unaryOperatorTwo = a -> a + 10;
    static Comparator<Integer> comparator = (a, b) -> a.compareTo(b);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        logger.info("Result 1: " + unaryOperatorOne.apply("Java8"));
        logger.info("Result 2: " + unaryOperatorTwo.apply(21));

        BinaryOperator<Integer> binaryOperatorOne = BinaryOperator.maxBy(comparator);
        BinaryOperator<Integer> binaryOperatorTwo = BinaryOperator.minBy(comparator);

        logger.info("Binary Operator Result 1:" + binaryOperatorOne.apply(12, 13));
        logger.info("Binary Operator Result 2:" + binaryOperatorTwo.apply(12, 13));
    }
}

package function.predicate;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.function.Predicate;

public class SimplePredicate {
    private static final Logger logger = LogManager.getLogger(SimplePredicate.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        Predicate<Integer> lessThan50 = a -> (a <= 50);
        Predicate<Integer> greaterThan20 = a -> (a >= 20);
        Predicate<Integer> equalTo0 = a -> (a == 0);

        logger.info(lessThan50.test(51));
        logger.info(greaterThan20.test(11));
        logger.info(equalTo0.test(11));

        logger.info(greaterThan20.and(lessThan50).or(equalTo0).test(31));
        logger.info(equalTo0.or(lessThan50).test(21));
        logger.info(greaterThan20.and(lessThan50).test(31));
        logger.info(greaterThan20.and(equalTo0).negate().test(21));
    }
}

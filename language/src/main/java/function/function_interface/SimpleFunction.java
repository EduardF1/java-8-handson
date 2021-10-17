package function.function_interface;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.function.Function;

public class SimpleFunction {
    private static final Logger logger = LogManager.getLogger(SimpleFunction.class);

    static Function<String, String> functionOne = name -> name.toUpperCase();
    static Function<String, String> functionTwo = name -> name.toUpperCase().concat(" features");

    public static void main(String[] args) {
        BasicConfigurator.configure();

        logger.info("Result one:" + functionOne.apply("java"));
        logger.info("Result two:" + functionTwo.apply("java"));

        logger.info("And then Result: " + functionOne.andThen(functionTwo).apply("java"));
        logger.info("Composed Result: " + functionOne.compose(functionTwo).apply("java"));
    }
}

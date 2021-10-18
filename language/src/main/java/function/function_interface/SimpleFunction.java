package function.function_interface;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.function.Function;

public class SimpleFunction {
    private static final Logger LOGGER = LogManager.getLogger(SimpleFunction.class);

    private static final Function<String, String> functionOne = name -> name.toUpperCase();
    private static final Function<String, String> functionTwo = name -> name.toUpperCase().concat(" features");

    public static void main(String[] args) {
        BasicConfigurator.configure();

        LOGGER.info("Result one:" + functionOne.apply("java"));
        LOGGER.info("Result two:" + functionTwo.apply("java"));

        LOGGER.info("And then Result: " + functionOne.andThen(functionTwo).apply("java"));
        LOGGER.info("Composed Result: " + functionOne.compose(functionTwo).apply("java"));
    }
}

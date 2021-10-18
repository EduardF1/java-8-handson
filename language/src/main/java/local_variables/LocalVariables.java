package local_variables;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.function.Consumer;

public class LocalVariables {
    private static final Logger LOGGER = LogManager.getLogger(LocalVariables.class);
    static int k = 0;

    public static void main(String[] args) {
        BasicConfigurator.configure();
        int value = 10;

        Consumer<Integer> consumer = (_value) -> {
            k = 21;
            LOGGER.info("K: " + k);
            LOGGER.info("The value is :" + (value + _value));
        };
        consumer.accept(15);
    }
}

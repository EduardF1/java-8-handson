package optional;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Optional;

public class OptionalMethods {
    private static final Logger LOGGER = LogManager.getLogger(OptionalMethods.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        Optional<String> of = Optional.of("java8");
        LOGGER.info(of.get());

        Optional<String> ofNullable = Optional.ofNullable(null);
        LOGGER.info(ofNullable.isPresent() ? ofNullable.get() : Optional.empty());
        LOGGER.info(ofNullable.orElse("No value found."));

    }
}

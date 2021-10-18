package optional;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Optional;

public class OptionalPresent {
    private static final Logger logger = LogManager.getLogger(OptionalPresent.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        Optional<String> ofNullable = Optional.ofNullable("JAVA8");
        logger.info(ofNullable.get());
        ofNullable.ifPresent(logger::info);
    }
}

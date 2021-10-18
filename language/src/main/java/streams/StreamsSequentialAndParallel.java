package streams;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamsSequentialAndParallel {
    private static final Logger logger = LogManager.getLogger(StreamsSequentialAndParallel.class);
    private static final String[]  str= {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    public static void main(String[] args) {
        BasicConfigurator.configure();

        logger.info(Runtime.getRuntime().availableProcessors());
        logger.info("--- Sequential Run ---");
        displayStream(Arrays.stream(str).sequential());
        logger.info("--- Parallel Run ---");
        displayStream(Arrays.stream(str).parallel());
    }

    private static void displayStream(Stream<String> stream){
        stream.forEach(string -> {
            logger.info(LocalTime.now() + " Value : " +
                    string + " - thread :" +
                    Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            }catch (InterruptedException  e){
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        });
    }
}

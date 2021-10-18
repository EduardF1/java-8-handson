package features;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Java7vs8 {
    private static final Logger LOGGER = LogManager.getLogger(Java7vs8.class);

    public static void main(String[] args) throws InterruptedException {
        BasicConfigurator.configure();
        LOGGER.info(getExecutionTimeInMilliseconds());
        LOGGER.info(sumFrom0To50Java8());
    }


    private static int sumFrom0To50Java7() {
        int total = 0;
        for (int i = 0; i <= 50; i++) {
            total += i;
        }
        return total;
    }

    private static int sumFrom0To50Java8() {
        return IntStream.rangeClosed(0, 50).sum();
    }

    private static long getExecutionTimeInMilliseconds() throws InterruptedException {
        long startTime = System.nanoTime();

        // sleep for 5 seconds
        TimeUnit.SECONDS.sleep(5);

        long endTime = System.nanoTime();

        // get the difference between the two nano time values
        long timeElapsed = endTime - startTime;

        return (timeElapsed / 1000000);
    }
}

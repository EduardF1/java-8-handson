package streams;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class StreamsSequentialAndParallel2 {
    private static final Logger logger = LogManager.getLogger(StreamsSequentialAndParallel2.class);
    private static final String LABEL_1 = "Sum (sequential) stream :";
    private static final String LABEL_2 = "Sum (parallel) stream :";
    private static final int[] RANGE_BOUNDS = {0, 1000000};

    public static void main(String[] args) {
        BasicConfigurator.configure();

        //  logger.info(LABEL_1 + getSumUsingSequentialStream());
        //  logger.info(LABEL_1 + getSumUsingParallelStream());
        logger.info(LABEL_1 + checkPerformance(StreamsSequentialAndParallel2::getSumUsingSequentialStream, 25));
        logger.info(LABEL_2 + checkPerformance(StreamsSequentialAndParallel2::getSumUsingParallelStream, 25));
    }

    private static long checkPerformance(Supplier<Integer> sum, int executionTimes) {
        long start = System.currentTimeMillis();
        for (int i = 0; i <= executionTimes; i++) {
            sum.get();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static int getSumUsingSequentialStream() {
        return IntStream.rangeClosed(RANGE_BOUNDS[0], RANGE_BOUNDS[1]).sum();
    }

    private static int getSumUsingParallelStream() {
        return IntStream.rangeClosed(RANGE_BOUNDS[0], RANGE_BOUNDS[1]).parallel().sum();
    }
}

package streams;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelWhenNotToUse {
    private static final Logger LOGGER = LogManager.getLogger(ParallelWhenNotToUse.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        LOGGER.info(getSequentialSum(getNumbers()));
        LOGGER.info(getParallelSum(getNumbers()));
    }

    private static List<Integer> getNumbers(){
        return IntStream.rangeClosed(1, 10000).boxed().collect(Collectors.toList());
    }

    private static int getSequentialSum(List<Integer> list){
        long startTime = System.currentTimeMillis();
        int total = list.stream()
                .reduce(0, Integer::sum);
        long endTime = System.currentTimeMillis();
        LOGGER.info("Sequential Duration :" + (endTime - startTime));
        return total;
    }

    private static int getParallelSum(List<Integer> list){
        long startTime = System.currentTimeMillis();
        int total = list.parallelStream()
                .reduce(0, Integer::sum);
        long endTime = System.currentTimeMillis();
        LOGGER.info("Parallel Duration :" + (endTime - startTime));
        return total;
    }
}

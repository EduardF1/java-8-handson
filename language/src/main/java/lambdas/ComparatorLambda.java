package lambdas;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class ComparatorLambda {
    private static final Logger logger = LogManager.getLogger(ComparatorLambda.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info(compareJava7(10, 12));
    }

    private static String compareJava7(int x, int y) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return x.compareTo(y);
            }
        };
        return getOutput(comparator.compare(x, y), x, y);
    }

    private static String getOutput(int flag, int x, int y) {
        return flag == 1 ? String.format("The value of x = %d is greater than y = %d", x, y) : String.format("The value of x = %d is lower than y = %d", x, y);
    }
}

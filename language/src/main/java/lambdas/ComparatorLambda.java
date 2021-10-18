package lambdas;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class ComparatorLambda {
    private static final Logger LOGGER = LogManager.getLogger(ComparatorLambda.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        LOGGER.info(compareJava7(12, 12));
        LOGGER.info(compareJava8(1,1));
    }

    private static String compareJava8(int m, int n) {
        /*
        alternatively, define implementation:
            a)  (Integer x, Integer y) -> x.compareTo(y)
            b)  (x, y) -> x.compareTo(y)
         */
        Comparator<Integer> comparator = Integer::compareTo;
        return getOutput(comparator.compare(m,n), m, n);
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
        switch (flag) {
            case -1:
                return String.format("The value of x = %d is lower than y = %d", x, y);
            case 0:
                return String.format("The value of x = %d is equal to y = %d", x, y);
            case 1:
                return String.format("The value of x = %d is greater than y = %d", x, y);
            default:
                break;
        }
        return "";
    }
}

package method_reference;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class SimpleMethodReference {
    private static final Logger LOGGER = LogManager.getLogger(SimpleMethodReference.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        LOGGER.info("Result one:" + SimpleMethodReference.compare(10, 20));
        Comparator<Integer> comparator = SimpleMethodReference :: compare;
        LOGGER.info("Result two:" + comparator.compare(10,20));
    }

    public static int compare(Integer x, Integer y){
        return Integer.compare(x, y);
    }
}

package funtional_interfaces.bi_consumer;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class SimpleBiConsumer {
    private static final Logger logger = LogManager.getLogger(SimpleBiConsumer.class);
    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String DIVIDE = "/";
    private static final String MULTIPLY = "*";
    private static final String MODULO = "%";


    public static void main(String[] args) {
        BasicConfigurator.configure();

        BiConsumer<Integer, Integer> addConsumer = (a, b) -> logger.info(getOutput(a, b, ADD));
        BiConsumer<Integer, Integer> subConsumer = (a,b) -> logger.info(getOutput(a,b, SUBTRACT));
        BiConsumer<Integer, Integer> mulConsumer = (a,b) -> logger.info(getOutput(a,b, MULTIPLY));

        // Sequential explicit calls
        subConsumer.accept(10, 20);
        addConsumer.accept(10, 20);
        mulConsumer.accept(10,20);

        // Chained Sequential calls
        addConsumer.andThen(subConsumer).andThen(mulConsumer).accept(10, 20);

        List<Integer> listOne = Arrays.asList(10, 20, 30);
        List<Integer> listTwo = Arrays.asList(10, 10, 20);
        BiConsumer<List<Integer>, List<Integer>> listComparerConsumer = (l1, l2) -> compareListSizes(listOne, listTwo);
        listComparerConsumer.accept(listOne, listTwo);
    }


    private static void compareListSizes(List<Integer> list1, List<Integer> list2) {
        logger.info(list1.size() == list2.size());
    }

    private static String getOutput(int a, int b, String operand) {
        switch (operand){
            case MODULO:
                return String.format("The result of the modulo is %d", a % b);
            case SUBTRACT:
                return String.format("The result of the subtraction is %d", a - b);
            case ADD:
                return String.format("The result of the addition is %d", a + b);
            case MULTIPLY:
                return String.format("The result of the multiplication is %d", a * b);
            case DIVIDE:
                return String.format("The result of the division is %d", a / b);
            default:
                break;
        }
        return "";
    }
}

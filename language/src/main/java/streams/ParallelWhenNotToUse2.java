package streams;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.stream.IntStream;

public class ParallelWhenNotToUse2 {
    private static final Logger LOGGER = LogManager.getLogger(ParallelWhenNotToUse2.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        Calculation calculation = new Calculation();

        IntStream.rangeClosed(0, 2000).forEach(calculation::calculate);
        LOGGER.info("Sequential result: " + calculation.getTotal());

        IntStream.rangeClosed(0, 2000).parallel().forEach(calculation::calculate);
        LOGGER.info("Parallel result: " + calculation.getTotal());
    }
}

class Calculation{
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total){
        this.total = total;
    }

    public void calculate(int input){
        total += input;
    }
}

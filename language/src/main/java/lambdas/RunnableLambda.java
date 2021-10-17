package lambdas;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class RunnableLambda {
    private static final Logger logger = LogManager.getLogger(RunnableLambda.class);
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);
    private static final String TAB = "\t";
    private static final String THREAD = "Thread";

    public static void main(String[] args) {
        BasicConfigurator.configure();
        runThreadJava7(THREAD);
        runThreadJava8(THREAD, false, "");
        runThreadJava8(THREAD, false, "");
        runThreadJava8(THREAD, true, THREAD);
    }

    private static void runThreadJava7(String output) {
        Runnable thread = new Runnable() {
            @Override
            public void run() {
                logger.info(output + TAB + getId());
            }
        };
        new Thread(thread).start();
    }

    private static void runThreadJava8(String output, boolean shouldCreateInnerThread, String innerThreadOutput) {
        new Thread(() -> logger.info(output + TAB + getId())).start();
        if(shouldCreateInnerThread){
            new Thread(() -> logger.info(innerThreadOutput + TAB + getId())).start();
        }
    }

    private static int getId() {
        return ID_GENERATOR.getAndIncrement();
    }
}

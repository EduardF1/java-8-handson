package features;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java7vs8Example2 {
    private static final Logger logger = LogManager.getLogger(Java7vs8Example2.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info(getUniqueNamesJava8(getNames()));
    }

    private static List<String> getNames() {
        return Arrays.asList("John", "Dave", "Dwayne", "Karl", "John");
    }

    private static List<String> getUniqueNamesJava7(List<String> names) {
        List<String> uniqueList = new ArrayList<>();
        for (String name : names) {
            if (!uniqueList.contains(name)) {
                uniqueList.add(name);
            }
        }
        return uniqueList;
    }

    private static List<String> getUniqueNamesJava8(List<String> names){
        return names.stream().distinct().collect(Collectors.toList());
    }
}

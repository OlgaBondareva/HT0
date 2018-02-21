import org.apache.logging.log4j.LogManager;

import java.util.LinkedList;

public class Logger {

    private static final org.apache.logging.log4j.Logger checkSumLogger = LogManager.getLogger();
    private LinkedList<String> copies;

    public Logger() {
        copies = new LinkedList<>();
    }

    public void addCopy(String copy) {
        copies.add(copy);
    }

    public void getCopiesLog() {
        checkSumLogger.info("Дубликаты: ");
        for (String s : copies) {
            checkSumLogger.info("+ " + s);
        }
    }

}

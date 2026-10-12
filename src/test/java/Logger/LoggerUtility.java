package Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.io.*;

public class LoggerUtility {

    private static final String suiteLogsPath = "target/logs/suite/";
    private static final String regressionLogsPath = "target/logs/suites/";

    private static final Logger logger = LogManager.getLogger(LoggerUtility.class);

    public static synchronized void startTestCase(String testName) {

        ThreadContext.put("testName", testName);

        logger.info("===== Execution started: " + testName + " =====");
    }

    public static synchronized void endTestCase(String testName) {

        logger.info("===== Execution ended: " + testName + " =====");

        ThreadContext.remove("testName");
    }

    public static synchronized void infoTestCase(String messageName) {

        logger.info(Thread.currentThread().getName() + " " + getCallInfo() + " " + messageName);
    }

    public static synchronized void errorLog(String message) {

        logger.error(Thread.currentThread().getName() + " " + getCallInfo() + " " + message);
    }

    public static synchronized String getCallInfo() {

        String className =
                Thread.currentThread()
                        .getStackTrace()[3]
                        .getClassName();

        String methodName = Thread.currentThread().getStackTrace()[3]
                .getMethodName();

        return className + " : " + methodName + " => ";
    }

    public static void mergeFiles() {

        File dir = new File(suiteLogsPath);

        String[] fileNames = dir.list();

        if (fileNames == null) {
            return;
        }

        File regressionDir = new File(regressionLogsPath);

        if (!regressionDir.exists()) {
            regressionDir.mkdirs();
        }

        try (PrintWriter pw =
                     new PrintWriter(regressionLogsPath + "RegressionLogs.log")) {

            for (String fileName : fileNames) {

                File file = new File(dir, fileName);

                try (BufferedReader br =
                             new BufferedReader(new FileReader(file))) {

                    pw.println("Content " + fileName);

                    String line;

                    while ((line = br.readLine()) != null) {
                        pw.println(line);
                    }

                    pw.flush();
                }
            }

        } catch (IOException message) {
            System.out.println(message.getMessage());
        }
    }
}
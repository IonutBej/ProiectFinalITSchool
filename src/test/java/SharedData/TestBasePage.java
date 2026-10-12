package SharedData;

import Logger.LoggerUtility;
import SharedData.Browser.BrowserFactory;
import org.openqa.selenium.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import com.aventstack.chaintest.plugins.ChainTestListener;

public class TestBasePage {
    protected WebDriver driver;
    private String testName;

    @BeforeMethod
    // Se executa inainte de @Test de fiecare data

    public void initialiseBrowser() {

        testName = this.getClass().getSimpleName();
        LoggerUtility.startTestCase(testName);
        driver = new BrowserFactory().getBrowserFactory();
        driver.get("https://webdriveruniversity.com/");
        LoggerUtility.infoTestCase("===== The browser started successfully");
    }

    @AfterMethod
    public void clearBrowser(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE && result.getThrowable() != null) {

            LoggerUtility.errorLog(result.getThrowable().getMessage());

            try {

                try {

                    Alert alert = driver.switchTo().alert();
                    String alertText = alert.getText();
                    LoggerUtility.infoTestCase("Alert was open on failure: " + alertText);
                    alert.accept();

                } catch (NoAlertPresentException ignored) {

                    LoggerUtility.infoTestCase("No alert was present on failure");
                }

                    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

                    ChainTestListener.embed(screenshot, "image/png");

                    LoggerUtility.infoTestCase("Screenshot was captured for failed test");

                } catch (Exception exception) {

                    LoggerUtility.errorLog("Screenshot could not be captured: " + exception.getMessage()
                    );
                }

        }

        if (driver != null) {

            driver.quit();
            LoggerUtility.infoTestCase("===== The browser closed successfully");
        }
        LoggerUtility.endTestCase(testName);
    }

    @AfterSuite
    public void mergeLogs() {
        LoggerUtility.mergeFiles();
    }
    public WebDriver getDriver() {
        return driver;
    }
}

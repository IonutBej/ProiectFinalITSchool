package Tests;

import Logger.LoggerUtility;
import SharedData.TestBasePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ReportFailureTest extends TestBasePage {

    @Test(description = "Intentional failure test")
    public void intentionalFailureTest() {

        LoggerUtility.infoTestCase("Starting failure test");

        driver.findElement(
                By.xpath("//missing-element")
        ).click();
    }
}
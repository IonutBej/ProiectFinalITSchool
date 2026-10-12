package HelperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods{

    private final WebDriver driver;
    private final WebDriverWait wait;


 public AlertMethods(WebDriver driver) {
     this.driver = driver;
     this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

 }

public String getAlertText(){
    wait.until(ExpectedConditions.alertIsPresent());

    Alert alert = driver.switchTo().alert();
    return alert.getText();

}
public void acceptAlert(){
     wait.until(ExpectedConditions.alertIsPresent());
     Alert alert = driver.switchTo().alert();
     alert.accept();
}
}
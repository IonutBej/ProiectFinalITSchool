package Pages;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.WindowMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class CommonPage {

   protected WebDriver driver;
   protected ElementsMethods elementsMethods;
   public WindowMethods windowMethods;
   protected AlertMethods alertMethods;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.windowMethods = new WindowMethods(driver);
        this.alertMethods = new AlertMethods(driver);
        PageFactory.initElements(driver, this);
    }
}
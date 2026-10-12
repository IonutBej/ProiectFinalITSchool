package Pages;


import Logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends CommonPage {


    @FindBy(xpath = "//h1[text()='CONTACT US']")
    WebElement contactUsButton;

    @FindBy(xpath = "//h1[text()='LOGIN PORTAL']")
    WebElement loginPortalButton;

    @FindBy(xpath = "//h1[text()='TO DO LIST']")
    WebElement toDoListButton;

    @FindBy(xpath = "//h1[text()='DROPDOWNS, CHECKBOXES & RADIOS']")
    WebElement dropdownsCheckboxesRadiosButton;

    @FindBy(xpath = "//h1[text()='ACTIONS']")
    private WebElement actionsButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickContactUs() {
        elementsMethods.clickOnElement(contactUsButton);
        LoggerUtility.infoTestCase("User clicked Contact Us");
    }

    public void clickLoginPortal() {
        elementsMethods.clickOnElement(loginPortalButton);
        LoggerUtility.infoTestCase("User clicked Login Portal");
    }


    public void openLoginPortal() {
        elementsMethods.clickOnElement(loginPortalButton);
        LoggerUtility.infoTestCase("User clicked Login Portal");
        windowMethods.switchToNewTab();
        LoggerUtility.infoTestCase("User switched to Login Portal tab");
    }
    public void openToDoList() {
        elementsMethods.clickOnElement(toDoListButton);
        LoggerUtility.infoTestCase("User clicked To Do List");
        windowMethods.switchToNewTab();
        LoggerUtility.infoTestCase("User switched to To Do List tab");
    }
    public void openDropdownsCheckboxesRadios(){
        elementsMethods.clickOnElement(dropdownsCheckboxesRadiosButton);
        LoggerUtility.infoTestCase("User clicked on Dropdowns Checkboxes Radios");
        windowMethods.switchToNewTab();
        LoggerUtility.infoTestCase("User switched to Dropdowns Checkboxes Radios tab");
    }
    public void openActionsPage() {
        elementsMethods.clickOnElement(actionsButton);
        LoggerUtility.infoTestCase("User clicked on Actions");
        windowMethods.switchToNewTab();
        LoggerUtility.infoTestCase("User switched to Actions tab");
    }
}

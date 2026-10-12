package Pages;

import Logger.LoggerUtility;
import ObjectData.ContactUsObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContactUsPage extends CommonPage {

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "first_name")
    private WebElement firstNameField;

    @FindBy(name = "last_name")
    private WebElement lastNameField;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "message")
    private WebElement messageField;

    @FindBy(xpath = "//input[@type='submit' and @value='SUBMIT']")
    private WebElement submitButton;

    @FindBy(xpath = "//h1[contains(text(),'Thank You for your Message!')]")
    private WebElement successMessage;

    @FindBy(xpath = "//a[contains(text(),'Back to Homepage')]")
    private WebElement backToHomepageButton;

    @FindBy(xpath = "//body[contains(.,'Error: Invalid email address')]")
    private WebElement invalidEmailMessage;

    public void addEntry(ContactUsObject data) {

        enterFirstName(data.getFirstName());
        LoggerUtility.infoTestCase("User entered First Name");

        enterLastName(data.getLastName());
        LoggerUtility.infoTestCase("User entered Last Name");

        enterEmail(data.getEmail());
        LoggerUtility.infoTestCase("User entered Email");

        enterMessage(data.getMessage());
        LoggerUtility.infoTestCase("User entered Message");

        clickOnSubmitButton();
        LoggerUtility.infoTestCase("User clicked on submit button");
    }

    public void enterFirstName(String firstName) {
        elementsMethods.enterText(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        elementsMethods.enterText(lastNameField, lastName);
    }

    public void enterEmail(String email) {
        elementsMethods.enterText(emailField, email);
    }

    public void enterMessage(String message) {
        elementsMethods.enterText(messageField, message);
    }

    public void clickOnSubmitButton() {
        elementsMethods.clickOnElement(submitButton);
    }

    public void verifySuccessMessage() {

        Assert.assertEquals(successMessage.getText(), "Thank You for your Message!"
        );

        LoggerUtility.infoTestCase("Success message was displayed");
    }

    public void verifyInvalidEmailMessage() {

        Assert.assertTrue(invalidEmailMessage.getText().contains("Error: Invalid email address"), "Invalid email error message was not displayed");

        LoggerUtility.infoTestCase("Invalid email message was validated successfully");
    }

    public void clickBackToHomepage() {

        elementsMethods.clickOnElement(backToHomepageButton);

        LoggerUtility.infoTestCase("User returned to Homepage");
    }
}
package Pages;

import Logger.LoggerUtility;
import ObjectData.LoginObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CommonPage {

    @FindBy(id = "text")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void enterUsername(String username){
        elementsMethods.enterText(usernameField, username);
        LoggerUtility.infoTestCase("User entered username");
    }

    public void enterPassword(String password){
        elementsMethods.enterText(passwordField, password);
        LoggerUtility.infoTestCase("User entered password");
    }

    public void clickLoginButton(){
        elementsMethods.clickOnElement(loginButton);
        LoggerUtility.infoTestCase("User clicked on Login Button");
    }

    public void login(LoginObject data){
        enterUsername(data.getUsername());
        enterPassword(data.getPassword());
        clickLoginButton();
    }

    public String getAlertMessage(){
        String alertMessage = alertMethods.getAlertText();
        LoggerUtility.infoTestCase("Alert message: " + alertMessage);
        return alertMessage;
    }
    public void acceptLoginAlert(){
        alertMethods.acceptAlert();
        LoggerUtility.infoTestCase("Login alert was accepted");
    }



}

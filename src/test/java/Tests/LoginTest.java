package Tests;

import Logger.LoggerUtility;
import ObjectData.LoginObject;
import Pages.HomePage;
import Pages.LoginPage;
import SharedData.TestBasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import XmlDataLoader.XmlDataLoader;

import java.util.Map;


public class LoginTest extends TestBasePage {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        Map<String, LoginObject> loginData = XmlDataLoader.loadData("src/test/resources/LoginData.xml", LoginObject.class);

        return new Object[][]{
                {loginData.get("dataSet1"), "validation succeeded"},
                {loginData.get("dataSet2"), "validation failed"}};
    }

    @Test(dataProvider = "loginData", description = "Verify login with valid and invalid credentials")
    public void loginTest(LoginObject data, String expectedMessage) {

        LoggerUtility.infoTestCase("Starting login scenario for username: " + data.getUsername());

        HomePage homePage = new HomePage(driver);
        homePage.openLoginPortal();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(data);
        String actualMessage = loginPage.getAlertMessage();

        Assert.assertEquals(actualMessage, expectedMessage);
        LoggerUtility.infoTestCase("Login message was validated successfully");
        loginPage.acceptLoginAlert();
    }
}
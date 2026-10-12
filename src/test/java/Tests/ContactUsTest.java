package Tests;

import HelperMethods.WindowMethods;
import Logger.LoggerUtility;
import ObjectData.ContactUsObject;
import Pages.ContactUsPage;
import Pages.HomePage;
import SharedData.TestBasePage;
import XmlDataLoader.XmlDataLoader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import DataBase.Queries.ContactUsTable;
import org.testng.Assert;
import java.sql.SQLException;

import java.util.Map;

public class ContactUsTest extends TestBasePage {

    @DataProvider(name = "contactUsData")
    public Object[][] contactUsData() {

        Map<String, ContactUsObject> contactData =
                XmlDataLoader.loadData("src/test/resources/ContactUsData.xml", ContactUsObject.class);

        return new Object[][]{
                {contactData.get("dataSet1"), true},
                {contactData.get("dataSet2"), false}};
    }

    @Test(
            dataProvider = "contactUsData",
            description = "Verify Contact Us form with valid and invalid email"
    )
    public void contactUsTest(
            ContactUsObject data,
            boolean validEmail

    ) throws SQLException {

        LoggerUtility.infoTestCase("Starting Contact Us scenario for email: " + data.getEmail());

        HomePage homePage = new HomePage(driver);

        WindowMethods windowMethods = new WindowMethods(driver);
        homePage.clickContactUs();
        windowMethods.switchToNewTab();
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.addEntry(data);

        if (validEmail) {

            contactUsPage.verifySuccessMessage();
            LoggerUtility.infoTestCase("Valid Contact Us scenario was validated successfully");
            contactUsPage.clickBackToHomepage();

        } else {

            contactUsPage.verifyInvalidEmailMessage();
            LoggerUtility.infoTestCase("Invalid Contact Us scenario was validated successfully");
        }
        ContactUsTable contactUsTable = new ContactUsTable();
        contactUsTable.insertContactUsData(data);

        Assert.assertTrue(contactUsTable.isContactUsDataPresent(data), "Contact Us data was not found in database");
        LoggerUtility.infoTestCase("Contact Us data was validated in database");
    }
}
package Tests;

import Logger.LoggerUtility;
import Pages.DropdownCheckboxRadioPage;
import Pages.HomePage;
import SharedData.TestBasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownCheckboxRadioTest extends TestBasePage {

    @Test(description = "Verify dropdown selection")

    public void dropdownTest(){
        LoggerUtility.infoTestCase("Starting dropdown scenario");

        HomePage homePage = new HomePage(driver);
        homePage.openDropdownsCheckboxesRadios();

        DropdownCheckboxRadioPage page = new DropdownCheckboxRadioPage(driver);

        page.selectFromDropdown("JAVA");

        Assert.assertEquals(page.getSelectedDropdownOption(), "JAVA");

        LoggerUtility.infoTestCase("Dropdown selection was validated succesfully");
    }

    @Test(description = "Verify checkbox selection")

    public void checkboxTest(){

        LoggerUtility.infoTestCase("Starting checkbox scenario");

        HomePage homePage = new HomePage(driver);
        homePage.openDropdownsCheckboxesRadios();

        DropdownCheckboxRadioPage page = new DropdownCheckboxRadioPage(driver);
        page.selectCheckbox();

        Assert.assertTrue(page.isCheckboxSelected(), "Checkbox was not selected");
        LoggerUtility.infoTestCase("Checkbox selection was validated successfully");
    }

    @Test(description = "Verify radio button selection")

    public void radioButtonTest(){

        LoggerUtility.infoTestCase("Starting radio button scenario");

        HomePage homePage = new HomePage(driver);

        homePage.openDropdownsCheckboxesRadios();
        DropdownCheckboxRadioPage page = new DropdownCheckboxRadioPage(driver);
        page.selectGreenRadioButton();

        Assert.assertTrue(page.isGreenRadioButtonSelected(), "Green radio button was not selected");
        LoggerUtility.infoTestCase("Radio button selection was validated successfully");
    }
    @Test(description = "Verify Pumpkin is selected by default")
    public void pumpkinSelectedTest() {

        LoggerUtility.infoTestCase("Starting default selected vegetable scenario");

        HomePage homePage = new HomePage(driver);
        homePage.openDropdownsCheckboxesRadios();
        DropdownCheckboxRadioPage page = new DropdownCheckboxRadioPage(driver);

        Assert.assertTrue(page.isPumpkinSelected(), "Pumpkin was not selected by default");
        LoggerUtility.infoTestCase("Pumpkin default selection was validated successfully");
    }

    @Test(description = "Verify fruit dropdown selection")
    public void fruitDropdownTest() {

        LoggerUtility.infoTestCase("Starting fruit dropdown scenario");

        HomePage homePage = new HomePage(driver);
        homePage.openDropdownsCheckboxesRadios();
        DropdownCheckboxRadioPage page = new DropdownCheckboxRadioPage(driver);
        page.selectFruit("Grape");

        Assert.assertEquals(page.getSelectedFruit(), "Grape");
        LoggerUtility.infoTestCase("Fruit dropdown selection was validated successfully");
    }
}




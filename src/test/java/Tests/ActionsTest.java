package Tests;

import Logger.LoggerUtility;
import Pages.ActionsPage;
import Pages.HomePage;
import SharedData.TestBasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsTest extends TestBasePage {

    @Test(description = "Verify drag and drop action")
    public void dragAndDropTest() {

        LoggerUtility.infoTestCase("Starting drag and drop scenario");

        HomePage homePage = new HomePage(driver);

        homePage.openActionsPage();
        ActionsPage actionsPage = new ActionsPage(driver);
        actionsPage.dragAndDrop();

        Assert.assertEquals(actionsPage.getDropAreaText(), "Dropped!");
        LoggerUtility.infoTestCase("Drag and drop was validated successfully");
    }

    @Test(description = "Verify double click action")
    public void doubleClickTest() {

        LoggerUtility.infoTestCase("Starting double click scenario");

        HomePage homePage = new HomePage(driver);
        homePage.openActionsPage();
        ActionsPage actionsPage = new ActionsPage(driver);
        actionsPage.doubleClick();

        Assert.assertTrue(actionsPage.getDoubleClickClass().contains("double"), "Double click was not activated");
        LoggerUtility.infoTestCase("Double click was validated successfully");
    }

    @Test(description = "Verify hover action")
    public void hoverTest() {

        LoggerUtility.infoTestCase("Starting hover scenario");

        HomePage homePage = new HomePage(driver);
        homePage.openActionsPage();
        ActionsPage actionsPage = new ActionsPage(driver);
        actionsPage.hoverOverFirstButton();

        Assert.assertTrue(actionsPage.isFirstHoverContentDisplayed(), "Hover content was not displayed");
        LoggerUtility.infoTestCase("Hover action was validated successfully");
    }

    @Test(description = "Verify click and hold action")
    public void clickAndHoldTest() {

        LoggerUtility.infoTestCase("Starting click and hold scenario");

        HomePage homePage = new HomePage(driver);
        homePage.openActionsPage();
        ActionsPage actionsPage = new ActionsPage(driver);
        actionsPage.clickAndHold();

        Assert.assertTrue(actionsPage.getClickAndHoldText().contains("Well done"), "Click and hold action was not activated");
        actionsPage.releaseClickAndHold();
        LoggerUtility.infoTestCase("Click and hold was validated successfully");
    }
}
package Pages;

import Logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ActionsPage extends CommonPage {

    public ActionsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    private WebElement draggableElement;

    @FindBy(id = "droppable")
    private WebElement droppableElement;

    @FindBy(id = "double-click")
    private WebElement doubleClickElement;

    @FindBy(xpath = "//button[text()='Hover Over Me First!']")
    private WebElement firstHoverButton;

    @FindBy(xpath = "//button[text()='Hover Over Me First!']/following-sibling::div")
    private WebElement firstHoverContent;

    @FindBy(id = "click-box")
    private WebElement clickAndHoldElement;


    public void dragAndDrop() {

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggableElement, droppableElement).perform();
        LoggerUtility.infoTestCase("Drag and drop action was performed");
    }

    public String getDropAreaText() {
        return droppableElement.getText().trim();
    }

    public void doubleClick() {

        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickElement).perform();
        LoggerUtility.infoTestCase("Double click action was performed");
    }

    public String getDoubleClickClass() {
        return doubleClickElement.getAttribute("class");
    }

    public void hoverOverFirstButton() {

        Actions actions = new Actions(driver);
        actions.moveToElement(firstHoverButton).perform();
        LoggerUtility.infoTestCase("Hover action was performed");
    }

    public boolean isFirstHoverContentDisplayed() {
        return firstHoverContent.isDisplayed();
    }

    public void clickAndHold() {

        Actions actions = new Actions(driver);
        actions.clickAndHold(clickAndHoldElement).perform();
        LoggerUtility.infoTestCase("Click and hold action was performed");
    }

    public String getClickAndHoldText() {
        return clickAndHoldElement.getText().trim();}

    public void releaseClickAndHold() {

        Actions actions = new Actions(driver);
        actions.release().perform();
        LoggerUtility.infoTestCase("Click and hold action was released");
    }
}
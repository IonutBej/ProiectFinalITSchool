package Pages;

import Logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownCheckboxRadioPage extends CommonPage {

    public DropdownCheckboxRadioPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "dropdowm-menu-1")
    private WebElement firstDropdown;

    @FindBy(xpath = "//input[@type='checkbox' and @value='option-1']")
    private WebElement option1Checkbox;

    @FindBy(xpath = "//input[@type='radio' and @name='color' and @value='green']")
    private WebElement greenRadioButton;

    @FindBy(xpath = "//input[@type='radio' and @name='vegetable' and @value='pumpkin']")
    private WebElement pumpkinRadioButton;

    @FindBy(id = "fruit-selects")
    private WebElement fruitDropdown;


    public void selectFromDropdown(String visibleText){

        Select select = new Select(firstDropdown);
        select.selectByVisibleText(visibleText);
        LoggerUtility.infoTestCase("Selected drop down option: " + visibleText);
    }

    public String getSelectedDropdownOption(){
        Select select = new Select(firstDropdown);
        return select.getFirstSelectedOption().getText();

    }
    public void selectCheckbox() {
        if (!option1Checkbox.isSelected()) {
            elementsMethods.clickOnElement(option1Checkbox);
            LoggerUtility.infoTestCase("Checkbox Option 1 was selected");
        }
    }

        public boolean isCheckboxSelected(){
            return option1Checkbox.isSelected();
        }
        public void selectGreenRadioButton(){
            elementsMethods.clickOnElement(greenRadioButton);
            LoggerUtility.infoTestCase("Green radio button was selected");
        }
        public boolean isGreenRadioButtonSelected(){
            return greenRadioButton.isSelected();
        }
        public boolean isPumpkinSelected() {
            return pumpkinRadioButton.isSelected();
        }
        public void selectFruit(String visibleText) {

            Select select = new Select(fruitDropdown);
            select.selectByVisibleText(visibleText);

            LoggerUtility.infoTestCase("Selected fruit: " + visibleText);
        }
        public String getSelectedFruit() {

            Select select = new Select(fruitDropdown);

            return select.getFirstSelectedOption().getText();
    }

}

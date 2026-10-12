package Pages;

import Logger.LoggerUtility;
import ObjectData.ToDoListObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ToDoListPage extends CommonPage {

    @FindBy(xpath = "//input[@placeholder='Add new todo']")
    private WebElement addNewTodoField;

    @FindBy(xpath = "//ul/li")
    private List<WebElement> todoItems;

    public ToDoListPage(WebDriver driver) {
        super(driver);
    }

    public void addNewTodo(ToDoListObject data) {

        addNewTodoField.sendKeys(data.getTaskName());
        addNewTodoField.sendKeys(Keys.ENTER);

        LoggerUtility.infoTestCase(
                "New todo was added: " + data.getTaskName()
        );
    }

    public boolean isTodoDisplayed(String taskName) {

        return todoItems.stream().anyMatch(item -> item.getText().trim().equals(taskName));
    }
    public void markTodoAsCompleted(String taskName) {

        for (WebElement item : todoItems) {

            if (item.getText().trim().equals(taskName)) {

                elementsMethods.clickOnElement(item);

                LoggerUtility.infoTestCase("Todo marked as completed: " + taskName);

                break;
            }
        }
    }
    public boolean isTodoCompleted(String taskName) {

        for (WebElement item : todoItems) {

            if (item.getText().trim().equals(taskName)) {

                String classAttribute = item.getAttribute("class");

                return classAttribute != null && classAttribute.contains("completed");
            }
        }
        return false;
    }

    public boolean isTodoPresent(String taskName) {

        return todoItems.stream().anyMatch(item -> item.getText().trim().equals(taskName));
    }
    public void deleteTodo(String taskName) {

        for (WebElement item : todoItems) {

            if (item.getText().trim().equals(taskName)) {

                Actions actions = new Actions(driver);
                actions.moveToElement(item).perform();

                WebElement deleteButton = item.findElement(By.xpath(".//span/i[contains(@class,'fa-trash')]"));

                elementsMethods.clickOnElement(deleteButton);

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

                wait.until(ExpectedConditions.stalenessOf(item));

                LoggerUtility.infoTestCase("Todo was deleted: " + taskName);

                break;
            }
        }
    }
}
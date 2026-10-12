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

        LoggerUtility.infoTestCase("New todo was added: " + data.getTaskName());
    }

    public boolean isTodoDisplayed(String taskName) {

        return findTodoByName(taskName) != null;
    }

    public void markTodoAsCompleted(String taskName) {

        WebElement todoItem = findTodoByName(taskName);

        if (todoItem != null) {

            elementsMethods.clickOnElement(todoItem);

            LoggerUtility.infoTestCase("Todo marked as completed: " + taskName);
        }
    }

    public boolean isTodoCompleted(String taskName) {

        WebElement todoItem = findTodoByName(taskName);

        if (todoItem == null) {
            return false;
        }

        String classAttribute = todoItem.getAttribute("class");

        return classAttribute != null && classAttribute.contains("completed");
    }

    public boolean isTodoPresent(String taskName) {

        return findTodoByName(taskName) != null;
    }

    public void deleteTodo(String taskName) {

        WebElement todoItem = findTodoByName(taskName);

        if (todoItem == null) {
            return;
        }

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        Actions actions = new Actions(driver);

        actions.moveToElement(todoItem).pause(Duration.ofMillis(500)).perform();

        WebElement deleteButton = wait.until(driver -> {

            WebElement button = todoItem.findElement(By.xpath(".//span/i[contains(@class,'fa-trash')]"));

            if (button.isDisplayed() && button.isEnabled()) {
                return button;
            }
            return null;
        });

        deleteButton.click();

        wait.until(ExpectedConditions.stalenessOf(todoItem));

        LoggerUtility.infoTestCase("Todo was deleted: " + taskName);
    }

    private WebElement findTodoByName(String taskName) {

        for (WebElement item : todoItems) {

            if (item.getText().trim().equals(taskName)) {
                return item;
            }
        }

        return null;
    }
}
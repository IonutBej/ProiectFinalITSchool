package Tests;

import Logger.LoggerUtility;
import ObjectData.ToDoListObject;
import Pages.HomePage;
import Pages.ToDoListPage;
import SharedData.TestBasePage;
import XmlDataLoader.XmlDataLoader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class ToDoListTest extends TestBasePage {

    @DataProvider(name = "todoData")
    public Object[][] todoData() {

        Map<String, ToDoListObject> todoData = XmlDataLoader.loadData("src/test/resources/ToDoData.xml", ToDoListObject.class);

        return new Object[][]{
                {todoData.get("dataSet1")},
                {todoData.get("dataSet2")},
                {todoData.get("dataSet3")}
        };
    }

    @Test(
            dataProvider = "todoData",
            description = "Verify that a new todo can be added"
    )
    public void addNewTodoTest(ToDoListObject data) {

        LoggerUtility.infoTestCase("Starting add new todo scenario: " + data.getTaskName());

        HomePage homePage = new HomePage(driver);
        homePage.openToDoList();
        ToDoListPage toDoListPage = new ToDoListPage(driver);
        toDoListPage.addNewTodo(data);

        Assert.assertTrue(toDoListPage.isTodoDisplayed(data.getTaskName()), "The new todo was not displayed in the list");
        LoggerUtility.infoTestCase("New todo was successfully validated: " + data.getTaskName());
    }

    @Test(
            dataProvider = "todoData",
            description = "Verify that a todo can be marked as completed"
    )
    public void markTodoAsCompletedTest(ToDoListObject data) {

        LoggerUtility.infoTestCase("Starting mark todo as completed scenario: " + data.getTaskName());

        HomePage homePage = new HomePage(driver);
        homePage.openToDoList();
        ToDoListPage toDoListPage = new ToDoListPage(driver);
        toDoListPage.addNewTodo(data);
        toDoListPage.markTodoAsCompleted(data.getTaskName());

        Assert.assertTrue(toDoListPage.isTodoCompleted(data.getTaskName()), "Todo was not marked as completed");
        LoggerUtility.infoTestCase("Todo completion was validated successfully: " + data.getTaskName());
    }

    @Test(
            dataProvider = "todoData",
            description = "Verify that a todo can be deleted"
    )
    public void deleteTodoTest(ToDoListObject data) {

        LoggerUtility.infoTestCase("Starting delete todo scenario: " + data.getTaskName());

        HomePage homePage = new HomePage(driver);
        homePage.openToDoList();
        ToDoListPage toDoListPage = new ToDoListPage(driver);
        toDoListPage.addNewTodo(data);

        Assert.assertTrue(toDoListPage.isTodoPresent(data.getTaskName()), "Todo was not added before delete");
        toDoListPage.deleteTodo(data.getTaskName());

        Assert.assertFalse(toDoListPage.isTodoPresent(data.getTaskName()), "Todo was not deleted");
        LoggerUtility.infoTestCase("Todo deletion was validated successfully: " + data.getTaskName());
    }
}
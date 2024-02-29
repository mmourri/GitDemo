package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TasksApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Todo feature")
public class TodoTest extends BaseTest {

    @Story("Add Todo")
    @Description("It will add a new todo by filling the todo name and submit the creation of the todo")
    @Test(description = "Should be able to add a todo correctly")
    public void shouldBeAbleToAddNewTodo() {



//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.load();
//        TodoPage todoPage = loginPage.login("hatem@example.com", "Test1234");
//        NewTodoPage newTodoPage = todoPage.clickOnPlusBtn();
//        newTodoPage.addNewTask("Selenium Framework");
//        String actualItem = todoPage.getTodoText();
//        Assert.assertEquals(actualItem, "Selenium Framework");

//        LoginPage loginPage = new LoginPage(driver);
//        String actualItem = loginPage
//                .load()
//                .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
//                .clickOnPlusBtn()
//                .addNewTask("Selenium Framework")
//                .getTodoText();

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        NewTodoPage newTodoPage = new NewTodoPage(getDriver());
        newTodoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());

        String actualItem = newTodoPage
                .load()
                .addNewTask("Selenium Framework")
                .getTodoText();

        Assert.assertEquals(actualItem, "Selenium Framework");

    }

    @Story("Delete Todo")
    @Description("It will delete the last created todo and go to the todo page")
    @Test(description = "Should be able to delete a todo correctly")
    public void shouldBeAbleToDeleteTodo() {

//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.load();
//        TodoPage todoPage = loginPage.login("hatem@example.com", "Test1234");
//        NewTodoPage newTodoPage = todoPage.clickOnPlusBtn();
//        newTodoPage.addNewTask("Selenium Framework");
//        todoPage.clickOnDeleteBtn();
//        boolean isNoTodosMessageDisplayed = todoPage.isNoTodosMessageDisplayed();
//        Assert.assertTrue(isNoTodosMessageDisplayed);

//        LoginPage loginPage = new LoginPage(driver);
//        boolean isNoTodosMessageDisplayed = loginPage
//                .load()
//                .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
//                .clickOnPlusBtn()
//                .addNewTask("Selenium Framework")
//                .clickOnDeleteBtn()
//                .isNoTodosMessageDisplayed();

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        TasksApi taskApi = new TasksApi();
        taskApi.addTask(registerApi.getAccesToken());

        TodoPage todoPage = new TodoPage(getDriver());
        todoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());
        boolean isNoTodosMessageDisplayed = todoPage
                .load()
                .clickOnDeleteBtn()
                .isNoTodosMessageDisplayed();

        Assert.assertTrue(isNoTodosMessageDisplayed);

    }

}

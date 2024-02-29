package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {

    public TodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=welcome]")
    private WebElement welcomeMessage;

    @FindBy(css = "[data-testid=add]")
    private WebElement addBtn;

    @FindBy(css = "[data-testid=todo-text]")
    private WebElement todoItem;

    @FindBy(css = "[data-testid=delete]")
    private WebElement deleteBtn;

    @FindBy(css = "[data-testid=no-todos]")
    private WebElement noTodosMessage;

    @Step
    public boolean isWelcomeMessageDisplayed() {
        return welcomeMessage.isDisplayed();
    }

    @Step
    //it will return NewTodoPage
    public NewTodoPage clickOnPlusBtn() {
        addBtn.click();
        return new NewTodoPage(driver);
    }

    @Step
    public String getTodoText() {
        return todoItem.getText();
    }

    @Step
    //it will return TodoPage
    public TodoPage clickOnDeleteBtn() {
        deleteBtn.click();
        return this;
    }

    @Step
    public TodoPage load() {
        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoint.TODO_ENDPOINT);
        return this;
    }

    @Step
    public boolean isNoTodosMessageDisplayed() {
        return noTodosMessage.isDisplayed();
    }

}

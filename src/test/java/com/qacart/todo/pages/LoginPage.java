package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=email]")
    private WebElement emailInput;

    @FindBy(css = "[data-testid=password]")
    private WebElement passwordInput;

    @FindBy(css = "[data-testid=submit]")
    private WebElement submitBtn;

    @Step
    //it will return LoginPage
    public LoginPage load() {

        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoint.LOGIN_ENDPOINT);
        return this;
    }

    @Step
    //it will return TodoPage
    public TodoPage login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitBtn.click();

        return new TodoPage(driver);
    }

}

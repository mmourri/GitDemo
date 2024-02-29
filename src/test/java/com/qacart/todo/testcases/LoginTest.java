package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Auth feature")
public class LoginTest extends BaseTest {

    @Story("Login With Email And Password")
    @Description("It will login by filling the email and password and submit to navigate to the todo page")
    @Test(description = "Test the login functionality using email and password")
    public void shouldBeAbleToLoginWithEmailAndPassword() {

        LoginPage loginPage = new LoginPage(getDriver());
//        loginPage.load();
//        TodoPage todoPage = loginPage.login("hatem@example.com", "Test1234");
//        boolean isWelcomeMessageDisplayed = todoPage.isWelcomeMessageDisplayed();
//        Assert.assertTrue(isWelcomeMessageDisplayed);

        boolean isWelcomeMessageDisplayed =
                loginPage
                        .load()
                        .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                        .isWelcomeMessageDisplayed();
        Assert.assertTrue(isWelcomeMessageDisplayed);

    }

    public void printMsg2() {
        System.out.println("Hello world");
        System.out.println("Hello world");
        System.out.println("Hello world");
    }

}

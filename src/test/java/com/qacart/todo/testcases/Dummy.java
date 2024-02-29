package com.qacart.todo.testcases;


import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Dummy {
    public static void main(String[] args) throws InterruptedException {

//        RegisterApi registerApi = new RegisterApi();
//
//        registerApi.register();
//
//        System.out.println(registerApi.getAccesToken());
//        System.out.println(registerApi.getUserID());
//        System.out.println(registerApi.getFirstName());

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get(ConfigUtils.getInstance().getBaseUrl());
        driver.manage().window().maximize();

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        List<io.restassured.http.Cookie> restAssuredCookies = registerApi.getCookies();

        for(io.restassured.http.Cookie cookie: restAssuredCookies) {
            Cookie seleniumCookie = new Cookie(cookie.getName(), cookie.getValue());
            driver.manage().addCookie(seleniumCookie);
        }

        driver.get(ConfigUtils.getInstance().getBaseUrl());

       Thread.sleep(60000);

       driver.quit();
    }

    public void printMsg() {
        System.out.println("Hello dummy1");
        System.out.println("Hello dummy2");
        System.out.println("Hello dummy3");
        System.out.println("Hello dummy4");

    }

    public void printMsg3() {
        System.out.println("Hello dummy5");
        System.out.println("Hello dummy6");
        System.out.println("Hello dummy7);

    }
}

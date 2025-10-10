package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginFormPO extends BasePagePO {
    
    // Private locator fields
    private By USERNAME_FIELD = By.name("username");
    private By PASSWORD_FIELD = By.name("password");
    private By SUBMIT_BUTTON = By.cssSelector("button[type='submit']");
    private By INVALID_MESSAGE = By.id("invalid");

    public LoginFormPO(WebDriver driver) {
        super(driver);
        visit("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
    }

    public BasePagePO with(String username, String pwd) {
        type(USERNAME_FIELD, username);
        type(PASSWORD_FIELD, pwd);
        click(SUBMIT_BUTTON);
        if (getURL().equals("https://bonigarcia.dev/selenium-webdriver-java/login-form.html"))
            return this;
        else return new LoginSuccessPO(driver);
    }

    public boolean invalidBoxIsPresent() {
        return isIn(INVALID_MESSAGE);
    }
}
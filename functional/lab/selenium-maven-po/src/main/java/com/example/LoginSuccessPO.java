package com.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginSuccessPO extends BasePagePO {
    
    // Private locator field
    private By SUCCESS_BOX = By.id("success");

    public LoginSuccessPO(WebDriver driver) {
        super(driver);
    }

    public boolean validBoxIsPresent() {
        return isIn(SUCCESS_BOX);
    }
}
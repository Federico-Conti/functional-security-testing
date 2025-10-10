package com.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
// All the Selenium WebDriver calls should be in this class! A sort of Domain Specific Language (DSL)

public class BasePagePO {
    protected WebDriver driver;

    public BasePagePO(WebDriver driver) {
        this.driver = driver;
    }

    protected void visit(String url) {
        driver.get(url);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public boolean isIn(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }
}

package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testLoginOk {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void testLoginYes() {
        System.out.println("Login OK");
        String baseUrl = "https://bonigarcia.dev/selenium-webdriver-java/login-form.html";
        driver.get(baseUrl);

        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.id("password")).sendKeys("user");
        driver.findElement(By.xpath("/html/body/main/div/div[4]/div/form/button")).click();

        //The page changes after login 
        System.out.println(driver.getCurrentUrl());

        assertTrue(driver.findElement(By.xpath("//*[@id=\"success\"]")).isDisplayed());
        assertEquals(driver.findElement(By.xpath("//*[@id=\"success\"]")).getText(), "Login successful");

    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

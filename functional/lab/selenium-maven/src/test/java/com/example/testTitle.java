package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testTitle {
    private WebDriver driver;
    private final String baseUrl = "https://bonigarcia.dev/selenium-webdriver-java/";
    private final String expectedTitle = "Hands-On Selenium WebDriver with Java";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void pageTitleShouldMatchExpected() {
        driver.get(baseUrl);
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle, "Page title should match expected value");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

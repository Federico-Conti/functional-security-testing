package Firefox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Helloworld {
    public static void main(String[] args) {
        //Not necessary if we are using Selenium WebDriver > 4.6
        // Imposta il percorso del ChromeDriver
        // System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        // Create the Firefox instance
        WebDriver driver = new FirefoxDriver();

        // Base URL
        String baseUrl = "https://bonigarcia.dev/selenium-webdriver-java/";
        String expectedTitle = "Hands-On Selenium WebDriver with Java";
        String actualTitle = "";

        // Launch Firefox and open the page
        driver.get(baseUrl);

        // Get the page title
        actualTitle = driver.getTitle();

        // Compare expected and actual title
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!");
        }

        // Close Firefox
        driver.quit();
    }
}

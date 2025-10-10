package Edge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Helloworld {
    public static void main(String[] args) {
        //Not necessary if we are using Selenium WebDriver > 4.6
        // Imposta il percorso del EdgeDriver
        // System.setProperty("webdriver.edge.driver", "/usr/bin/msedgedriver");

        // Create the Edge instance
        WebDriver driver = new EdgeDriver();

        // Base URL
        String baseUrl = "https://bonigarcia.dev/selenium-webdriver-java/";
        String expectedTitle = "Hands-On Selenium WebDriver with Java";
        String actualTitle = "";

        // Launch Edge and open the page
        driver.get(baseUrl);

        // Get the page title
        actualTitle = driver.getTitle();

        // Compare expected and actual title
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!");
        }

        // Close Edge
        driver.quit();
    }
}

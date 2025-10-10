package Chrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Helloworld {
    public static void main(String[] args) {
        // Imposta il percorso del ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        // Crea l’istanza di Chrome
        WebDriver driver = new ChromeDriver();

        // URL base
        String baseUrl = "https://bonigarcia.dev/selenium-webdriver-java/";
        String expectedTitle = "Hands-On Selenium WebDriver with Java";
        String actualTitle = "";

        // Lancia Chrome e apri la pagina
        driver.get(baseUrl);

        // Ottieni il titolo della pagina
        actualTitle = driver.getTitle();

        // Confronta titolo atteso e ottenuto
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!");
        }

        // Chiudi Chrome
        driver.quit();
    }
}

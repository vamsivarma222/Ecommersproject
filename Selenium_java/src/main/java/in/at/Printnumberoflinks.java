package in.at;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class AutomateLinks {
    public static void main(String[] args) {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to Google homepage
        driver.get("https://www.google.com/");

        // Find all links
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Number of links: " + allLinks.size());

        // Print link texts
        for (WebElement link : allLinks) {
            System.out.println(link.getText());
        }

        // Close the browser
        driver.quit();
    }
}

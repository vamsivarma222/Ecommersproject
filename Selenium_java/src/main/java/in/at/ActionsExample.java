package in.at;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsExample {
    public static void main(String[] args) {
        // Set up the Chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the URL
            driver.get("https://www.jqueryscript.net/demo/tap-hold-event-handler/");

            // Find the button element
            WebElement button = driver.findElement(By.id("1"));

            // Create an Actions object and perform the click and hold action
            Actions actions = new Actions(driver);
            actions.clickAndHold(button).perform();

            // You might want to add some wait here to see the effect of clickAndHold
            Thread.sleep(5000); // hold for 5 seconds (optional)

            // Release the button if needed
            actions.release().perform();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

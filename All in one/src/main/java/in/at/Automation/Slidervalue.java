package in.at.Automation;

import com.microsoft.playwright.*;

public class Slidervalue {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            // Launch the browser
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            // Create a new page
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Navigate to the page with the slider
            page.navigate("http://uitestingplayground.com/progressbar");

            // Locate the buttons
            Locator startButton = page.locator("//*[@id='startButton']");
            Locator stopButton = page.locator("//*[@id='stopButton']");

            // Click the Start button to initiate the progress
            startButton.click();

            // Wait for the page to process any initial actions
            page.waitForTimeout(1000);

            // Set the slider value to 75% using JavaScript
            page.evaluate("document.getElementById('progressBar').value = 75;");

            // Wait for the slider to settle
            page.waitForTimeout(500);

            // Click the Stop button
            stopButton.click();

            // Get the slider value after setting it to 75
            String sliderValue = (String) page.evaluate("document.getElementById('progressBar').value");
            System.out.println("Slider value when stopped: " + sliderValue + "%");

            // Close the browser
            browser.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
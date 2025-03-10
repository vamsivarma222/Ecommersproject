package in.at.Automation;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.qameta.allure.Allure.step;

public class RailwayRecruitmentCellTest {

    private Page page;

    @BeforeEach
    public void setup() throws IOException {
        Playwright playwright = Playwright.create();
        page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext().newPage();
    }

    @Test
    @Step("Navigate to the Railway Recruitment Cell website")
    public void testNavigation() throws IOException {
        page.navigate("https://rrccr.com/Home/Home");

        // Log the title and URL to the Allure report
        String title = page.title();
        String URL = page.url();

        step("The page title is: " + title);
        step("The page URL is: " + URL);

        // Create folder and take screenshot in one line
        Path folderPath = Paths.get("D:\\All in one\\src\\main\\java\\in\\at\\Automation\\varma");
        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath); // Create folder if it doesn't exist
            System.out.println("Folder Created");
        }

        // Take screenshot
        page.screenshot(new Page.ScreenshotOptions().setPath(folderPath.resolve("screenshot.png")));

        Allure.addAttachment("Screenshot", "image/png", Files.newInputStream(folderPath.resolve("screenshot.png")), "png");
    }

    @Test
    @Step("Close browser after tests")
    public void tearDown() {
        page.context().browser().close();
    }
}

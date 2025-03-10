package in.at.APItesting;

import com.microsoft.playwright.*;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.AllureJunit4;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AllureJunit4.class)
public class PlaywrightAllureTest {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    @BeforeEach
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
    }

    @Test
    @Step("Open Playwright and navigate to the example page")
    public void testOpenPage() {
        page.navigate("https://www.railyatri.in/live-train-status/12805-janmabhoomi-sf-express-vskp-to-lpi?utm_source=lts_dweb_Check_status");
        String title = page.title();
        System.out.println("Page title: " + title);
    }

    @AfterEach
    public void tearDown() {
        context.close();
        browser.close();
        playwright.close();
    }
}
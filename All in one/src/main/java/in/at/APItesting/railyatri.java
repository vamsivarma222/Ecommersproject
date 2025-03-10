package in.at.APItesting;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import in.at.pom.HomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class Demo {
    HomePage homePage;
    private Page page;

    @BeforeTest
    public void start() {
        page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext().newPage();

    }

    @Test
    public void homePageTitleTest() {
        page.navigate("https://www.railyatri.in/live-train-status/12805-janmabhoomi-sf-express-vskp-to-lpi?utm_source=lts_dweb_Check_status");
        String title = page.title();
        System.out.println("Page title: " + title);
        assertEquals("Live Running Status of Train 12805(Janmabhoomi SF Express)- RailYatri", title);
    }

    @Test
    public void homePageURLTest() {
        page.navigate("https://www.railyatri.in/live-train-status/12805-janmabhoomi-sf-express-vskp-to-lpi?utm_source=lts_dweb_Check_status");
        String URL = page.url();
        System.out.println("Page title: " + URL);
        assertEquals("https://www.railyatri.in/live-train-status/12805-janmabhoomi-sf-express-vskp-to-lpi?utm_source=lts_dweb_Check_status", URL);
    }

    @AfterTest
    public void tearDown() {
        page.close();
    }
}
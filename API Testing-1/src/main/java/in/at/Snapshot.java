package in.at;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Snapshot {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        Path screenshotPath = Paths.get("screenshots/raju.png");
        page.screenshot(new Page.ScreenshotOptions().setPath(screenshotPath));
        context.close();
    }
}

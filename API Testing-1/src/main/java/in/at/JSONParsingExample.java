/*package in.at;


import com.microsoft.playwright.*;
import java.nio.file.Paths;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.LoadState;
import org.junit.Test;


public class EventCount {
    @Test
    public void captureEvents() throws InterruptedException {
        Browser browser = Playwright.create().chromium().launch();
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos")).setRecordVideoSize(1920, 1080));
        context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));
        Page page = context.newPage();
        page.navigate("https://dev.automationtesting.in/form");
        page.locator("[name='firstName']").fill("vamsi");
        page.locator("[name='lastName']").fill("varma");
        page.locator("[name='address']").type("This is my permanent address");
        page.click("[type='submit']");
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        List<Tracing.Event> events = context.tracing().stop();
        int eventCount = events.size();
        System.out.println("Number of events in the page: " + eventCount);
        context.close();
    }
}*/

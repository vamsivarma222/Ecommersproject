package BasicJavaPrograms;
import com.microsoft.playwright.*;

public class demoqa {
    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://demoqa.com/books");
        page.click("(//*[@class='header-right'])[1]");
        page.click("//*[@id='item-0']");
        page.fill("//*[@id='username']","vamsi");
        page.fill("//input[@class='mr-sm-2 form-control']","varma");
        page.fill("//*[@id='currentAddress']","flat no:-909,hyderabed,kukatapally,nearjntu");
        page.fill("//*[@id='permanentAddress']","varmaraju");
        page.click("//*[@id='submit']");
    }
}
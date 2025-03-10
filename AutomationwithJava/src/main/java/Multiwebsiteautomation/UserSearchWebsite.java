package Multiwebsiteautomation;

import com.microsoft.playwright.*;

public class automationtesting {
    public static void main (String[] args)throws InterruptedException{
        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://demo.automationtesting.in/Register.html");
page.close();
playwright.close();

    }
}

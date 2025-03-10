package in.at.performance;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Pagerendering {
    public static void main(String[] args){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        long startTime = System.currentTimeMillis();
        page.navigate("https://www.amazon.in/");
        page.waitForLoadState();
        long endTime = System.currentTimeMillis();
        long renderingTime = endTime - startTime;
        System.out.println("Rendering Time: " + renderingTime + " milliseconds");
        browser.close();
    }
}

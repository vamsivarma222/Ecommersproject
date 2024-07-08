package in.at;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Fetch {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch();
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            String fetchScript = "fetch('https://jsonplaceholder.typicode.com/posts/1').then(response => response.text());";
            Object result = page.evaluate(fetchScript);
            String responseBody = (String) result;
            System.out.println("API Response Body:\n" + responseBody);
            page.close();
            context.close();
            browser.close();
        }
    }
}

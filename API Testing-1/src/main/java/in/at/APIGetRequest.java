package in.at;

import com.microsoft.playwright.*;
import org.junit.Test;

public class APIGetRequest {
    @Test
    public void testGetRequest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch();
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        // Define the URL and method to check
        String URL = "https://jsonplaceholder.typicode.com/posts/1";
        String METHOD = "GET";
        // Make an HTTP GET request directly
        APIResponse response = page.request().get(URL);
        // Check if the request URL matches the expected URL
        if (URL.equals(response.url()) && METHOD.equals("GET")) {
            System.out.println("Request URL and method match the expected values.");
            System.out.println("Response status: " + response.status());
            System.out.println("Response body: " + response.text());
        } else {
            System.out.println("Request URL or method do not match the expected values.");
        }
        // Clean up
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}

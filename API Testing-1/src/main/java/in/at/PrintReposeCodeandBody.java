package in.at;

import com.microsoft.playwright.*;
import org.junit.Test;

public class PrintReposeCodeandBody {
    @Test
    public void testAPIRequest() throws PlaywrightException {
        Playwright playwright = Playwright.create();
        BrowserContext context = playwright.firefox().launch().newContext();
        Page page = context.newPage();
        String apiUrl = "https://jsonplaceholder.typicode.com/posts/1";
        Response response = page.navigate(apiUrl);
        int statusCode = response.status();
        System.out.println("API Response Status: " + statusCode);
        String responseBody = response.text();
        System.out.println("API Response Body:\n" + responseBody);
page.close();
    }
}



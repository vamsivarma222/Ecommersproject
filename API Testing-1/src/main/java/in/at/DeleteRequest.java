package in.at;
import com.microsoft.playwright.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DeleteRequest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch();
            BrowserContext context = browser.newContext();
            deleteExample("https://jsonplaceholder.typicode.com/posts/1");
            context.close();
            browser.close();
        }
    }

    private static void deleteExample(String url) {
        try {
            URL deleteUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) deleteUrl.openConnection();
            connection.setRequestMethod("DELETE");
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            connection.disconnect();
        } catch (Exception e) {
            System.err.println("Error during DELETE request: " + e.getMessage());
        }
    }
}

package in.at;

import com.microsoft.playwright.*;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PutRequest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch();
            BrowserContext context = browser.newContext();
            putExample("https://jsonplaceholder.typicode.com/posts/1", "Sample PUT data");
            context.close();
            browser.close();
        }
    }

    private static void putExample(String url, String putData) {
        try {
            URL putUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) putUrl.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = putData.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            connection.disconnect();
        } catch (Exception e) {
            System.err.println("Error during PUT request: " + e.getMessage());
        }
    }
}

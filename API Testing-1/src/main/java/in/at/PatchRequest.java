package in.at;

import com.microsoft.playwright.*;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PatchRequest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch();
            BrowserContext context = browser.newContext();
            patchExample("https://jsonplaceholder.typicode.com/posts/1", "Sample PATCH data");
            context.close();
            browser.close();
        }
    }

    private static void patchExample(String url, String patchData) {
        try {
            URL patchUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) patchUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("X-HTTP-Method-Override", "PATCH");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = patchData.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            connection.disconnect();
        } catch (Exception e) {
            System.err.println("Error during PATCH request: " + e.getMessage());
        }
    }
}

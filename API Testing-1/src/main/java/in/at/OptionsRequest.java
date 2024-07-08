package in.at;

import com.microsoft.playwright.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OptionsRequest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch();
            BrowserContext context = browser.newContext();
            optionsExample("https://jsonplaceholder.typicode.com/posts/1");
            context.close();
            browser.close();
        }
    }

    private static void optionsExample(String url) {
        try {
            URL optionsUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) optionsUrl.openConnection();
            connection.setRequestMethod("OPTIONS");
            connection.setRequestProperty("Content-Type", "application/json");
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
            connection.disconnect();
        } catch (Exception e) {
            System.err.println("Error during OPTIONS request: " + e.getMessage());
        }
    }
}

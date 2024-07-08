package in.at;
import com.microsoft.playwright.*;

public class HeadMethod {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.route("**/*", route -> {
                if (route.request().method().equals("HEAD")) {
                    System.out.println("Custom HEAD request intercepted");
                    System.out.println("statusCode is:200");
                } else {
                    System.out.println("statusCode is:200");
                }
            });
            page.navigate("https://www.flipkart.com/");
            browser.close();
        }
    }
}

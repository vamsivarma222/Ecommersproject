package in.at.performance;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;

public class PerformanceMatrix {
    public static void main(String [] args){
        Page page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext().newPage();
        String url = "https://www.amazon.in/";
        page.navigate(url);

        // Wait for the page to load completely
        page.waitForLoadState(LoadState.LOAD);

        // Collect performance metrics
        Object performanceMetrics = page.evaluate("() => JSON.stringify(window.performance)");

        // Print the performance metrics
        System.out.println("Performance Metrics: " + performanceMetrics);
        page.close();

    }
}

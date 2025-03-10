package in.at.Automation;

import com.microsoft.playwright.*;

public class ixigo1 {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            // Launch the browser in headless mode
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newContext().newPage();
            page.navigate("https://www.ixigo.com/?utm_source=google&utm_medium=dsa&utm_campaign=searchdsa&utm_source=google&utm_medium=paid_search_google&utm_campaign=DSA_Generic_Flight_NewUser &gad_source=1&gclid=Cj0KCQiA57G5BhDUARIsACgCYnwxXqSJPysqZ2KjaOLFtc6Ip3682YzhZdgnxtckQ4dtPLQU9qWukx4aAlsrEALw_wcB");

            // Printing the URL and Title of the page
            System.out.println("Printing the Title of the page: " + page.title());
            System.out.println("Printing the URL of the page: " + page.url());

            // Wait for the selector with increased timeout
            page.waitForSelector("//p[@class='body-sm text-xl'][normalize-space()='Trains']", new Page.WaitForSelectorOptions().setTimeout(60000));

            // Check if the "Trains" element is visible
            boolean trainVisible = page.locator("//p[@class='body-sm text-xl'][normalize-space()='Trains']").isVisible();
            System.out.println("The output for the train is: " + trainVisible);

            boolean trainEnabled = page.locator("//p[@class='body-sm text-xl'][normalize-space()='Trains']").isEnabled();
            System.out.println("The output for the train enabled state is: " + trainEnabled);

            boolean trainDisabled = page.locator("//p[@class='body-sm text-xl'][normalize-space()='Trains']").isDisabled();
            System.out.println("The output for the train disabled state is: " + trainDisabled);

            boolean trainHidden = page.locator("//p[@class='body-sm text-xl'][normalize-space()='Trains']").isHidden();
            System.out.println("The output for the train hidden state is: " + trainHidden);

            boolean trainEditable = page.locator("//p[@class='body-sm text-xl'][normalize-space()='Trains']").isEditable();
            System.out.println("The output for the train editable state is: " + trainEditable);


            page.click("//p[@class='body-sm text-xl'][normalize-space()='Trains']");
            page.close();
        }
    }
}
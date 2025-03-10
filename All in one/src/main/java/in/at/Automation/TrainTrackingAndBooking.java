package in.at.Automation;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static org.junit.Assert.assertEquals;

public class TrainTrackingAndBooking {

    public static void main(String[] args) {
        Page page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext().newPage();

        liveTracking(page);
        login(page);

        page.close();
    }

    public static void liveTracking(Page page) {
        page.navigate("https://www.railyatri.in/live-train-status");
        page.fill("//input[@type=\"text\"]", "20707");

        Locator vamsi = page.locator("//input[@type='text']");

        // Check if the input is focused
        vamsi.focus();
        page.waitForTimeout(2000);
        System.out.println("Input box is focused");

        // Printing the inner text of the button
        String buttonText = page.innerText("//button[@type=\"submit\"]");
        System.out.println("Printing the inner text of the Button: " + buttonText);
        Locator buttonLocator = page.locator("//button[@type='submit']");

        // Check the button visibility and enabled state
        boolean isVisible = buttonLocator.isVisible();
        System.out.println("Button is visible: " + isVisible);
        boolean isEnabled = buttonLocator.isEnabled();
        System.out.println("Button is enabled: " + isEnabled);

        // Click on the submit button and wait for the selector
        page.click("//button[@type='submit']");

        String trainInfo = page.locator("(//div[@class=\"flexCol\"])[1]").innerText();
        System.out.println("The train number and the train name: " + trainInfo);

        // Wait for the locator to update
        page.waitForTimeout(2000);
        page.waitForSelector("//div[@class=\"flexCol\"]");

        // Printing data of all the railway stations
        System.out.println("Below are the data of all the railway stations:");
        int count = page.locator("//div[@class=\"flexCol\"]").count();
        System.out.println("Total count of elements in which we are searching the data: " + count);

        for (int i = 1; i < count; i += 2) {
            String varma = page.locator("//div[@class=\"flexCol\"]").nth(i).innerText();
            String stationName = varma.split("\n")[0];
            System.out.println("All the stops in the railway station " + (i / 2 + 1) + ": " + stationName);
        }

        // Check if the train has reached the last station
        int number = page.locator("//div[@class=\"flexCol result_currentLocationMessage__ONL0g\"]").count();
        if (number == 0) {
            System.out.println("The train has reached the last station");
        } else {
            String liveStation = page.locator("//div[@class=\"flexCol result_currentLocationMessage__ONL0g\"]").innerText();
            System.out.println("Printing the live data of the train: " + liveStation);
        }
    }


    public static void login(Page page) {
        // Navigate to the URL and validate
        page.navigate("https://www.railyatri.in/live-train-status/12805-janmabhoomi-sf-express-vskp-to-lpi?utm_source=lts_dweb_Check_status");
        System.out.println("Printing the page title: " + page.title());
        System.out.println("Printing the URL of the page: " + page.url());
        assertEquals("Live Running Status of Train 12805(Janmabhoomi SF Express)- RailYatri", page.title());
        assertEquals("https://www.railyatri.in/live-train-status/12805-janmabhoomi-sf-express-vskp-to-lpi?utm_source=lts_dweb_Check_status", page.url());

        // Click on the train ticket button
        page.click("(//a[@class=\"MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineNone css-v1r2ov\"])[1]");
        checkElementVisibility(page, "(//a[@class=\"MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineNone css-v1r2ov\"])[1]");

        // Fill the data in the from station
        page.fill("//input[@id=\"fromstation\"]", "VISAKHAPATNAM | VSKP");
        checkInputField(page, "//input[@id='fromstation']");

        // Fill the data in the to station
        page.fill("//*[@id=\"tostation\"]", "HYDERABAD DECCAN | HYB");
        checkInputField(page, "//*[@id='tostation']");

        // Click on the calendar icon
        page.click("//img[@alt='cal icon']");
        checkElementVisibility(page, "//img[@alt='cal icon']");

        // Click on the search button
        page.click("//*[@id=\"searchcontainer\"]/form/div/button");
        checkElementVisibility(page, "//*[@id=\"searchcontainer\"]/form/div/button");

        page.waitForTimeout(2000);
    }

    private static void checkInputField(Page page, String selector) {
        boolean visible = page.locator(selector).isVisible();
        System.out.println("The input field is visible: " + visible);
        boolean enabled = page.locator(selector).isEnabled();
        System.out.println("The input field is enabled: " + enabled);
        boolean disabled = page.locator(selector).isDisabled();
        System.out.println("The input field is disabled: " + disabled);
        boolean hidden = page.locator(selector).isHidden();
        System.out.println("The input field is hidden: " + hidden);
        boolean editable = page.locator(selector).isEditable();
        System.out.println("The input field is editable: " + editable);
    }

    private static void checkElementVisibility(Page page, String selector) {
        boolean visible = page.locator(selector).isVisible();
        System.out.println("Element is visible: " + visible);
        boolean enabled = page.locator(selector).isEnabled();
        System.out.println("Element is enabled: " + enabled);
        boolean disabled = page.locator(selector).isDisabled();
        System.out.println("Element is disabled: " + disabled);
        boolean hidden = page.locator(selector).isHidden();
        System.out.println("Element is hidden: " + hidden);
        boolean editable = page.locator(selector).isEditable();
        System.out.println("Element is editable: " + editable);
    }
}
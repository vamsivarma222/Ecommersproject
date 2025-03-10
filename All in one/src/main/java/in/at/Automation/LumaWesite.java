package in.at.Automation;

import com.microsoft.playwright.*;

public class LumaWebsite {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            // Launch the browser
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newContext().newPage();
            page.setDefaultTimeout(60000); // Set default timeout to 60 seconds

            // Navigate to the website
            page.navigate("https://magento.softwaretestingboard.com/");
            page.waitForSelector("//a[@id='ui-id-5']", new Page.WaitForSelectorOptions().setVisible(true));
            page.click("//a[@id='ui-id-5']");
            page.click("//a[contains(text(),'Hoodies & Sweatshirts')]");
            page.click("//img[@alt='Marco Lightweight Active Hoodie']");
            page.click("//*[@id='option-label-size-143-item-166']");
            page.click("//*[@id='option-label-color-93-item-50']");
            page.fill("//*[@id='qty']", "3");
            page.click("//*[@id='product-addtocart-button']/span");
            page.click("//a[@class='action showcart']");
            page.click("//button[@id='top-cart-btn-checkout']");

            // Fill in customer details
            page.fill("(//input[@class='input-text'])[3]", "prabhasfansclub@gmail.com");
            page.fill("(//input[@class='input-text'])[4]", "vamsi");
            page.fill("(//input[@class='input-text'])[5]", "kanumuri");
            page.fill("(//input[@class='input-text'])[6]", "blluepal");
            page.fill("(//input[@class='input-text'])[7]", "jdfsgbsdfbsdaljfhlasdkjf");
            page.fill("(//input[@class='input-text'])[8]", "iudsaffdsdfhs");
            page.fill("(//input[@class='input-text'])[9]", "iudsaffdsaskdasddfhs");
            page.fill("(//input[@type='text'])[7]", "kakinada");
            page.selectOption("(//select[@class='select'])[1]", "Alabama");
            page.fill("(//input[@type='text'])[9]", "12345");

            // Wait for the dropdown and select option
            try {
                page.waitForSelector("//*[@id='D2BANH0']", new Page.WaitForSelectorOptions().setVisible(true));
                page.selectOption("//*[@id='D2BANH0']", "value-of-option-2"); // Replace with the actual value or index
            } catch (TimeoutError e) {
                System.out.println("Failed to select the option within the timeout.");
            }

            // Fill in additional details
            page.fill("//*[@id='AHB3KAC']", "9999999999"); // Phone number
            page.check("(//input[@type='radio'])[1]"); // Check a radio button
            page.click("(//button[@type='submit'])[3]"); // Submit the form

            // Close the page
            page.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
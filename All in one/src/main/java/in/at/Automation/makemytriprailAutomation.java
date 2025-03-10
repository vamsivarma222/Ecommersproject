package in.at.Automation;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;

public class railyatraAutomation {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newContext().newPage();
        try {
            page.navigate("https://www.makemytrip.com/railways/?cmp=SEM|D|Rail|Google|Generic&gad_source=1&gclid=Cj0KCQiAoae5BhCNARIsADVLzZcBDOpJIErjJdvHIZAxB_ckeMIEsVGM1OwslsRFeWiJpkr43p2VNkMaAlyEEALw_wcB");
            page.click("//div[@class='imageSlideContainer']//section[@class='modalMain tcnFooter']//span[@class='commonModal__close']");
            page.waitForSelector("//div[@class='imageSlideContainer']//section[@class='modalMain tcnFooter']", new Page.WaitForSelectorOptions().setState(WaitForSelectorState.HIDDEN));
            page.click("(//input[@type='text'])[1]");
            page.waitForSelector("//*[@class='react-autosuggest__input react-autosuggest__input--open']", new Page.WaitForSelectorOptions().setTimeout(60000));
            page.waitForSelector("//*[@class='react-autosuggest__input react-autosuggest__input--open']", new Page.WaitForSelectorOptions().setTimeout(60000));
            boolean visible1 = page.locator("//*[@class='react-autosuggest__input react-autosuggest__input--open']").isVisible();
            System.out.println("The locator is visible: " + visible1);
            boolean enabled = page.locator("//*[@class='react-autosuggest__input react-autosuggest__input--open']").isEnabled();
            System.out.println("The locator is enabled: " + enabled);
            page.fill("//*[@class='react-autosuggest__input react-autosuggest__input--open']", "Hyderabad");
            page.waitForTimeout(2000);
            boolean visible = page.locator("(//div[@class='makeFlex'])[1]").isVisible();
            System.out.println("Is the text field visible? " + visible);
            page.click("(//div[@class='makeFlex'])[1]");
            raju(page, "(//div[@class='makeFlex'])[1]");
            System.out.println("Printed the return value from 'raju'.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            page.close();
            browser.close();
            playwright.close();
        }
    }

    public static boolean raju(Page page, String selector) {
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
        return editable;
    }
}

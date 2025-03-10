package in.at.Automation;

import com.microsoft.playwright.*;


public class JWTToken {
    public static void main(String[] args)
    {
        Page page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(true)).newContext().newPage();
        page.navigate("https://www.ixigo.com/?utm_source=google&utm_medium=dsa&utm_campaign=searchdsa&utm_source=google&utm_medium=paid_search_google&utm_campaign=DSA_Generic_Flight_NewUser&gad_source=1&gclid=Cj0KCQiA57G5BhDUARIsACgCYnwxXqSJPysqZ2KjaOLFtc6Ip3682YzhZdgnxtckQ4dtPLQU9qWukx4aAlsrEALw_wcB");

        //Printing the URL and Title of  the page
        System.out.println("Printing the Title of the page:"+ page.title());
        System.out.println("Printing the URL of the page:"+page.url());
        page.click("//div//p[@class=\"body-sm text-xl\"][normalize-space()='Trains']");
        validations(page ,"//div//p[@class=\"body-sm text-xl\"][normalize-space()='Trains']");
        page.close();
    }
    public static void validations(Page page , String selector){
        page.waitForTimeout(20000);
        page.waitForSelector(selector);

        boolean visible = page.locator(selector).isVisible();
        System.out.println("Element is visible: " + visible);
        page.waitForTimeout(3000);
        boolean enabled = page.locator(selector).isEnabled();
        System.out.println("Element is enabled: " + enabled);
        page.waitForTimeout(3000);
        boolean disabled = page.locator(selector).isDisabled();
        System.out.println("Element is disabled: " + disabled);
        page.waitForTimeout(3000);
        boolean hidden = page.locator(selector).isHidden();
        System.out.println("Element is hidden: " + hidden);
        page.waitForTimeout(3000);
        boolean editable = page.locator(selector).isEditable();
        System.out.println("Element is editable: " + editable);

    }
}

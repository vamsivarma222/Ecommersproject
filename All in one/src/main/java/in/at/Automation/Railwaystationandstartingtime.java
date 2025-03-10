package in.at.Automation;

import com.microsoft.playwright.*;

public class Railwaystationandstartingtime {
    public static void main(String[] args){
        Page page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext().newPage();
        page.navigate("https://www.railyatri.in/live-train-status");
        page.fill("//input[@type=\"text\"]","68692 - DIGHA FLAG STN - PANSKURA EMU Passenger");

        Locator vamsi = page.locator("//input[@type='text']");

        //Check the input is focused are not
        vamsi.focus();
        page.waitForTimeout(2000);
        System.out.println("Input box is focused");

        //Printing the inner text fo the button
        String Button = page.innerText("//button[@type=\"submit\"]");
        System.out.println("Printing the inner text of the Button :" + Button);
        Locator buttonLocator = page.locator("//button[@type='submit']");

        //Check the button is visible are enabled are not
        boolean isVisible = buttonLocator.isVisible();
        System.out.println("Button is visible: " + isVisible);
        boolean isEnabled = buttonLocator.isEnabled();
        System.out.println("Button is enabled: " + isEnabled);

        //Click on the submit button and wait for the selector
        page.click("//button[@type='submit']");
        page.waitForSelector("//div[@class=\"flexCol\"]");
        page.waitForTimeout(2000);

        //count the number of stations are these in the railwaystation
        int count = page.locator("//div[@class=\"flexCol\"]").count();
        System.out.println("Total count of the element: " + count);
int a=1;
for (int i=2;i<count;i+=2){
    String kanumuri = page.locator("//div[@class=\"flexCol\"]").nth(i).innerText();
    String stationName = kanumuri.split("\n")[0];
    String stationTiming = kanumuri.split("\n")[3];

    System.out.println("Station " + a + ": " + stationName + " | Starting Timing: " +stationTiming);
a++;
}
        System.out.println("Total number of Stations are : " + (a - 1));
page.close();
    }
}

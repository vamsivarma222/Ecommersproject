import com.microsoft.playwright.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Javaclass {
    public static void main(String[] args) {
        // Initialize Playwright
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        // Navigate to the main page
        page.navigate("https://www.demoblaze.com/#carouselExampleIndicators");

        // Get and print the page title and URL
        String title = page.title();
        String url = page.url();
        assertTrue(title.equalsIgnoreCase("Store"), "The page title is incorrect!");
        assertEquals("https://www.demoblaze.com/#carouselExampleIndicators", url, "The page URL is incorrect!");
        System.out.println("Page title: " + title);
        System.out.println("Page URL: " + url);

        // Wait for the products to be loaded
        page.waitForSelector("//*[@id='tbodyid']/div");
        int count = page.locator("//*[@id='tbodyid']/div").count();
        System.out.println("The count for the locator in that particular page: " + count);

        // Loop through the products and print product names and prices
        for (int i = 1; i <= count; i++) {
            String productName = page.locator("//*[@id='tbodyid']/div[" + i + "]").innerText().trim().split("\n")[0].trim();
            String productPrice = page.locator("//*[@id='tbodyid']/div[" + i + "]").innerText().trim().split("\n")[1].trim();
            System.out.println("element:" + i + " " + productName + " product price " + productPrice);
        }

        // Assert there are products listed
        assertTrue(count > 0, "No products found!");
        assertEquals(count, page.locator("//*[@id='tbodyid']/div").count(), "Product count mismatch!");

        // Click on the first product to view the product detail page
        page.locator("//*[@id='tbodyid']/div[1]").click();

        // Wait for the product detail page to load, look for a unique element on that page (e.g., <h2>)
        page.waitForSelector("h2");  // Adjust selector as needed

        // Get and print the actual title of the product detail page
        String productDetailTitle = page.title();
        System.out.println("Product detail page title: " + productDetailTitle);

        // Assert that the product detail page title contains "Product"
        assertTrue(productDetailTitle.contains("Product"), "Product detail page title mismatch!");

        // Click on the "Cart" link to check cart page title
        page.locator("//*[@id='tbodyid']/div[1]/div[2]/a").click();
        String cartTitle = page.title();
        assertTrue(cartTitle.equalsIgnoreCase("Cart"), "Cart page title mismatch!");
        System.out.println("Cart page title: " + cartTitle);

        // Navigate to the cart page
        page.locator("//*[@id='cartur']").click();
        String cartPageUrl = page.url();
        assertEquals("https://www.demoblaze.com/cart.html", cartPageUrl, "Cart page URL mismatch!");
        System.out.println("Cart page URL: " + cartPageUrl);

        // Click on "Place Order"
        page.locator("//button[contains(text(),'Place Order')]").click();
        String placeOrderTitle = page.title();
        assertTrue(placeOrderTitle.contains("Place Order"), "Place order page title mismatch!");
        System.out.println("Place Order page title: " + placeOrderTitle);

        // Fill in the order form
        page.locator("//*[@id='name']").fill("John Doe");
        page.locator("//*[@id='country']").fill("USA");
        page.locator("//*[@id='city']").fill("New York");
        page.locator("//*[@id='card']").fill("4111111111111111");
        page.locator("//*[@id='month']").fill("12");
        page.locator("//*[@id='year']").fill("2025");
        page.locator("//*[@id='orderModal']/div/div/div[3]/button[2]").click();

        // Verify the order confirmation message
        String confirmationText = page.locator("//h2").innerText();
        assertTrue(confirmationText.contains("Thank you for your purchase!"), "Order confirmation mismatch!");
        System.out.println("Order confirmation: " + confirmationText);

        // Navigate to the home page again
        page.navigate("https://www.demoblaze.com/#carouselExampleIndicators");

        // Login with valid credentials
        page.waitForSelector("//*[@id='login2']");
        page.locator("//*[@id='login2']").click();
        page.locator("//*[@id='loginusername']").fill("testuser");
        page.locator("//*[@id='loginpassword']").fill("password123");
        page.locator("//*[@id='logInModal']/div/div/div[3]/button[2]").click();
        String loginText = page.locator("//span[@id='loginusername']").innerText();
        assertTrue(loginText.equals("testuser"), "Login failed!");
        System.out.println("Logged in as: " + loginText);

        // Try logging in with invalid credentials
        page.locator("//*[@id='login2']").click();
        page.locator("//*[@id='loginusername']").fill("invaliduser");
        page.locator("//*[@id='loginpassword']").fill("wrongpassword");
        page.locator("//*[@id='logInModal']/div/div/div[3]/button[2]").click();
        String loginErrorText = page.locator("//*[@id='logInModal']/div/div/div[2]").innerText();
        assertTrue(loginErrorText.contains("User does not exist"), "Login error message mismatch!");
        System.out.println("Login error message: " + loginErrorText);

        // Click on the first product and verify product details
        page.locator("//*[@id='product1']").click();
        String productDetails = page.locator("//*[@id='tbodyid']/div[1]/h3").innerText();
        assertTrue(productDetails.contains("Samsung Galaxy S6"), "Product details mismatch!");
        System.out.println("Product details: " + productDetails);

        // Click on the second product and verify product details
        page.locator("//*[@id='product2']").click();
        String secondProductDetails = page.locator("//*[@id='tbodyid']/div[1]/h3").innerText();
        assertTrue(secondProductDetails.contains("Nokia Lumia 1520"), "Second product details mismatch!");
        System.out.println("Second product details: " + secondProductDetails);

        // Navigate to the contact page
        page.locator("//*[@id='navbarExample']/ul/li[2]/a").click();
        String contactPageUrl = page.url();
        assertEquals("https://www.demoblaze.com/contact.html", contactPageUrl, "Contact page URL mismatch!");
        System.out.println("Contact page URL: " + contactPageUrl);

        // Navigate to the about page
        page.locator("//*[@id='footer']/div/div/a").click();
        String aboutPageUrl = page.url();
        assertEquals("https://www.demoblaze.com/about.html", aboutPageUrl, "About page URL mismatch!");
        System.out.println("About page URL: " + aboutPageUrl);

        // Close the browser
        page.close();
        browser.close();
    }
}

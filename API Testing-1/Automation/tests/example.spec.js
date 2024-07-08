const { test, expect } = require('@playwright/test');

test('PetStore test', 
async ({ page }) => {

  await page.goto('https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=BIRDS');

  await page.click("//*[@id=\"QuickLinks\"]/a[1]/img");
  await page.click("//a[normalize-space()='FI-SW-01']");
  await page.click("//a[normalize-space()='Add to Cart']");
  await page.click("//a[@class=\"Button\"]");
  await page.click("//*[@id=\"QuickLinks\"]/a[1]/img");
  await page.click("//a[normalize-space()='FI-SW-02']");
  await page.click("//a[normalize-space()='Add to Cart']");
  await page.click("//a[@class=\"Button\"]");
  await page.click("//*[@id=\"QuickLinks\"]/a[1]/img");
  await page.click("//a[normalize-space()='FI-FW-01']");
  await page.click("//a[@class=\"Button\"]");
  await page.click("//*[@id=\"QuickLinks\"]/a[1]/img");
  await page.click("//a[normalize-space()='FI-FW-02']");
  await page.click("//a[@class=\"Button\"]");
  await page.click("//img[@src=\"../images/sm_dogs.gif\"]");
  await page.click("//a[normalize-space()='K9-BD-01']");
  await page.click("//a[normalize-space()='Add to Cart']");

  await expect(page).toHaveTitle('JPetStore Demo');
  await expect(page).toHaveURL('https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-6');

  await page.click("//a[normalize-space()='Proceed to Checkout']");
  await page.click("//a[normalize-space()='Register Now!']");

  await page.fill('(//input[@type="text"])[5]', 'vamsi');
  await page.fill('(//input[@type="text"])[6]', 'varma');
  await page.fill('(//input[@type="text"])[7]', 'vamsi@email.com');
  await page.fill('(//input[@type="text"])[8]', '8374285222');
  await page.fill('(//input[@type="text"])[9]', 'ashfgsdkjhdsgf');
  await page.fill('(//input[@type="text"])[10]', 'ashfgsdkjhdsgf');
  await page.fill('(//input[@type="text"])[11]', 'vizag');
  await page.fill('(//input[@type="text"])[12]', 'AP');
  await page.fill('(//input[@type="text"])[13]', '530046');
  await page.fill('(//input[@type="text"])[14]', 'india');

  await page.selectOption('//select[@name="account.languagePreference"]', 'english');
  await page.selectOption('//select[@name="account.favouriteCategoryId"]', 'DOGS');

  await page.check('(//input[@type="checkbox"])[1]');
  await page.check('(//input[@type="checkbox"])[2]');

  await page.click("//*[@id=\"Catalog\"]/form/input");
});
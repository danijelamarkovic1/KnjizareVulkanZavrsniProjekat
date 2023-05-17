package Tests;

import Pages.BasePage;
import Pages.InventoryPage;
import Pages.Strings;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchTest extends BaseTests {


    /**
     * Search by keyword: 'slikovnica', go through several pages, find a
     * specific item: 'DZUNGLA Slikovnica rasklapalica'
     * <p>
     * Steps:
     * 1. Go to: 'https://www.knjizare-vulkan.rs/'
     * 2. Click on search icon
     * 3. Enter 'slikovnica' into search field
     * 4. Find and click 'DZUNGLA Slikovnica rasklapalica' on search list
     * <p>
     * <p>
     * Expected results:
     * 3. Verify that search result list isn't empty
     * 4. Verify that correct item page is displayed
     */

    @Test
    public void searchByItemTypeAndName() {
        ChromeDriver driver = openChromeDriver();

        try {
            print("1. Go to: 'https://www.knjizare-vulkan.rs/'");
            InventoryPage inventoryPage = new InventoryPage(driver);
            print("2. Click on search icon");
            print("3. Enter 'slikovnica' into search field");
            inventoryPage.searchItemTypeByKeyword("slikovnica");

            print("4. Find and click 'slikovnica");
            print("4. Verify that correct item page is displayed");
            inventoryPage.findItemByName(Strings.DZUNGLA_SLIKOVNICA_TITLE);
            inventoryPage.clickOnBook("DZUNGLA Slikovnica rasklapalica");
        } finally {
            print("Test finished");
        }
    }


    /**
     * Enter invalid item in search field and verify the alert message
     * <p>
     * Steps:
     * 1. Go to: 'https://www.knjizare-vulkan.rs/'
     * 2. Click on search icon
     * 3. Enter 'televizor' into search field
     * <p>
     * Expected results:
     * 3. Verify that search URL is displayed
     * 3. Verify that alert message: 'Za izabrane kriterijume nisu pronađeni proizvodi! is displayed'
     */

   @Test
    public void searchForInvalidItem() {
        ChromeDriver driver = openChromeDriver();

        try {
            print("1. Go to: 'https://www.knjizare-vulkan.rs/'");
            BasePage basePage = new BasePage(driver);
            InventoryPage inventoryPage = new InventoryPage(driver);

            print("2. Click on search icon");
            basePage.clickSearchIcon();

            print("3. Enter 'televizor' into search field");
            inventoryPage.enterTextIntoSearchField("televizor");


            print("3. Verify that search URL is displayed");
            String actualUrl = driver.getCurrentUrl();
            assertUrl(actualUrl, Strings.TELEVIZOR_URL);

            print("3. Verify that alert message: 'Za izabrane kriterijume nisu pronađeni proizvodi!' iz displayed");
            String currentMessage = driver.findElementByXPath(Strings.SEARCH_ALERT_MESSAGE_XPATH).getText();
            assert currentMessage.equals(Strings.SEARCH_ALERT_MESSAGE_TEXT) : "Error: Wrong message. Expected: " +
                    Strings.SEARCH_ALERT_MESSAGE_TEXT + ". Actual: " + currentMessage;

        } finally {
            print("Test finished");
        }
    }


    /**
     * Search "domace knjige" test
     * <p>
     * Steps:
     * 1.Navigate to https://www.knjizare-vulkan.rs
     * 2.Click on search button on the homepage
     * 3.In search text enter name book, and press search
     * 4."Smrtni ishodi atletskih povreda" is the name book to be found as a search results
     * <p>
     * Expected results:
     * 4.Verify that the user is navigated to the  DOMACE KNJIGE Url
     */

    @Test
    public void searchDomaceBookTest() {
        ChromeDriver driver = openChromeDriver();
        try {
            print("1.Navigate to https://www.knjizare-vulkan.rs");
            BasePage basePage = new BasePage(driver);

            print("2.Click on search button");
            basePage.clickSearchIcon();

            print("3.Enter in the item name.");
            basePage.enterTextIntoSearchField("SMRTNI ISHODI ATLETSKIH POVREDA");

            print("4.Verify that the user is navigated to the DOMACE KNJIGE ");
            assert isCurrentURLEqualTo(Strings.SMRTNI_ISHODI_ATLETSKIH_POVREDA_URL ) :"Error.Expected URL is not open";


        } finally {
            driver.quit();

        }
    }


    /**
     * Test search book name
     * <p>
     * Steps:
     * 1.Navigate to https://www.knjizare-vulkan.rs
     * 2.Click on search button on the homepage
     * 3.In search text enter name book, and press search
     * 4.Results is 4 book, clickin on "Smrtni ishodi atletskih povreda"
     * 5.Book name "Smrtni ishodi atletskih povreda" is present, we use the confirmation Url
     * <p>
     * Expected results:
     * 5.Verify that the user is navigated, and open to the SMRTNI ISHOD ATLETSKIH POVREDA URL
     */

    @Test
    public void searchBookName() {
        ChromeDriver driver = openChromeDriver();
        try {
            print("1.Navigate to https://www.knjizare-vulkan.rs");
            BasePage basePage = new BasePage(driver);

            print("2.Click on search button");
            basePage.clickSearchIcon();

            print("3.Enter in the item name and press enter");
            basePage.enterTextIntoSearchField(Strings.SMRTNI_ISHODI_ATLETSKIH_POVREDA_TEXT);

            print("4.Click on SMRTNI ISHODI ATLETSKIH POVREDA from the displayed search results list");
            InventoryPage inventoryPage = new InventoryPage(driver);
            inventoryPage.clickOnBook(Strings.SMRTNI_ISHODI_ATLETSKIH_POVREDA_TEXT);

            print("5.Verify that the user is navigated and open to the SMRTNI ISHODI ATLETSKIH POVREDA URL ");
            assert isCurrentURLEqualTo(Strings.SMRTNI_ISHODI_ATLETSKIH_POVREDA_URL):"ERROR.";

        } finally {
        }
           driver.quit();
    }


}


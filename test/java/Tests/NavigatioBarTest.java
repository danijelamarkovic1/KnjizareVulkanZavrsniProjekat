package Tests;


import Pages.BasePage;
import Pages.HomePage;
import Pages.InventoryPage;
import Pages.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NavigatioBarTest extends BaseTests{

    /**
     * Opening and verifying all categories from navigation bar
     *
     * Steps:
     * 1. Go to: 'https://www.knjizare-vulkan.rs/'
     * 2. On navigation bar click on 'KATEGORIJE' category
     * 3. On navigation bar click on 'AKCIJE' category
     * 4. On navigation bar click on 'NOVA IZDANJA' category
     * 5. On navigation bar click on 'GIF KARTICE' category
     * 6. On navigation bar click on 'LICNI RAZVOJ' category
     * 7. On navigation bar click on 'TIKTOK HITOVO' category
     * 8. On navigation bar click on 'HAPPY POTTER' category
     * 9. On navigation bar click on 'USKORO' category
     *
     * Expected results:
     * 2-9 Verify that you are redirected to correct category URL
     * 2-9 Verify the correct page title
     */

    @Test
    public void selectCategoryPageFromNavbar() {
        ChromeDriver driver = openChromeDriver();

        try {
            print("1. Go to: 'https://www.knjizare-vulkan.rs/'");
            BasePage basePage = new BasePage(driver);

            print("2. On navigation bar click on 'KATEGORIJE' category and verify that the correct URL is displayed");
            basePage.openNavBarCategory(Strings.KATEGORIJE_PROIZVODA_NAVBAR_TITLE, Strings.KATEGORIJE_PROIZVODA_URL);
            print("2. Verify the correct page title");
            String currentPageTitle = driver.findElement(By.xpath(Strings.ALL_PAGES_TITLE_XPATH)).getText();
            assert currentPageTitle.equals(Strings.KATEGORIJE_PROIZVODA_PAGE_TITLE) : "Error: Wrong page title. Expected: " +
                    Strings.KATEGORIJE_PROIZVODA_PAGE_TITLE + ". Actual: " + currentPageTitle;


            print("3. On navigation bar click on 'AKCIJE' category and verify that the correct URL is displayed");
            basePage.openNavBarCategory(Strings.AKCIJE_NAVBAR_TITLE, Strings.AKCIJE_URL);
            print("3. Verify the correct page title");
            currentPageTitle = driver.findElement(By.xpath(Strings.ALL_PAGES_TITLE_XPATH)).getText();
            assert currentPageTitle.equals(Strings.AKCIJE_PAGE_TITLE) : "Error: Wrong page title. Expected: " +
                    Strings.AKCIJE_PAGE_TITLE + ". Actual: " + currentPageTitle;


            print("4. On navigation bar click on 'NOVA IZDANJA' category and verify that the correct URL is displayed");
            basePage.openNavBarCategory(Strings.NOVA_IZDANJA_NAVBAR_TITLE, Strings.NOVA_IZDANJA_URL);
            print("4. Verify the correct page title");
            currentPageTitle = driver.findElement(By.xpath(Strings.ALL_PAGES_TITLE_XPATH)).getText();
            assert currentPageTitle.equals(Strings.NOVA_IZDANJA_PAGE_TITLE) : "Error: Wrong page title. Expected: " +
                    Strings.NOVA_IZDANJA_PAGE_TITLE + ". Actual: " + currentPageTitle;


            print("5. On navigation bar click on 'GIF KARTICE' category and verify that the correct URL is displayed");
            basePage.openNavBarCategory(Strings.GIFT_KARTICE_NAVBAR_TITLE, Strings.GIFT_KARTICE_URL);
            print("5.Verify the correct page title");
            currentPageTitle = driver.findElement(By.xpath(Strings.ALL_PAGES_TITLE_XPATH)).getText();
            assert currentPageTitle.equals(Strings.GIFT_KARTICE_PAGE_TITLE) : "Error: Wrong title. Expected: " +
                    Strings.GIFT_KARTICE_PAGE_TITLE + ". Actual: " + currentPageTitle;


            print("6. On navigation bar click on 'LICNI RAZVOJ' category and verify that the correct URL is displayed");
            basePage.openNavBarCategory(Strings.LICNI_RAZVOJ_NAVBAR_TITLE, Strings.LICNI_RAZVOJ_URL);
            print("6.Verify the correct page title");
            currentPageTitle = driver.findElement(By.xpath(Strings.ALL_PAGES_TITLE_XPATH)).getText();
            assert currentPageTitle.equals(Strings.LICNI_RAZVOJ_PAGE_TITLE) : "Error: Wrong title. Expected: " +
                    Strings.LICNI_RAZVOJ_PAGE_TITLE + ". Actual: " + currentPageTitle;

            print("7. On navigation bar click on 'TIKTOK HITOVO' category and verify that the correct URL is displayed");
            basePage.openNavBarCategory(Strings.TITTOK_HITOVI_NAVBAR_TITLE, Strings.TIKTOK_URL);
            print("7. Verify the correct page title");
            currentPageTitle = driver.findElement(By.xpath(Strings.ALL_PAGES_TITLE_XPATH)).getText();
            assert currentPageTitle.equals(Strings.TITTOK_HITOVI_PAGE_TITLE) : "Error: Wrong page title. Expected: " +
                    Strings.TITTOK_HITOVI_PAGE_TITLE + ". Actual: " + currentPageTitle;


            print("8. On navigation bar click on 'HAPPY POTTER' category and verify that the correct URL is displayed");
            basePage.openNavBarCategory(Strings.HARRY_POTTER_NAVBAR_TITLE, Strings.HARRY_POTTER_URL);

            print("8.Verify the correct page title");
            currentPageTitle = driver.findElement(By.xpath(Strings.ALL_PAGES_TITLE_XPATH)).getText();
            assert currentPageTitle.equals(Strings.HARRY_POTTER_PAGE_TITLE) : "Error: Wrong title. Expected: " +
                    Strings.HARRY_POTTER_PAGE_TITLE + ". Actual: " + currentPageTitle;


            print("9. On navigation bar click on 'USKORO' category and verify that the correct URL is displayed");
            basePage.openNavBarCategory(Strings.USKORO_NBAR_TITLE, Strings.USKORO_URL);
            print("6.Verify the correct page title");
            currentPageTitle = driver.findElement(By.xpath(Strings.ALL_PAGES_TITLE_XPATH)).getText();
            assert currentPageTitle.equals(Strings.USKORO_PAGE_TITLE) : "Error: Wrong title. Expected: " +
                    Strings.USKORO_PAGE_TITLE + ". Actual: " + currentPageTitle;

        }
        finally {
            print("Test finished");
        }
    }

    /**
     * Selecting 'KATEGORIJA' category from navigation bar and clicking on 'ZA DECU' opcion from list.
     * Failure intended.
     *
     * Steps:
     * 1. Go to: "https://www.knjizare-vulkan.rs/"
     * 2. On navigation bar click on 'KATEGORIJA' category
     * 3. Click on 'ZA DECU' OPCION from list
     *
     * Expected results:
     * 3. Verify that you are redirected to 'ZA DECU' page URL
     */

    @Test
    public void failureTest() {
            ChromeDriver driver = openChromeDriver();
            try {
            print("1. Go to: 'https://www.knjizare-vulkan.rs/'");
            InventoryPage inventoryPage = new InventoryPage(driver);

            print("2. On navigation bar click on 'KATEGORIJE' category");
            inventoryPage.openNavBarCategory(Strings.KATEGORIJE_PROIZVODA_NAVBAR_TITLE, Strings.KATEGORIJA_PROIZVODA_URL);

            print("3. Click on 'ZA DECU' brand from list");
            inventoryPage.clickZaDecuButton();

            print("3. Verify that you are redirected to 'ZA DECU' page URL");
            String actualUrl = driver.getCurrentUrl();
            assertUrl(actualUrl, Strings.ZA_DECU_URL);
        }
        finally {
            print("Test finished");
        }
    }
}

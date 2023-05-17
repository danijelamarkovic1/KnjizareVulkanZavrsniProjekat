package Tests;

import Pages.BasePage;
import Pages.HomePage;
import Pages.InventoryPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.util.Strings;

import java.util.ArrayList;
import java.util.Collections;

public class FilterAndSortTest extends BaseTests {

    /**
     * Testing filters on Inventory page: 'IZDAVAC' filter, 'POVEZ' filter,
     * 'PISMO'filter, 'BREND'filter 'CENA' filter and 'SORTIRAJ' dropdown filter
     *
     * Steps:
     * 1. Go to: 'https://www.knjizare-vulkan.rs/'
     * 2. Select 'FINESA' from 'IZDAVAC' checkbox list
     * 3. Select 'BROŠ' from 'POVEZ' checkbox list
     * 4. Select 'ĆIRILICA' from 'PISMO' checkbox list
     * 5. Select '0-750 RSD' size from 'CENA' checkbox list
     * 6. Select 'Najjeftinije prvo' from 'SORTIRAJ' dropdown
     *
     * Expected results:
     * 5. Verify that URL with all selected filters is displayed
     * 6. Verify that sorting is done correctly
     */


     ChromeDriver driver = new ChromeDriver();

        @Test
        public void itemFiltersAndDropDownTest() {
            ChromeDriver driver = openChromeDriver();

            try {print("1. Go to: 'https://www.knjizare-vulkan.rs'");
                HomePage homePage = new HomePage(driver);

                print("2. From NavBar select 'KATEGORIJE' category and verify that the correct URL is displayed");
                homePage.openNavBarCategory("KATEGORIJE","https://www.knjizare-vulkan.rs/kategorije-proizvoda-landing" );

                print("3. Select 'FINESA' from 'IZDAVAC' list");
                InventoryPage inventoryPage = new InventoryPage(driver);
                inventoryPage.selectIzdavacFilterList("FINESA");

                print("4. Select 'BROŠ' from 'POVEZ' checkbox list");
                inventoryPage.selectPovezFilterList("BROŠ");

                print("5. Select 'ĆIRILICA' from 'PISMO' checkbox list");
                inventoryPage.selectPismoFromFilterList("ĆIRILICA");

                print("6. Select '0-750 RSD' size from 'CENA' checkbox list");
                inventoryPage.selectCenaFromFilterList("0 - 750 RSD");

                print("6. Verify that URL with all selected filters is displayed");
                String actualURL = driver.getCurrentUrl();
                assertUrl(actualURL, "https://www.knjizare-vulkan.rs/proizvodi/finesa/bros/cirilica/?prices=0-750");

                ArrayList<Double> itemPricesBeforeSorting = inventoryPage.getAllItemPrices("//div[@class='prices-wrapper']");

                print("7. Select 'Najjeftinije prvo' from 'SORTIRAJ' dropdown");
                inventoryPage.selectDropDownFilter("Najjeftinije");

                ArrayList<Double> itemPricesAfterSorting = inventoryPage.getAllItemPrices("//div[@class='prices-wrapper']");
                Collections.sort(itemPricesBeforeSorting);

                print("7. Verify that sorting is done correctly");
                assert itemPricesAfterSorting.equals(itemPricesBeforeSorting) : "Error: Sorting didn't work";

            }
            finally {
                print("Test finished");
            }
        }

    }


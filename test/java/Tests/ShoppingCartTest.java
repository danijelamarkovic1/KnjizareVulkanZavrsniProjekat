package Tests;

import Pages.BasePage;
import Pages.InventoryPage;
import Pages.ShoppingCartPage;
import Pages.Strings;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTests{

    /**
     * Add item to shopping cart
     *
     * Steps:
     * 1.Navigate to https://www.knjizare-vulkan.rs
     * 2.Click search button
     * 3.Enter in the item name and press enter,and click on CAROBNE PRICE from the displayed search results list
     * 4.Confirm that the user is navigated and open to the CAROBNE PRICE
     * 5.Confirm shopping cart is number 1.
     * 6.Click on the shopping cart icon, and verify that the selected product on page URL.
     * 7.Login user with exsiting user
     * 8.Confirm button Potvrdi  is present
     *
     * Expected results:
     * 4.Verify that the user is navigated and open to the CAROBNE PRICE URL
     * 5.Verify shopping cart is number 1.
     * 7.Verify thah user login
     * 8.Verify button Potvrdi  is present.
     *
     */

    @Test

    public void addItemToShoppingCart(){
        ChromeDriver driver = openChromeDriver();
        try {
            print("1.Navigate to https://www.knjizare-vulkan.rs");
            BasePage basePage = new BasePage(driver);
            print("2.Click on search button");
            basePage.clickSearchIcon();

            print("3.Enter in the item name and press enter,and click on SMRTNI ISHODI ATLETSKIH POVREDA from the displayed search results list");
             basePage.enterTextIntoSearchField(Strings.SMRTNI_ISHODI_ATLETSKIH_POVREDA_TEXT);
            InventoryPage inventoryPage = new InventoryPage(driver);
            inventoryPage.clickOnBook(Strings.SMRTNI_ISHODI_ATLETSKIH_POVREDA_TEXT);
            print("4.Verify that the user is navigated and open to the CAROBNE PRICE URL ");
            assert isCurrentURLEqualTo(Strings.SMRTNI_ISHODI_ATLETSKIH_POVREDA_URL):"ERROR.";

            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
            shoppingCartPage.clickButtonAddToCart();
            shoppingCartPage.sleep(5);
            print ("5.Verify shopping cart is number 1." );
            String numberItemInShopingCart = shoppingCartPage.getNumberOfItemInCartFromBadge();
            assert numberItemInShopingCart.equals("1"): "ERROR. Number cart is not 1.";
            shoppingCartPage.clickPopUp();
            shoppingCartPage.clickMojaKorpa();
            shoppingCartPage.sleep(5);
            print("6.Click on the shopping cart icon, and verify that the selected product on page.");
            assert isCurrentURLEqualTo(Strings.SHOPPING_CART_PAGE_URL):"ERROR." + "Not is open page.";
            shoppingCartPage.listItemInShoppingCart();
            print("7.In modal login, login with existing user. ");
            shoppingCartPage.clickPrijavaModalForShopping();
            shoppingCartPage.prijavaKorisnikaShopping();
            print("8.Verify button Potvrdi shopping is present");
            shoppingCartPage.buttonPotvrdiKupovinuIsPresent();

        }finally {
          driver.quit();
        }
    }
}

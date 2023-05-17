package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryItemPage extends BasePage{

    @FindBy(id="nb_addToCartButton")
    WebElement dodajUKorpuButton;

    @FindBy(id="product_quantity")
    WebElement numberItemValue;

    @FindBy(xpath = "//div[@class='product-favorite favorite product-wishlist-add pulse']//span[@class='text'][contains(text(),'Sačuvajte u listi želja')]")
    WebElement sacuvajNaListiZeljaLinkText;

    @FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 product-detail-wrapper']//span[@class='text'][contains(text(),'Uklonite iz liste želja')]")
    WebElement ukloniIzListeZeljaLinkText;

    @FindBy(className = "toggle-banner")
    WebElement pomocToggleBanner;

    @FindBy(xpath = "//div[@class = 'toggle-button expand']")
    WebElement closePomocToggleBanner;


    public InventoryItemPage(ChromeDriver driver) {
        super(driver);
    }



    public void clickAddToCartButton() {
        dodajUKorpuButton.click();
    }


    public Integer getNumberFromShoppingCartIcon() {
        waitForElement(shoppingCartBadgeNumber);
        String number = shoppingCartBadgeNumber.getText();
        return Integer.valueOf(number);
    }


    public void waitForShoppingBadgeNumber(Integer currentNumber, Integer x) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        currentNumber += x;
        String number = "" + currentNumber;
        wait.until(ExpectedConditions.textToBe(By.className("header-carthor-total"), number));
    }






}

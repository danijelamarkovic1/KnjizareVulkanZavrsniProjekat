package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage{

    //Web Elementi
  /*  @FindBy(xpath = "//button[@id='nb_addToCartButton']")
    WebElement buttonAddtoCart;

    @FindBy(xpath = "//div[@class='block mini-cart mini-cart-simple']//a[@title='Korpa']")
    WebElement popUpCart;

    @FindBy(xpath = "//div[@id='miniCartContent']//a[@title='MOJA KORPA']")
    WebElement mojaKorpa;

    @FindBy(className = "header-carthor-total")
    WebElement numberCartIcon;

    @FindBy(xpath = "//table[@class='table cart-table']")
    WebElement cartTable;

    @FindBy(xpath = "//h3[text()='Prijava']")
    WebElement prijavaForShopping;

    @FindBy (id="login_email")
    WebElement userEmailTextFieldForShopping;

    @FindBy (id="login_password")
    WebElement userPasswordTextFieldForShopping;

    @FindBy (xpath = "//button[@class ='btn btn-success btn-login confirm-loader']")
    WebElement prijavaButtonForShopping;

    @FindBy (xpath = "//button[@id='submit_order_one_page']")
    WebElement potvrdiShoppingButton;


    //konstruktor
    public ShoppingCartPage(ChromeDriver driver) {
        super(driver);
    }

    //metode nad WebElemntima
    public void clickButtonAddToCart() {
        assert isElementPresent(buttonAddtoCart) : "ERROR. Add to cart button is not displayed.";
        buttonAddtoCart.click();
    }

    public void clickPopUp(){
        assert isElementPresent(popUpCart);
        popUpCart.isDisplayed();
    }

    public void clickMojaKorpa() {
        assert isElementPresent(mojaKorpa);
        mojaKorpa.click();
    }

    public String getNumberOfItemInCartFromBadge() {
        print("get number of item in cart from badge");
        return numberCartIcon.getText();
    }

    public void listItemInShoppingCart() {
        List<WebElement> rowsList = cartTable.findElements(By.tagName("tr class"));
        List<WebElement> columnsList = null;
        for (WebElement row : rowsList) {
            System.out.println();
            columnsList = row.findElements(By.className("cart-product"));
            for (WebElement column : columnsList) {
                print(column.getText() + ",");
                print("***************************************");

            }
        }
    }

    public void clickPrijavaModalForShopping () {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", prijavaForShopping);
        assert isElementPresent(prijavaForShopping) : "ERROR. Login,in shopping cart is not possible.";
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", prijavaForShopping);
        sleep(5);
    }

    public void enterUserEmailTextFieldInShopping(String text){
        print("Entering text" + text +  "is user Email field");
        assert isElementPresent (userEmailTextFieldForShopping):"ERROR. Login Modal is not open.";
        userEmailTextFieldForShopping.click();
        userEmailTextFieldForShopping.sendKeys(Strings.EMAIL);
    }

    public void enterPasswordTextFieldInShopping(String text){
        print("Entering text" + text +  "is Password field");
        assert isElementPresent (userPasswordTextFieldForShopping):"ERROR. Login Modal is not open.";
        userPasswordTextFieldForShopping.click();
        userPasswordTextFieldForShopping.sendKeys(Strings.PASSWORD);
    }

    public void clickPrijavaButtonForShopping(){
        print("clickin Prijavi Se");
        assert isElementPresent(prijavaButtonForShopping) :"ERROR. Login Modal is not open.";
        prijavaButtonForShopping.click();
    }

    public void prijavaKorisnikaShopping(){
        this.enterUserEmailTextFieldInShopping(Strings.VALID_EMAIL);
        this.enterPasswordTextFieldInShopping(Strings.VALID_PASSWORD);
        this.clickPrijavaButtonForShopping();
        sleep(5);
    }

    public void buttonPotvrdiKupovinuIsPresent() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", potvrdiShoppingButton);
        assert isElementPresent(potvrdiShoppingButton) : "ERROR. Button 'Potvrdi' shopping is not displayed in page.";
    }*/

    //Web Elementi
    @FindBy(xpath = "//button[@id='nb_addToCartButton']")
    WebElement buttonAddtoCart;

    @FindBy(xpath = "//div[@class='block mini-cart mini-cart-simple']//a[@title='Korpa']")
    WebElement popUpCart;

    @FindBy(xpath = "//div[@id='miniCartContent']//a[@title='MOJA KORPA']")
    WebElement mojaKorpa;

    @FindBy(className = "header-carthor-total")
    WebElement numberCartIcon;

    @FindBy(xpath = "//table[@class='table cart-table']")
    WebElement cartTable;

    @FindBy(xpath = "//h3[text()='Prijava']")
    WebElement prijavaForShopping;

    @FindBy (id="login_email")
    WebElement userEmailTextFieldForShopping;

    @FindBy (id="login_password")
    WebElement userPasswordTextFieldForShopping;

    @FindBy (xpath = "//button[@class ='btn btn-success btn-login confirm-loader']")
    WebElement prijavaButtonForShopping;

    @FindBy (xpath = "//button[@id='submit_order_one_page']")
    WebElement potvrdiShoppingButton;


    //konstruktor
    public ShoppingCartPage(ChromeDriver driver) {
    super(driver);
    }

    //metode nad WebElemntima
    public void clickButtonAddToCart() {
        assert isElementPresent(buttonAddtoCart) : "ERROR. Add to cart button is not displayed.";
        buttonAddtoCart.click();
    }

    public void clickPopUp(){
        assert isElementPresent(popUpCart);
        popUpCart.isDisplayed();
    }

    public void clickMojaKorpa() {
        assert isElementPresent(mojaKorpa);
        mojaKorpa.click();
    }

    public String getNumberOfItemInCartFromBadge() {
        print("get number of item in cart from badge");
        return numberCartIcon.getText();
    }

    public void listItemInShoppingCart() {
        List<WebElement> rowsList = cartTable.findElements(By.tagName("tr class"));
        List<WebElement> columnsList = null;
        for (WebElement row : rowsList) {
            System.out.println();
            columnsList = row.findElements(By.className("cart-product"));
            for (WebElement column : columnsList) {
                print(column.getText() + ",");
                print("***************************************");

            }
        }
    }

    public void clickPrijavaModalForShopping () {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", prijavaForShopping);
        assert isElementPresent(prijavaForShopping) : "ERROR. Login,in shopping cart is not possible.";
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", prijavaForShopping);
        sleep(10);
    }

    public void enterUserEmailTextFieldInShopping(String text){
        print("Entering text" + text +  "is user Email field");
        assert isElementPresent (userEmailTextFieldForShopping):"ERROR. Login Modal is not open.";
        userEmailTextFieldForShopping.click();
        userEmailTextFieldForShopping.sendKeys(Strings.VALID_EMAIL);
    }

    public void enterPasswordTextFieldInShopping(String text){
        print("Entering text" + text +  "is Password field");
        assert isElementPresent (userPasswordTextFieldForShopping):"ERROR. Login Modal is not open.";
        userPasswordTextFieldForShopping.click();
        userPasswordTextFieldForShopping.sendKeys(Strings.VALID_PASSWORD);
    }

    public void clickPrijavaButtonForShopping(){
        print("clickin Prijavi Se");
        assert isElementPresent(prijavaButtonForShopping) :"ERROR. Login Modal is not open.";
        prijavaButtonForShopping.click();
    }

    public void prijavaKorisnikaShopping(){
        this.enterUserEmailTextFieldInShopping(Strings.VALID_EMAIL);
        this.enterPasswordTextFieldInShopping(Strings.VALID_PASSWORD);
        this.clickPrijavaButtonForShopping();
        sleep(10);
    }

    public void buttonPotvrdiKupovinuIsPresent() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", potvrdiShoppingButton);
        assert isElementPresent(potvrdiShoppingButton) : "ERROR. Button 'Potvrdi' shopping is not displayed in page.";
    }

    }



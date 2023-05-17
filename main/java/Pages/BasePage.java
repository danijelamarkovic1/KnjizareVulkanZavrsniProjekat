package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BasePage {
    ChromeDriver driver;

    @FindBy(id = "modal-cookie-info")
    WebElement cookieModal;

    @FindBy(className = "cookie-agree 3")
    WebElement cookieSlazemSeButton;

    @FindBy(xpath = "//div[@class='col-xs-12 col-sm-3 col-md-4']//div[@class='block logo']")
    WebElement headerLogo;

    @FindBy(className = "login-btn")
    public
    WebElement prijaviSeHeaderButton;

    @FindBy(className = "register-btn")
    public
    WebElement registrujSeHeaderButton;

    @FindBy(xpath = "//a[@title ='Korpa']")
    WebElement shoppingCartIcon;

    @FindBy(className = "header-carthor-total")
    WebElement shoppingCartBadgeNumber;

    @FindBy(xpath = "//input[@id='search-text']")
    WebElement searchTextField;

    @FindBy(xpath="//i[@class='icon fa fa-search']")
    WebElement searchIcon;

    @FindBy(xpath = "//a[@href = 'https://www.facebook.com/vulkanknjizare']")
    WebElement facebookLinkButton;

    @FindBy(xpath = "//a[@href = 'https://twitter.com/Knjizare_Vulkan']")
    WebElement twitterLinkButton;

    @FindBy(xpath = "//a[@href = 'https://www.instagram.com/vulkan_knjizare/']")
    WebElement instagramLinkButton;

    @FindBy(xpath = "//a[@href = 'https://www.tiktok.com/@vulkan_knjizare']")
    WebElement tiktokLinkButton;

    public BasePage(ChromeDriver driver) {
        print("Base Page");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BasePage() {
    }

    public void clickHeaderLogo() {
        headerLogo.click();
    }

    public void clickPrijaviSeHeaderButton() {
        prijaviSeHeaderButton.click();
    }
    public void clickRegistrujSeHeaderButton() {
        registrujSeHeaderButton.click();
    }
    public void clickSearchIcon(){
        searchIcon.click();
    }
    public void enterTextIntoSearchField(String text) {
        searchTextField.sendKeys(text);
        searchTextField.sendKeys(Keys.ENTER);
    }
    public ShoppingCartPage clickShoppingCartIcon() {
        shoppingCartIcon.click();
        return new ShoppingCartPage(driver);
    }


    // Create navbar link list, select one by title and verify that correct URL is displayed
    public InventoryPage openNavBarCategory(String categoryTitle, String categoryUrl) {
        List<WebElement> allCategories = driver.findElements(By.xpath(Strings.NAVBAR_CATEGORY_LIST_XPATH));
        for(WebElement category : allCategories) {
            if(category.getAttribute("title").equals(categoryTitle)){
                print("Click on: " + categoryTitle);
                category.click();
                print("Verify that " + categoryUrl + " URL is displayed.");
                String actualUrl = driver.getCurrentUrl();
                assertUrl(actualUrl, categoryUrl);
                print("Selected category: " + categoryTitle + ".");
                return new InventoryPage(driver);
            }
        }
        throw new AssertionError("Error: Navbar category " + categoryTitle + " not found");
    }

    // Verify that Facebook link button is present, scroll down the Home page (alignToTop argument is set to false
    // because the navigation bar was covering some links, and they weren't clickable)
    public void clickOnFacebookLinkButton() {
        assert isElementPresent(facebookLinkButton) : "Error. Facebook button is not displayed.";
        scrollToElement(facebookLinkButton);
        facebookLinkButton.click();
    }

    // Click on Facebook link, switch to Knjizare Vulkan/Facebook tab, assert URL, close Facebook tab, switch to Home page tab
    public void openAndCloseFacebookPage() {
        waitForElement(facebookLinkButton);
        print("Click on Facebook link button.");
        clickOnFacebookLinkButton();
        print("Switch to Facebook tab.");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        print("Verify that Facebook URL is displayed.");
        String actualUrl = driver.getCurrentUrl();
        assertUrl(actualUrl, Strings.FACEBOOK_URL);
        print("Close Facebook tab.");
        driver.close();
        print("Switch to Home page tab.");
        driver.switchTo().window(tabs.get(0));
    }

    public void clickTwitterLinkButton() {
        assert isElementPresent(twitterLinkButton) : "Error. Twitter button is not displayed.";
        scrollToElement(twitterLinkButton);
        twitterLinkButton.click();
    }

    public void openAndCloseTwitterPage() {
        waitForElement(twitterLinkButton);
        print("Click on Twitter link button.");
        clickTwitterLinkButton();
        print("Switch to Twitter tab.");
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        print("Verify that Twitter URL is displayed.");
        String actualUrl =driver.getCurrentUrl();
        assertUrl(actualUrl, Strings.TWITTER_URL);
        print("Close Twitter tab.");
        driver.close();
        print("Switch to Home page tab.");
        driver.switchTo().window(tabs.get(0));
    }


    public void clickOnInstagramLinkButton() {
        assert isElementPresent(instagramLinkButton) : "Error. Instagram button is not displayed.";
        scrollToElement(instagramLinkButton);
        instagramLinkButton.click();
    }
    public void openAndCloseInstagramPage() {
        waitForElement(instagramLinkButton);
        print("Click on Instagram link button.");
        clickOnInstagramLinkButton();
        print("Switch to Instagram tab.");
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        print("Verify that Instagram URL is displayed.");
        String actualUrl =driver.getCurrentUrl();
        assertUrl(actualUrl, Strings.INSTAGRAM_URL);
        print("Close Instagram tab.");
        driver.close();
        print("Switch to Home page tab.");
        driver.switchTo().window(tabs.get(0));
    }

    public void clickTiktokButton() {
        assert isElementPresent(tiktokLinkButton) : "Error. Tiktok button is not displayed.";
        scrollToElement(tiktokLinkButton);
        tiktokLinkButton.click();
    }
    public void openAndCloseTiktokChannel() {
        waitForElement(tiktokLinkButton);
        print("Click on Tiktok link button.");
        clickTiktokButton();
        print("Switch to YouTube tab.");
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        print("Verify that Tiktok URL is displayed.");
        String actualUrl = driver.getCurrentUrl();
        assertUrl(actualUrl, Strings.TIKTOK_URL);
        print("Close Tiktok tab.");
        driver.close();
        print("Switch to Home page tab.");
        driver.switchTo().window(tabs.get(0));
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = driver;
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public void assertUrl(String actualUrl, String expectedUrl) {
        print("assertUrl (" + actualUrl + ", " + expectedUrl + ")");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        assert actualUrl.equals(expectedUrl) : "Wrong URL. Expected: " + expectedUrl + ". Actual: " + actualUrl;
    }

    public boolean isElementPresent(WebElement element){
        print("Is element present?");
        try {
            boolean isPresent = element.isDisplayed();
            return true;
        }catch (Exception e) {
            print(e.getMessage());
            print("Element is not present");
            return false;
        }
    }


    public static void print(String text) {
        System.out.println(text);
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Wait for the page to refresh (after selecting a filter)
    public void waitForStalenessOfElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public void waitForItemListToReload(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // Wait for item list to disappear from the page
        wait.until(ExpectedConditions.stalenessOf(driver.findElementByXPath(Strings.ALL_ITEM_LIST_XPATH)));

        // Wait for item list to appear again
        wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath(Strings.ALL_ITEM_LIST_XPATH)));
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep((long)seconds * 1000);
        }
        catch (Exception e) {
            print(e.getMessage());
        }
    }


}

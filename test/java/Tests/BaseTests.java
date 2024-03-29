package Tests;

import Pages.LoginPage;
import Pages.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class BaseTests {

    private ChromeDriver driver;

    public ChromeDriver getDriver() {
        return driver;
    }

    public ChromeDriver openChromeDriver() {
        print("Opening Chrome Driver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");
        //options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(Strings.HOME_PAGE_URL);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal-cookie-info")));
        driver.findElement(By.xpath("//button[@class='cookie-agree 3'][.//span[contains(text(), 'Slažem se')]]")).click();

        this.driver = driver;
        return driver;
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }


    public static void print(String s) {
        System.out.println(s);
        Reporter.log(s);
    }


    public static void sleep(int seconds) {
        try {
            Thread.sleep((long)seconds * 1000);
        } catch (Exception e) {
            print(e.getMessage());
        }
    }


    public void assertUrl(String actualUrl, String expectedUrl) {
        print("assertUrl (" + actualUrl + ", " + expectedUrl + ")");
        assert actualUrl.equals(expectedUrl) : "Wrong URL. Expected: " + expectedUrl + ". Actual: " + actualUrl;
    }

    public boolean isCurrentURLEqualTo (String expectedURL){
        print("isCurrentURLEqualTo ( " + expectedURL + " ) ");
        String currentURL = driver.getCurrentUrl();
        print( " User is on " + currentURL );
        boolean b = currentURL.equals(expectedURL);
        return b;
    }
    public static void login (ChromeDriver driver, String email, String password) {
        LoginPage loginPage = new LoginPage (driver);

        print("Click 'Prijavi se' header link");
        loginPage.clickPrijaviSeHeaderButton();
        print("Enter Email " + email);
        loginPage.enterTextIntoEmailField(email);

        print("Enter valid password " + password);
        loginPage.enterTextIntoSearchField(password);

        print("Click login button");
        loginPage.clickLoginModalButton();

        // Wait for the page to reload
        // (header logo is on every page, so waiting for it to be stale is the same as waiting for the page to reload)
        loginPage.waitForStalenessOfElement(driver.findElementByXPath(Strings.HEADER_LOGO_XPATH.toString()));
    }
}

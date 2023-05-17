package Tests;

import Pages.BasePage;
import Pages.RegisterPage;
import Pages.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTests{
    /**
     *
     * Registration test with valid credential
     *
     * Steps:
     * 1.Navigate to https://www.knjizare-vulkan.rs
     * 2.In header right corner click button Registrujte se
     * 3.In modal Prijavite se enter valid credential
     * 4.Click in modal  button Prijava
     *
     * Expected results:
     * 4. Verify that registration is not possible, clickin button "Nisam robot"(reCapha) open is confirmation modal with images
     * When security is not confirmend, an error message appears(reCapha) "Изазов за верификацију је истекао. Означите поново поље за потврду."
     and allert message "Neispravno popunjeno anti spam polje!"
     */



    @Test
    public void registerWithValidCredentials() {
        print("Go to:https://www.knjizare-vulkan.rs ");
        ChromeDriver driver = openChromeDriver();

        try {
            BasePage basePage = new BasePage(driver);
            basePage.clickRegistrujSeHeaderButton();
            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.fillRegisterModal();

            String actualMessage = driver.findElement(By.xpath(Strings.ALERT_MESSAGE_CONTAINER_XPATH)).getText();
            print("assertAlertMessage (" + actualMessage + ", " + Strings.REGISTER_ALERT_MESSAGE_TEXT + ")");
            assert actualMessage.equals(Strings.REGISTER_ALERT_MESSAGE_TEXT) : "Wrong message. Expected: " + Strings.REGISTER_ALERT_MESSAGE_TEXT + ". Actual: " + actualMessage;

            registerPage.clickRegistracijaButton();
            print("Verify that Home page is displayed.");
            String actualUrl = driver.getCurrentUrl();
            assertUrl(actualUrl, Strings.HOME_PAGE_URL);

        }
        finally {
            print("Test finished");
        }
    }

}


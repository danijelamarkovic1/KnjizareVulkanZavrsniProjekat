package Tests;

import Pages.BasePage;
import Pages.LoginPage;
import Pages.Strings;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTests{


    /**
     * Successful login from any page with valid credentials
     *
     * Steps:
     * 1. Go to: "https://www.knjizare-vulkan.rs/"
     * 2. Click on 'Prijavite se' header button to open login modal
     * 3. Enter valid mail address
     * 4. Enter valid password
     * 5. Click 'PRIJAVA' login button
     *
     * Expected results:
     * 5. Verify that 'Prijavi se' header link has changed into user link
     * 5. Verify that 'Registrujte se' header link has changed into 'Odjava' link
     */

    @Test
    public void loginFromAnyPageWithValidCredentials() {
        ChromeDriver driver = openChromeDriver();
        try {
            print("1. Go to: https://www.knjizare-vulkan.rs/");
            LoginPage loginPage = new LoginPage(driver);

            print("2. Click on 'Prijavi se' header button to open login modal");
            loginPage.openLoginModal();

            print("3. Enter valid username");
            loginPage.enterTextIntoEmailField(Strings.EMAIL);

            print("4. Enter valid password");
            loginPage.enterTextIntoPasswordField(Strings.PASSWORD);

            print("5. Click 'PRIJAVA' login button");
            loginPage.clickLoginModalButton();

            loginPage.waitForElement(loginPage.userHeaderLink);
            print("5. Verify that 'Prijavi se' header link has changed into user link");
            assert loginPage.isElementPresent(loginPage.userHeaderLink) : "Error: Wrong header link. Expected: " +
                    loginPage.userHeaderLink + ". Actual: " + loginPage.registrujSeHeaderButton;

            print("5. Verify that 'Registrujte se' header link has changed into 'Odjava' link");
            assert loginPage.isElementPresent(loginPage.odjavaHeaderLink ) : "Error: Wrong header link. Expected: " +
                    loginPage.odjavaHeaderLink + ". Actual: " + loginPage.registrujSeHeaderButton;

        }
        finally {
            print("Test finished");
        }
    }



    /**
     * Login with valid Email address and invalid password
     *
     * Steps:
     * 1. Go to: "https://www.knjizare-vulkan.rs/"
     * 2. Click on 'Prijavi se' header button to open login modal
     * 3. Enter valid mail address
     * 4. Enter invalid password
     * 5. Click 'PRIJAVA' login button
     * 6. Click close button
     *
     * Expected results:
     * 5. Verify that alert message is shown
     * 6. Verify that 'Prijavi se' button has NOT changed into user profil
     * 6. Verify that 'Registrujte se' button has NOT changed into 'Odjava' button
     */

    @Test
    public void loginFromAnyPageWithValidEmailAndInvalidPassword() {

         ChromeDriver driver = openChromeDriver();


        try {
            print("1. Go to:https://www.knjizare-vulkan.rs/ ");
            driver.get("https://www.knjizare-vulkan.rs/");
            LoginPage loginPage = new LoginPage(driver);

            print("2. Click on 'Prijavi se' header button to open login modal");
            loginPage.openLoginModal();

            print("3. Enter valid username");
            loginPage.enterTextIntoEmailField(Strings.EMAIL);

            print("4. Enter valid password");
            loginPage.enterTextIntoPasswordField(Strings.INVALID_PASSWORD);

            print("5. Click 'PRIJAVA' login button");
            loginPage.clickLoginModalButton();

            print("5. Verify that alert message is shown");
            loginPage.verifyAlertMessage();

            print("6. Click close button");
            loginPage.closeLoginModal();

            print("6. Verify that 'Prijavi se' header link has NOT changed into user link");
            assert loginPage.isElementPresent(loginPage.userHeaderLink) : "Error: Wrong header link. Expected: " +
                    loginPage.prijaviSeHeaderButton + ". Actual: " + loginPage.userHeaderLink;


            print("6. Verify that 'Registrujte se' header link has NOT changed into 'Odjava' link");
            assert !loginPage.isElementPresent(loginPage.odjavaHeaderLink) : "Error: Wrong header link. Expected: " +
                    loginPage.odjavaHeaderLink + ". Actual: " + loginPage.registrujSeHeaderButton;

        }
        finally {
            print("Test finished");
        }
    }



    /**
     * Login and Logout test
     * Steps:
     * 1. Go to: "https://www.knjizare-vulkan.rs/"
     * 2. Login with valid credentials
     * 3. Click on the 'Odjava' header link
     *
     * Expected results:
     * 2. Verify that 'Prijavi se' button has changed into user profil
     * 2. Verify that 'Registrujte se' button has changed into 'Odjava' button
     * 3. Verify that 'Prijavi se' button has NOT changed into user profil
     * 3. Verify that 'Registrujte se' button has NOT changed into 'Odjava' button
     */

    @Test
    public void loginLogoutTest() {
        ChromeDriver driver = openChromeDriver();

        try {
            print("1. Go to: https://www.knjizare-vulkan.rs/ ");
            LoginPage loginPage = new LoginPage(driver);

            print("2. Login with valid credentials");
            login(driver,Strings.VALID_EMAIL, Strings.VALID_PASSWORD);

            loginPage.waitForElement(loginPage.userHeaderLink);
            print("2. Verify that 'Prijavi se' button has changed into user profil");
            assert loginPage.isElementPresent(loginPage.userHeaderLink) : "Error: Wrong header link. Expected: " +
                    loginPage.userHeaderLink + ". Actual: " + loginPage.prijaviSeHeaderButton;

            print("2. Verify that 'Registrujte se' button has changed into 'Odjava' button");
            assert loginPage.isElementPresent(loginPage.odjavaHeaderLink) : "Error: Wrong header link. Expected: " +
                    loginPage.odjavaHeaderLink + ". Actual: " + loginPage.registrujSeHeaderButton;

            print("3. Click on the 'Odjava' button");
            loginPage.clickOdjavaHeaderLink();

            print("3. Verify that 'Prijavi se' button has NOT changed into user link");
            assert !loginPage.isElementPresent(loginPage.userHeaderLink) : "Error: Wrong header link. Expected: " +
                    loginPage.prijaviSeHeaderButton + ". Actual: " + loginPage.userHeaderLink;

            print("3. Verify that 'Registrujte se' header link has NOT changed into 'Odjava' link");
            assert loginPage.isElementPresent(loginPage.odjavaHeaderLink) : "Error: Wrong header link. Expected: " +
                    loginPage.registrujSeHeaderButton + ". Actual: " + loginPage.odjavaHeaderLink;
            driver.quit();

        }
        finally {
            print("Test finished");
        }
    }
}

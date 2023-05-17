package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id="login_modal")
    WebElement loginModal;

    @FindBy(id="login_email")
    WebElement loginEmailAdresaField;

    @FindBy(id = "login_password")
    WebElement loginLozinkaField;

    @FindBy(xpath = "//button[@class='btn btn-success btn-login confirm-loader']")
    public
    WebElement prijavaButtonModal;

    @FindBy(xpath = "//form[@class='login_form']//button[@type='button'][class='close']")
    WebElement closePrijavaModal;

    @FindBy (xpath = "// div[@class='alert alert-danger']")
    WebElement errorAlertWrongPassword;

    @FindBy (xpath = "//li[@class='item item-username']")
    public
    WebElement userHeaderLink;

    @FindBy(xpath = "//li[@class = 'item item-logout']")
    public WebElement odjavaHeaderLink;

    public LoginPage(ChromeDriver driver) {
        super(driver);
    }

    public void openLoginModal(){
        clickPrijaviSeHeaderButton();
        waitForElement(loginModal);
        assert isElementPresent (loginModal);
        new LoginPage(driver);}


    public void enterTextIntoEmailField(String email) {
        waitForElement(loginEmailAdresaField);
        print("Entering text" +email+   "is user Email field");
        assert isElementPresent (loginEmailAdresaField):"ERROR. Login Modal is not open.";
        loginEmailAdresaField.sendKeys(Strings.VALID_EMAIL);
    }

    public void enterTextIntoPasswordField(String password) {
        waitForElement(loginLozinkaField);
        print("Entering text" + password + " in Password field");
        assert isElementPresent ( loginLozinkaField ):"ERROR. Login Modal is not open.";
        loginLozinkaField.click();
        loginLozinkaField.sendKeys(Strings.VALID_PASSWORD);
    }

    public void clickLoginModalButton() {
        print("clicki na Prijavi se");
        assert isElementPresent(prijavaButtonModal) :"ERROR. Login Modal is not open.";
        prijavaButtonModal.click();
    }

    public void clickOdjavaHeaderLink() {
        assert isElementPresent(odjavaHeaderLink) : "ERROR. You are not logged in.";
        odjavaHeaderLink.click();
    }

    public void erorrAlertIsPresent(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ( "arguments[0].scrollIntoView();", errorAlertWrongPassword);
        assert isElementPresent(errorAlertWrongPassword): "ERROR. ERROR message is not shown.";
    }

    public void verifyAlertMessage() {
        waitForElement(errorAlertWrongPassword);
        String currentMessage = driver.findElement(By.xpath(Strings.ALERT_MESSAGE_CONTAINER_XPATH)).getText();
        assert currentMessage.equals(Strings.LOGIN_ALERT_MESSAGE_TEXT) : "Error: Wrong message. Expected: "
                + Strings.LOGIN_ALERT_MESSAGE_TEXT + ". Actual: " + currentMessage;
    }

    public void closeLoginModal() {
        closePrijavaModal.click();
    }
}

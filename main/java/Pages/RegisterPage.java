package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterPage extends BasePage{


    @FindBy(xpath ="//form[@class='registration_form']")
    WebElement registracijaModal;

   @FindBy(id="reg_type_person")
    WebElement tipKorisnika;

    @FindBy(id="reg_firstname")
    WebElement imeKorisnika;

    @FindBy(id="reg_lastname")
    WebElement prezimeKorisnika;

    @FindBy(id="reg_email")
    WebElement emailKorisnika;

    @FindBy(id="reg_phone")
    WebElement telefonKorisnika;

   @FindBy(id="reg_country_geo")
   WebElement drzavaKorisnika;

    @FindBy(id="reg_city")
    WebElement gradKorisnika;

    @FindBy(id="reg_address")
    WebElement ulicaKorisnika;

    @FindBy(id="reg_street_no")
    WebElement kucniBrojKorisnika;

    @FindBy(id="reg_postcode")
    WebElement postanskiBroj;

    @FindBy(id="reg_password")
    WebElement lozinkaKorisnika;

    @FindBy(id="reg_password_repeat")
    WebElement ponoviteLozinkuKorisnika;

    @FindBy(xpath = "//form[@id='registration_modal']//div[@class='form-group form-group-checklabel']/label[@for='reg_age']")
    WebElement daImamViseOd15Godina;

    @FindBy(xpath = "//label[@for='reg_gender_2']")
    WebElement zenskiPol;

    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    WebElement iFrame;

    @FindBy(id = "recaptcha-anchor-label")
    WebElement reCapchaClick;

    @FindBy (xpath = "//label[contains(@for,'reg_confirm')]")
    WebElement slazemSeSaUslovimaKorisnika;

    @FindBy(xpath = "//form[@id='registration_modal']//button[@type='submit']")
    WebElement registracijaButton;

    @FindBy(id = "rc-imageselect")
    WebElement modalZaPotvrduSigurnosti;

    @FindBy(xpath = "//div[@class='rc-anchor-error-msg-container']//span[@class='rc-anchor-error-msg']")
    WebElement errorMessageSigurnosti;
    @FindBy(xpath = "//form[@class='registration_form']//div[@class='alert alert-success']")
    WebElement porukaUspesneRegistracije;

    @FindBy(xpath = "//div[@class='modal-content']//form[@id='registration_modal']//button[@class='close']")
    WebElement closeDugme;



    //konstruktor
    public RegisterPage(ChromeDriver driver){
        super(driver);
        ;
    }

    //metoda nad WebElementima
    public void openRegistracijaModal (){
        assert isElementPresent ( registracijaModal );
        registracijaModal.click();
    }

   public void selectOptionsInDropdownMenuTipKorisnika(String text){
        Select objSelect = new Select(driver.findElementById("reg_type_person"));
        objSelect.selectByVisibleText("Fizicko Lice");
        if (tipKorisnika.getText().equals("Fizicko lice"))
            tipKorisnika.click();
       tipKorisnika.click();
       waitForStalenessOfElement(tipKorisnika);
       return;
   }

    public void enterImeKorisnika(){
        assert isElementPresent(imeKorisnika): "ERROR. Registration modal is not open";
        imeKorisnika.click();
        imeKorisnika.sendKeys(Strings.FIRST_NAME);
    }

    public void enterPrezimeKorisnika(){
        assert isElementPresent(prezimeKorisnika): "ERROR. Registration modal is not open";
        prezimeKorisnika.click();
        prezimeKorisnika.sendKeys(Strings.LAST_NAME);
    }

    public void enterEmailKorisnika(){
        assert isElementPresent(emailKorisnika): "ERROR. Registration modal is not open";
        emailKorisnika.click();
        emailKorisnika.sendKeys(Strings.EMAIL);
    }

    public void enterTelefonKorisnika(){
        assert isElementPresent(telefonKorisnika): "ERROR. Registration modal is not open";
        telefonKorisnika.click();
        telefonKorisnika.sendKeys(Strings.PHONE_NUMBER);
    }

   public void enterDrzavaKorisnika(){
  assert isElementPresent(drzavaKorisnika): "ERROR. Registration modal is not open";
      drzavaKorisnika.click();
      drzavaKorisnika.sendKeys(Strings.COUNTRY_NAME);
    }

    public void enterGradKorisnika(){
        assert isElementPresent(gradKorisnika): "ERROR. Registration modal is not open";
        gradKorisnika.click();
        gradKorisnika.sendKeys(Strings.CITY);
    }

    public void enterUlicaKorisnika(){
        assert isElementPresent(ulicaKorisnika): "ERROR. Registration modal is not open";
        ulicaKorisnika.click();
        ulicaKorisnika.sendKeys(Strings.STREET);
    }

    public void enterKucniBrojKorisnika(){
        assert isElementPresent(kucniBrojKorisnika): "ERROR. Registration modal is not open";
        kucniBrojKorisnika.click();
        kucniBrojKorisnika.sendKeys(Strings.STREET_NUMBER);
    }

    public void enterPostanskiBroj(){
        assert isElementPresent(postanskiBroj): "ERROR. Registration modal is not open";
        postanskiBroj.click();
        postanskiBroj.sendKeys(Strings.POSTAL_CODE);
    }

    public void enterLozinkaKorisnika(){
        assert isElementPresent(lozinkaKorisnika): "ERROR. Registration modal is not open";
        lozinkaKorisnika.click();
        lozinkaKorisnika.sendKeys(Strings.PASSWORD);
    }

    public void enterPonoviteLozinkuKorisnika(){
        assert isElementPresent(ponoviteLozinkuKorisnika): "ERROR. Registration modal is not open";
        ponoviteLozinkuKorisnika.click();
        ponoviteLozinkuKorisnika.sendKeys(Strings.PASSWORD);
    }

    public void clickDaImamViseOd15Godina(){
        assert isElementPresent(daImamViseOd15Godina): "ERROR. Registration modal is not open";
        daImamViseOd15Godina.click();
    }

    public void clickZenskiPol(){
        assert isElementPresent(zenskiPol): "ERROR. Registration modal is not open";
        zenskiPol.click();
    }

    public void clickReCapchaClick(){
        driver.switchTo().frame(iFrame);
        reCapchaClick.click();
        driver.switchTo().defaultContent();
        return;
    }

    public void clickSlazemSeSaUslovimaKorisnika(){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",slazemSeSaUslovimaKorisnika);
        assert isElementPresent(slazemSeSaUslovimaKorisnika):"ERROR. Registration modal is not open";
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();",slazemSeSaUslovimaKorisnika);
    }

    public void clickRegistracijaButton(){
        assert isElementPresent(registracijaButton):"ERROR. Registration modal is not open";
        registracijaButton.click();
        sleep(20);
    }

    public void setPorukaUspesneRegistracije(){
        assert isElementPresent(porukaUspesneRegistracije):"ERROR. Registration modal is not open";
    }

    public void setPorukaNeuspelaRegistracija(){
        assert isElementPresent(errorMessageSigurnosti):"ERROR. Registration modal is open";
    }

    public void closeDugmeUspesneregistracije(){
        assert isElementPresent(closeDugme):"ERROR. Registration modal is not open";
        closeDugme.click();}


        public void fillRegisterModal() {
            print("Select value from drop down list");
          //  selectOptionsInDropdownMenuTipKorisnika("Fizicko lice");
            print("Enter first name");
            enterImeKorisnika();
            print("Enter last name.");
            enterPrezimeKorisnika();
            print("Enter Email");
            enterEmailKorisnika();
            print("Enter phone number.");
            enterTelefonKorisnika();
            print("Enter country name");
            enterDrzavaKorisnika();
            print("Enter city.");
            enterGradKorisnika();
            print("Enter street.");
            enterUlicaKorisnika();
            print("Enter street number.");
            enterKucniBrojKorisnika();
            print("Enter zip code.");
            enterPostanskiBroj();
            print("Enter password.");
            enterLozinkaKorisnika();
            print("Repeat password.");
            enterPonoviteLozinkuKorisnika();
            print("Click on checkbox Imam vise od 15 godina");
            clickDaImamViseOd15Godina();
            print("Click on female radio button.");
            clickZenskiPol();
            print("Click on anti spam drop down.");
            clickReCapchaClick();
            print("Check 'Slazem se sa uslovima koriscenja' check box.");
            driver.executeScript("arguments[0].click();", slazemSeSaUslovimaKorisnika);
            print("Click on 'REGISTRACIJA' button.");
            clickRegistracijaButton();
        }



}

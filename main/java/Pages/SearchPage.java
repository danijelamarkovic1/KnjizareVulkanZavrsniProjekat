package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage{

    ChromeDriver driver;

    @FindBy(xpath = "//*[@class='row']")
    WebElement searchResultsList;


    // konstruktor
    public SearchPage(ChromeDriver driver) {
     super(driver);
    }


    //metode nad WebElemntima
    public void clickOnBook(String itemName){
        assert isElementPresent(searchResultsList): "ERROR.Search result list not on page";
        List<WebElement> elements = driver.findElements(By.xpath(Strings.XPATH_SMRTNI_ISHODI_ATLETSKIH_POVREDA));
        assert elements.size() !=0 : "ERORR. Aray is empty.";
        elements.get(0).click();
    }
}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends BasePage{

    @FindBy(xpath = "//div[@title='KATEGORIJE']")
    WebElement filterKategorijeNavBar;

    @FindBy(xpath = "/html/body/div[1]/div[3]/nav/div/ul/li[2]/div/div/ul/li[9]/a")
    WebElement pogledajSveButton;


   @FindBy(id= "nb_f-attr-2")
    WebElement filterIzdavacGroup;

    @FindBy(id = "nb_f-attr-10")
    WebElement filterPovezButton;

    @FindBy(id = "nb_f-attr-11")
    WebElement filterPismoGroup;

    @FindBy(id = "nb_f-attr-12")
    WebElement filterBrendGroup;

    @FindBy(className = "filter-group filter-price-wrapper")
    WebElement filterCenaGroup;

    @FindBy(id = "sort")
    WebElement sortirajDropDown;

    @FindBy(xpath = "//a[contains(@title,'ZA DECU')]")
    WebElement zaDecuButton;

    @FindBy(xpath = "//input[@id='search']")
    WebElement PretraziPoNazivuField;

    @FindBy(className = "btn btn-search")
    WebElement pretraziButton;

    @FindBy (xpath = "//*[@class='row']")
    WebElement searchResultsList;
    public InventoryPage(ChromeDriver driver) {
        super(driver);
    }

    public void selectKategorijeFilterNavBar (){
        filterKategorijeNavBar.isSelected();
    }


    public void selectPogledajSveTitle (){
        pogledajSveButton.isSelected();
    }

    public void clickPogledajSveTitle(){
        pogledajSveButton.click();
    }
    public void selectItemTypeFromIzdavacList(String itemTypeTitle) {
        List<WebElement> itemTypeList = driver.findElementsByXPath(Strings.IZDAVAC_FILTER_LIST_XPATH);
        for (WebElement itemType : itemTypeList) {
            if (itemType.getAttribute("title").equals(itemTypeTitle)) {
                itemType.click();

                // Wait for the page to refresh after selecting category filter
                waitForStalenessOfElement(itemType);
                return;
            }
        }
    }



    public void clickFilterCheckbox(String checkboxesXpath, String checkboxTitle) {
        List<WebElement> checkboxList = driver.findElementsByXPath(checkboxesXpath);
        for(WebElement checkbox : checkboxList) {
            // using 'for' attribute of a checkbox label because getText() would also return
            // the number of items available with that filter
            waitForElement(checkbox);
            if(checkbox.getAttribute("for").equals(checkboxTitle)) {
                waitForElementToBeClickable(checkbox);
                checkbox.click();

                // Wait for the page to refresh after selecting a checkbox
                // (wait for checkbox to be stale)
                waitForStalenessOfElement(checkbox);
                return;
            }
        }
    }

    public void selectIzdavacFilterList(String izdavacTypeTitle) {
        waitForElement(driver.findElementByXPath(Strings.IZDAVAC_FILTER_LIST_XPATH));
        clickFilterCheckbox(Strings.IZDAVAC_FILTER_LIST_XPATH, izdavacTypeTitle);
    }


    public void selectPovezFilterList(String povezTypeTitle) {
        waitForElementToBeClickable(filterPovezButton);
        waitForElement(driver.findElementByXPath(Strings.POVEZ_FILTER_LIST_XPATH));
        clickFilterCheckbox(Strings.POVEZ_FILTER_LIST_XPATH, povezTypeTitle);
    }

    public void selectPismoFromFilterList(String pismoTypeTitle) {
        waitForElementToBeClickable(filterPismoGroup);
        waitForElement(driver.findElementByXPath(Strings.PISMO_FILTER_LIST_XPATH));
        clickFilterCheckbox(Strings.PISMO_FILTER_LIST_XPATH, pismoTypeTitle);
    }


    public void selectBrendFromFilterList(String brendTypeTitle) {
        waitForElement(filterBrendGroup);
        waitForElement(driver.findElementByXPath(Strings.BREND_FILTER_LIST_XPATH));
        clickFilterCheckbox(Strings.BREND_FILTER_LIST_XPATH, brendTypeTitle);
    }

    public void selectCenaFromFilterList(String rasponCene) {
        waitForElement(filterCenaGroup);
        waitForElement(driver.findElementByXPath(Strings.BREND_FILTER_LIST_XPATH));
        clickFilterCheckbox(Strings.BREND_FILTER_LIST_XPATH, rasponCene);
    }


    public void selectDropDownFilter(String dropDownText) {
        waitForElement(sortirajDropDown);
        waitForElementToBeClickable(sortirajDropDown);
        Select dropdown = new Select(sortirajDropDown);
        dropdown.selectByVisibleText(dropDownText);
        waitForItemListToReload();
    }


    // search for item type e.g. 'slikovnice' and verify that correct list is displayed
    public void searchItemTypeByKeyword(String keyword) {
        clickSearchIcon();
        enterTextIntoSearchField(keyword);
        List<WebElement> searchResults = getAllItems();

        assert searchResults.size() != 0 : "No results found";
    }


    public List<WebElement> getAllItems() {
        return driver.findElementsByXPath(Strings.ALL_ITEM_LIST_XPATH);
    }


    public InventoryItemPage findItemByName(String itemName) {
        while (true) {
            List<WebElement> itemsList = getAllItems();
            // Going through all items on current page
            for (WebElement item : itemsList) {
                if (item.getAttribute("title").trim().equals(itemName)) {
                    item.click();

                    String pageTitle = driver.findElement(By.xpath(Strings.ALL_PAGES_TITLE_XPATH)).getText().trim();
                    assert pageTitle.equals(itemName.trim()) : "Error: wrong product";

                    return new InventoryItemPage(driver);
                }
            }
        }
    }
    public ArrayList<Double> getAllItemPrices(String listXpath) {
        ArrayList<Double> itemPrices = new ArrayList<>();
        List<WebElement> stringPrices = driver.findElementsByXPath(listXpath);
        for(WebElement stringPrice : stringPrices){
            String priceWithRsd = stringPrice.getText();
            String price = priceWithRsd.substring(0, priceWithRsd.indexOf(",")).replace(".", "");
            print(price);
            itemPrices.add(Double.valueOf(price));
        }
        return itemPrices;
    }


    public InventoryItemPage getItemByIndex(int index) {
        List<WebElement> allItems = getAllItems();
        WebElement item = allItems.get(index);
        item.click();
        return new InventoryItemPage(driver);
    }

    public void clickZaDecuButton() {
        zaDecuButton.click();
    }

    public void clickOnBook(String itemName){
        assert isElementPresent(searchResultsList): "ERROR.Search result list not on page";
        List<WebElement> elements = driver.findElements(By.xpath(Strings.XPATH_SMRTNI_ISHODI_ATLETSKIH_POVREDA));
        assert elements.size() !=0 : "ERORR. Aray is empty.";
        elements.get(0).click();
    }



}

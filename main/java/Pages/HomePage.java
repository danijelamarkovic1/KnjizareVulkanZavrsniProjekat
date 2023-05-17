package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class HomePage extends BasePage{

    public HomePage(ChromeDriver driver) {
        super(driver);
        driver.get("https://www.knjizare-vulkan.rs/");
        print(("Home page"));
    }




}

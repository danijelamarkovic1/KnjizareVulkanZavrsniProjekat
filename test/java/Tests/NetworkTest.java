package Tests;

import Pages.BasePage;
import Pages.Strings;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NetworkTest extends BaseTests{


    /**
     * Test connect to social networks Facebook; Twitter; Instagram; TikTok
     *
     * Steps:
     * 1.Navigate to https://www.knjizare-vulkan.rs
     * 2.In footer in the right corner click button icon FACEBOOK
     * 3.In footer in the right corner click button icon TWITTER
     * 4.In footer in the right corner click button icon INSTAGRAM
     * 5.In footer in the right corner click button icon TIKTOK
     *
     * Expected results:
     * 2.Verify that user open FACEBOOK URL
     * 3.Verify that user open TWITTER URL
     * 4.Verify that user open INSTAGRAM URL
     * 5.Verify that user open TIKTOK URL
     *
     */

    @Test
    public void connectToFacebookTests() {
        ChromeDriver driver = openChromeDriver();
        try {

            //povezivanje na Facebook
            print("1.Navigate to https://www.knjizare-vulkan.rs");
            BasePage basePage = new BasePage(driver);
            basePage.clickOnFacebookLinkButton();
            basePage.sleep(5);
            print("2.Verify that user open FACEBOOK URL");
            assert isCurrentURLEqualTo(Strings.FACEBOOK_URL) : "ERROR." + "Not is open Facebook page.";
              } finally {
            driver.quit();
        }
    }
@Test
            public void connectToTwitterTests() {
                ChromeDriver driver = openChromeDriver();
                try {
                    BasePage basePage = new BasePage(driver);
                    basePage.clickTwitterLinkButton();
                    basePage.sleep(5);
                    print("3.Verify that user open TWITTER URL");
                    assert isCurrentURLEqualTo(Strings.TWITTER_URL) : "ERROR." + "Not is open Twitter page.";
                }finally {
                    driver.quit();
                }}


@Test
    public void conectToInstagramTests() {
       ChromeDriver driver = openChromeDriver();
        try {
            BasePage basePage = new BasePage(driver);
            basePage.clickOnInstagramLinkButton();
            basePage.sleep(5);
            print("4.Verify that user open INSTAGRAM URL");
            assert isCurrentURLEqualTo(Strings.INSTAGRAM_URL) : "ERROR." + "Not is open Instagram page.";
        }finally {
            driver.quit();
        }}
 @Test
    public void conectToTikTokTest(){
        ChromeDriver driver = new ChromeDriver();
        try{
            BasePage basePage = new BasePage(driver);
            basePage.clickTiktokButton();
            basePage.sleep(10 );
            print("5.Verify that user open TIKTOK URL");
            assert isCurrentURLEqualTo(Strings.TIKTOK_URL) : "ERROR." + "Not is open Tiktok page.";


        } finally {
           driver.quit();
        }
    }


}


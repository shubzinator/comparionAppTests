import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.URL;

public class comparisonTest {
    AndroidDriver driver;

    @BeforeTest
    public void setup() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "FA6C90301474");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
        capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
        capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void testOne()throws Exception{
        Thread.sleep(1000);
        //Skip sign in
        driver.findElement(By.id("com.amazon.mShop.android.shopping:id/skip_sign_in_button")).click();
        //Search for an iPad 3
        driver.findElement(By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text")).sendKeys("ipad 3"+"\n");
        Thread.sleep(1000);
        //Click the first iPad shown
        driver.findElement(By.id("com.amazon.mShop.android.shopping:id/rs_results_fast_track")).click();
        Thread.sleep(1000);
        //Print the ratings
        WebElement ratings = driver.findElementByXPath("//android.view.View[contains(@content-desc,'3. Used - Acceptable \n') and @index='12']");
        String printRating = ratings.getText();
        System.out.println("Ratings: " + printRating);
        Thread.sleep(1000);
        //Scroll down to other prices
        driver.swipe(39974,10421147,36840,1044963,1000);
        Thread.sleep(1000);
        //Click used and new
        driver.findElement(By.id("olp-link")).click();
        Thread.sleep(1000);
        //Print 3rd lowest price
        WebElement lowestPrice = driver.findElementByXPath("//android.view.View[contains(@resource-id,'acrCustomerReviewLink') and @index='0']");
        String printPrice = lowestPrice.getText();
        System.out.println("Ratings: " + printPrice);
        Thread.sleep(1000);

    }

    @AfterTest
    public void tearDown() throws Exception{
        driver.quit();
    }
}
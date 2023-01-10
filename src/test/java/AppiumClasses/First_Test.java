package AppiumClasses;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class First_Test {

    public AppiumDriver<WebElement> driver;
    public WebDriverWait wait;

    By categories = By.id("com.mobisoft.morhipo:id/categories");
    By searchBox = By.id("com.mobisoft.morhipo:id/searchET");
    By addToCard = By.id("com.mobisoft.morhipo:id/addToCartBtn");
    By forgotPassword = By.id("com.mobisoft.morhipo:id/forgotPasswordButton");
    By email = By.id("com.mobisoft.morhipo:id/emailET");
    By sendPassword = By.id("com.mobisoft.morhipo:id/sendPasswordButton");


    @BeforeTest
    public void beforeTest() {


        try {
            DesiredCapabilities cap = new DesiredCapabilities();

            cap.setCapability("deviceName", "Pixel_2");
            cap.setCapability("platformName", "Android");
            cap.setCapability("udid", "emulator-5554");
            cap.setCapability("platformVersion", "11.0");
            cap.setCapability("appPackage", "com.mobisoft.morhipo");
            cap.setCapability("appActivity", "com.mobisoft.morhipo.activities.MainActivity");
            cap.setCapability("skipUnlock", "true");
            cap.setCapability("noReset", "false");

            driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
            wait = new WebDriverWait(driver,10);
        }

        catch (MalformedURLException e) {
            System.out.println("Hatalı Olusturulmus URL İstisnası");
        }
    }

    @Test
    public void test(){

        bekle(3);
        // kategorilere tıklanır.
        WebElement categoriesBtn = driver.findElement(categories);
        categoriesBtn.click();
        bekle(3);
        // search box'a erkek parfüm yazılır.
        WebElement searchBoxInput = driver.findElement(searchBox);
        searchBoxInput.sendKeys("Erkek Parfüm");
        bekle(3);
        //iki defa Entera basılır
        driver.getKeyboard().pressKey(Keys.ENTER);
        driver.getKeyboard().releaseKey(Keys.ENTER);
        bekle(2);
        driver.getKeyboard().pressKey(Keys.ENTER);
        driver.getKeyboard().releaseKey(Keys.ENTER);
        bekle(3);
        // sepete ekleye tıklanır
        WebElement addToCardBtn = driver.findElement(addToCard);
        addToCardBtn.click();
        bekle(3);
        // sifremi unuttuma tıklanır
        WebElement forgotPasswordBtn = driver.findElement(forgotPassword);
        forgotPasswordBtn.click();
        bekle(3);
        // mail adresi girilir
        WebElement emailInput = driver.findElement(email);
        emailInput.sendKeys("ebubekir.sarigul@virgosol.com");
        bekle(3);
        // sifre gonder butonuna tıklanır
        WebElement sendPasswprdBtn = driver.findElement(sendPassword);
        sendPasswprdBtn.click();
        bekle(10);

    }

    private void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}

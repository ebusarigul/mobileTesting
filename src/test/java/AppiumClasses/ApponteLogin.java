package AppiumClasses;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ApponteLogin {

    public AppiumDriver<WebElement> driver;
    public WebDriverWait wait;

    By amazontext = By.id("mobi.appcent.apponte:id/btnIndividual");
    By uyeOl = By.id("mobi.appcent.apponte:id/ibRegister");
    By phoneNumber = By.id("mobi.appcent.apponte:id/etPhoneNumber");
    By sendCode = By.id("mobi.appcent.apponte:id/btnSendCode");

    @BeforeTest

    public void beforeTest() {


        try {
            DesiredCapabilities cap;
            cap = new DesiredCapabilities();

            cap.setCapability("deviceName", "Pixel 2 API 30");
            cap.setCapability("platformName", "Android");
            cap.setCapability("udid", "emulator-5554");
            cap.setCapability("platformVersion", "11.0");
            cap.setCapability("appPackage", "mobi.appcent.apponte");
            cap.setCapability("appActivity", "mobi.appcent.apponte.ui.activity.login.LoginActivity");
            cap.setCapability("skipUnlock", "true");
            cap.setCapability("noReset", "false");

            driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            wait = new WebDriverWait(driver, 10);


        } catch (MalformedURLException test) {
            System.out.println("Hatalı");
        }
    }

    @Test

    public void test() throws InterruptedException {

        Thread.sleep(3000);
        WebElement consultantSelect = driver.findElement(amazontext);
        consultantSelect.click();
        Thread.sleep(3000);
        WebElement uyeOlBtn = driver.findElement(uyeOl);
        uyeOlBtn.click();
        Thread.sleep(3000);
        WebElement phoneNumberInput = driver.findElement(phoneNumber);
        phoneNumberInput.click();
        phoneNumberInput.sendKeys("5523109553");
        Thread.sleep(3000);
        WebElement sendCodeBtn = driver.findElement(sendCode);
        Thread.sleep(3000);
        sendCodeBtn.click();
        Thread.sleep(20000);

    }

}

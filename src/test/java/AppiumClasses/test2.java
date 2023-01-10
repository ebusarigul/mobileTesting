package AppiumClasses;

import com.vrgsl.qa.mobile.di.Injectable;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import javax.inject.Inject;

import java.net.MalformedURLException;
import java.net.URL;

public class test2 implements Injectable {

    public AppiumDriver<WebElement> driver;
    public WebDriverWait wait;
    @Inject
    MobileDriver mobileDriver;

    By girisYap = By.xpath("//android.widget.Button[@content-desc=\"Giriş Yap\"]");
    By email = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]");
    By password = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]");
    By girisYapButonu = By.xpath("//android.widget.Button[@content-desc=\"Giriş Yap\"]");

    @BeforeTest
    public void beforeTest() {


        try {
            DesiredCapabilities cap = new DesiredCapabilities();

            cap.setCapability("deviceName", "1fd655780709");
            cap.setCapability("platformName", "Android");
            cap.setCapability("udid", "emulator-5554");
            cap.setCapability("platformVersion", "11.0");
            cap.setCapability("appPackage", "tr.com.biscozum.expensemobile");
            cap.setCapability("appActivity", "tr.com.biscozum.expensemobile.MainActivity");
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
        // giris yap a tıklanır
        WebElement girisYapBtn = driver.findElement(girisYap);
        girisYapBtn.click();
        bekle(3);
        // email girilir
        WebElement emailInput = driver.findElement(email);
        emailInput.click();
        bekle(2);
        emailInput.sendKeys("goktasbesra@gmail.com");
        bekle(3);
        // sifre girilir
        WebElement passwordInput = driver.findElement(password);
        passwordInput.click();
        bekle(2);
        passwordInput.sendKeys("Asd1234.");
        bekle(3);
        // giris yap a tıklanır
        WebElement loginBtn = driver.findElement(girisYapButonu);
        loginBtn.click();
        bekle(10);



    }

    private void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void PhoneBackButton() {

    }


}

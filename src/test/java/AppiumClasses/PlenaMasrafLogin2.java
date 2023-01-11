package AppiumClasses;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class PlenaMasrafLogin2 {

    public AndroidDriver<AndroidElement> driver;
    public WebDriverWait wait;

    By girisYap = By.xpath("//android.widget.Button[@content-desc=\"Giriş Yap\"]");
    By email = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]");
    By password = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]");
    By girisYapButonu = By.xpath("//android.widget.Button[@content-desc=\"Giriş Yap\"]");

    @BeforeTest
    public void beforeTest() {


        try {
            DesiredCapabilities cap = new DesiredCapabilities();

            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UIAutomator2");
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
            cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel_2");
            cap.setCapability(MobileCapabilityType.APP,"/Users/user/Desktop/app-debug.apk");
            cap.setCapability(MobileCapabilityType.NO_RESET,"true");

            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
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
        passwordInput.sendKeys("Abcd1234.");
        bekle(3);
        // giris yap a tıklanır
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        bekle(3);
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


}

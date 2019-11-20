package test;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.BasketPage;
import pages.CategoriesPage;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase  {
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    public LoginPage loginPage;
    public CategoriesPage categoriesPage;
    public BasePage basePage;
    public BasketPage basketPage;

    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Nexus 5 API 27");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.1.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.getir.getirtestingcasestudy");
        caps.setCapability("appActivity", "com.getir.getirtestingcasestudy.ui.login.LoginActivity");
        caps.setCapability("noReset", "true");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 35);

        createAppObjects();
    }

    public void createAppObjects() {
        loginPage = new LoginPage(driver);
        categoriesPage = new CategoriesPage(driver);
        basePage = new BasePage(driver);
        basketPage = new BasketPage(driver);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
